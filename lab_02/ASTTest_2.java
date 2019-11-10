///**
// * Author: David Walshe
// * Date: 08/10/2019
// * Subject: Programming Language Design
// * Program: Software Architecture and Design
// * College: Cork Institute of Technology
// */
//
//import ast.*;
//import ast.definitions.ArrayDefinition;
//import ast.definitions.Definition;
//import ast.definitions.FuncDefinition;
//import ast.definitions.VarDefinition;
//import ast.expressions.Arithmetic;
//import ast.expressions.Cast;
//import ast.expressions.RealLiteral;
//import ast.expressions.Variable;
//import ast.statements.*;
//import types.*;
//import introspector.view.IntrospectorTree;
//import introspector.model.IntrospectorModel;
//
//import java.util.*;
//
//public class ASTTest_2 {
//
//    /**
//     * Builds an AST and shows it with the Introspector tool.
//     * The input program is:
//     *   void main() {
//     *     int a;
//     *     double b;
//     *     int i[10];
//     *     double j[5][7];
//     *     read a;
//     *     b = (double)a + b*2.2;
//     *     write b;
//     *   }
//     */
//    private static ASTNode createAST() {
//        // * Line 2
//        VarDefinition varDef1 = new VarDefinition(2, 3, "a", new IntType(2, 3));
//        // * Line 3
//        VarDefinition varDef2 = new VarDefinition(3, 3, "b", new RealType(2, 3));
//        // * Line 4
//        ArrayType arrType1 = new ArrayType(new IntType(1, 1), 10);
//        ArrayDefinition arrDef1 = new ArrayDefinition(4, 3, "i", arrType1);
//
//        ArrayType arrType2 = new ArrayType(arrType1,20);
//        ArrayDefinition arrDef2 = new ArrayDefinition(4, 3, "j", arrType2);
//
//        Read read = new Read(4, 3, new Variable(4, 8, "a"));
//        // * Line 5
//
//        Assignment assignment = new Assignment(5, 3,
//                new Variable(5, 3, "b"),
//                new Arithmetic(5, 3, new Cast(5, 7, new RealType(5, 7), new Variable(5, 15, "a")),
//                        "+",
//                        new Arithmetic(5, 19, new Variable(5, 19, "b"),
//                                "*",
//                                new RealLiteral(5, 21, 2.2))
//                )
//        );
//        // * Line 6
//        Write write = new Write(6, 3, new Variable(6, 9, "b"));
//        // * We build and return the AST
//        FunctionType mainType = new FunctionType(1, 1, new VoidType(1, 1), new ArrayList<VarDefinition>());
//        ArrayList<Statement> mainBody = new ArrayList<Statement>(Arrays.asList(varDef1, varDef2, arrDef1, arrDef2, read, assignment, write));
//        FuncDefinition funcDefinition = new FuncDefinition(1, 1, "main", mainType, mainBody);
//        return new Program(1, 1, new ArrayList<Definition>(Arrays.asList(funcDefinition)), new ArrayList<Statement>());
//        //return new Program(1, 1, new ArrayList<Definition>(), new ArrayList<>());
//    }
//
//    public static void main(String[] args) {
//        IntrospectorModel model = new IntrospectorModel("Program", createAST());
//        new IntrospectorTree("Introspector", model);
//    }
//}
