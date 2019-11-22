import ast.Program;
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

//        IntrospectorModel model = new IntrospectorModel("Program", createAST(args[0]));
//        System.out.println(model);
//        new IntrospectorTree("Introspector", model);

        Program ast = createAST(args[0]);
        ast = runSemanticAnalysis(ast);

        IntrospectorModel model = new IntrospectorModel("Program", ast);
        new IntrospectorTree("Introspector", model);

    }

    private static Program createAST(String input_file) {
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

    private static Program runSemanticAnalysis(Program ast) {
        if (ast != null) {
            // * The AST is traversed
            ast.accept(new IdentificationVisitor(), null);
            ast.accept(new TypeCheckingVisitor(), null);

            if (ErrorHandler.getErrorHandler().anyError()) {
                ErrorHandler.getErrorHandler().showErrors(System.err);
                System.err.println("Program with semantic errors. No code was generated.");
                exit();
            }

            System.out.println("Semantic Analysis complete.");

        } else {
            System.err.println("AST is null, cannot run semantic analysis");
            exit();
        }

        return ast;
    }
}
