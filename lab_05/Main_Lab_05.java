import ast.Program;
import codegeneration.cg.CodeGenerator;
import codegeneration.cg.ExecuteCGVisitor;
import codegeneration.offset.OffsetVisitor;
import errorhandler.ErrorHandler;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.CmmLexer;
import parser.CmmParser;
import semantic.IdentificationVisitor;
import semantic.TypeCheckingVisitor;

import java.io.IOException;

import static javafx.application.Platform.exit;

/**
 * Author: David Walshe
 * Date: 19/10/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class Main_Lab_05 {

    public static void main(String... args) {
        if (args.length < 1) {
            System.err.println("Please, pass me the input file.");
            return;
        }

        Program ast = createAST(args[0]);
        ast = runSemanticAnalysis(ast);
	    ast = runOffsetCodeGeneration(ast);

	    System.out.println(ast.getDefinitions().get(0).getClass().getSimpleName());

        IntrospectorModel model = new IntrospectorModel("Program", ast);
        new IntrospectorTree("Introspector", model, 800, 1000, 1, 8);

    }


    public static Program createAST(String input_file) {
        try {
            // create a lexer that feeds off of input CharStream
            CharStream input = CharStreams.fromFileName(input_file);
            CmmLexer lexer = new CmmLexer(input);

            // create a parser that feeds off the tokens buffer
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CmmParser parser = new CmmParser(tokens);

            Program ast = parser.program().ast;

            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.err.println("Program with syntax errors. No code was generated.");
                exit();
            }
            System.out.println("Syntactical Analysis complete.");
            return ast;

        } catch (IOException e) {
            System.out.println(String.format("Couldn't find input file %s. Error: %s", input_file, e));
            exit();
        }
        return null;
    }

    public static Program runSemanticAnalysis(Program ast) {
        verifyAstIsNotNull(ast, "AST was null during semantic analysis phase");
        ast.accept(new IdentificationVisitor(), null);
        ast.accept(new TypeCheckingVisitor(), null);

        if (ErrorHandler.getErrorHandler().anyError()) {
            ErrorHandler.getErrorHandler().showErrors(System.err);
            System.err.println("Program with semantic errors. No code was generated.");
            exit();
        }

        System.out.println("Semantic Analysis complete.");

        return ast;
    }

	public static Program runOffsetCodeGeneration(Program ast) {
		verifyAstIsNotNull(ast, "AST was null during offset annotation phase");
		ast.accept(new OffsetVisitor(), null);

		System.out.println("Offset annotation complete.");

		return ast;
	}

	public static Program runCodeGeneration(Program ast, String targetFile, String sourceFile) {
		verifyAstIsNotNull(ast, "AST was null during code generation phase");
		CodeGenerator codeGenerator = new CodeGenerator(targetFile, sourceFile);
		ast.accept(new ExecuteCGVisitor(codeGenerator), null);

		return ast;
	}

    public static void verifyAstIsNotNull(Program ast, String errorMsg) {
        if (ast == null) {
            System.err.println(errorMsg);
            System.exit(-1);
        }
    }
}
