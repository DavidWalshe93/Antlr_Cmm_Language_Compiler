import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.statements.Statement;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import types.FunctionType;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author: David Walshe
 * Date: 14/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

class Lab10 {

    private static Program ast;
    private static String testPath = "lab_10\\test.txt";

    @AfterAll
    static void afterAll() throws InterruptedException {
        Program ast = Main_Lab_05.createAST(testPath);
        ast = Main_Lab_05.runSemanticAnalysis(ast);
        ast = Main_Lab_05.runOffsetCodeCodeGeneration(ast);

        IntrospectorModel model = new IntrospectorModel("Program", ast);
        new IntrospectorTree("Introspector", model, 800, 1000, 1, 8);
        while (true) {
            Thread.sleep(2000);
        }
    }

    @BeforeEach
    void setUp() {
        ast = Main_Lab_05.createAST(testPath);
        ast = Main_Lab_05.runSemanticAnalysis(ast);
        ast = Main_Lab_05.runOffsetCodeCodeGeneration(ast);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Global variable tests
     **/

    @Test
    void globalsOffset() {
        assertEquals(7, ast.getDefinitions().size());
        assertEquals(0, ast.getDefinitions().get(Position.GLOBAL_GI.getPositionCode()).getOffset());
        assertEquals(2, ast.getDefinitions().get(Position.GLOBAL_GD.getPositionCode()).getOffset());
        assertEquals(6, ast.getDefinitions().get(Position.GLOBAL_GC.getPositionCode()).getOffset());
    }

    /**
     * Function f Tests
     **/

    @Test
    void fParamOffsets() {
        assertEquals(3, ((FunctionType) ast.getDefinitions().get(Position.FUNC_F.getPositionCode()).getType()).getParameters().size());
        assertEquals(0, ((FunctionType) ast.getDefinitions().get(Position.FUNC_F.getPositionCode()).getType()).getParameters().get(0).getOffset());
        assertEquals(2, ((FunctionType) ast.getDefinitions().get(Position.FUNC_F.getPositionCode()).getType()).getParameters().get(1).getOffset());
        assertEquals(6, ((FunctionType) ast.getDefinitions().get(Position.FUNC_F.getPositionCode()).getType()).getParameters().get(2).getOffset());
    }

    @Test
    void fLocalOffsets() {
        ArrayList<Statement> f = ((FunctionDefinition) ast.getDefinitions().get(Position.FUNC_F.getPositionCode())).getBody();
        assertEquals(7, f.size());
        assertEquals(0, ((VariableDefinition) f.get(0)).getOffset());
        assertEquals(-4, ((VariableDefinition) f.get(1)).getOffset());
        assertEquals(-6, ((VariableDefinition) f.get(2)).getOffset());
    }

    @Test
    void fReturnOffset() {
        assertEquals(2, ((FunctionDefinition) ast.getDefinitions().get(Position.FUNC_F.getPositionCode())).getReturnType().numberOfBytes());
    }

    /**
     * Function temp Tests
     **/

    @Test
    void tempParamOffsets() {
        FunctionDefinition temp = ((FunctionDefinition) ast.getDefinitions().get(Position.FUNC_TEMP.getPositionCode()));
        FunctionType tempType = (FunctionType) temp.getType();
        int[] expected = {0, 4, 8, 10, 14, 15, 16};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], tempType.getParameters().get(i).getOffset());
        }
    }

    @Test
    void tempLocalOffsets() {
        FunctionDefinition temp = ((FunctionDefinition) ast.getDefinitions().get(Position.FUNC_TEMP.getPositionCode()));
        int[] expected = {0, -2, -3, -7, -9, -10};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], ((VariableDefinition) temp.getBody().get(i)).getOffset());
        }
    }

    @Test
    void tempReturnOffset() {
        FunctionDefinition temp = ((FunctionDefinition) ast.getDefinitions().get(Position.FUNC_TEMP.getPositionCode()));
        assertEquals(2, temp.getReturnType().numberOfBytes());
    }

    /**
     * Function main Tests
     **/

    @Test
    void mainParamOffsets() {
        assertEquals(0, ((FunctionType) ast.getDefinitions().get(Position.FUNC_MAIN.getPositionCode()).getType()).getParameters().size());
    }

    @Test
    void mainLocalOffsets() {
        ArrayList<Statement> main = ((FunctionDefinition) ast.getDefinitions().get(Position.FUNC_MAIN.getPositionCode())).getBody();
        assertEquals(10, main.size());
        assertEquals(0, ((VariableDefinition) main.get(0)).getOffset());
        assertEquals(-4, ((VariableDefinition) main.get(1)).getOffset());
        assertEquals(-6, ((VariableDefinition) main.get(2)).getOffset());
    }

    @Test
    void mainReturnOffset() {
        FunctionDefinition main = ((FunctionDefinition) ast.getDefinitions().get(Position.FUNC_MAIN.getPositionCode()));
        assertEquals(0, main.getReturnType().numberOfBytes());
    }

    private enum Position {
        GLOBAL_GI(0),
        GLOBAL_GD(1),
        GLOBAL_GC(2),
        GLOBAL_DATE(3),
        FUNC_F(4),
        FUNC_TEMP(5),
        FUNC_MAIN(6);

        private final int positionCode;

        Position(int positionCode) {
            this.positionCode = positionCode;
        }

        public int getPositionCode() {
            return positionCode;
        }
    }

}