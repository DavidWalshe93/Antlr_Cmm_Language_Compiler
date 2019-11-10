import ast.Program;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.CmmLexer;
import parser.CmmParser;

import java.io.IOException;

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

        IntrospectorModel model = new IntrospectorModel("Program", createAST(args[0]));
        System.out.println(model);
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


            return parser.program().ast;
        } catch (IOException e) {
            System.out.println(String.format("Couldn't find input file %s. Error: %s", input_file, e));
        }
        return null;
    }
}
