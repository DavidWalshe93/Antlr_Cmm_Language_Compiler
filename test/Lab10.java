import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import types.FunctionType;

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

//    @AfterAll
//    static void afterAll() throws InterruptedException {
//        Program ast = Main_Lab_05.createAST(testPath);
//        ast = Main_Lab_05.runSemanticAnalysis(ast);
//	    ast = Main_Lab_05.runOffsetCodeGeneration(ast);
//
//        IntrospectorModel model = new IntrospectorModel("Program", ast);
//        new IntrospectorTree("Introspector", model, 800, 1000, 1, 8);
//        while (true) {
//            Thread.sleep(2000);
//        }
//    }

    @BeforeEach
    void setUp() {
	    ast = Main_Lab_05.createAST(testPath, true);
        ast = Main_Lab_05.runSemanticAnalysis(ast);
	    ast = Main_Lab_05.runOffsetCodeGeneration(ast);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Global variable tests
     **/

    @Test
    void globalsOffset() {
        assertEquals(10, ast.getDefinitions().size());
        assertEquals(0, ast.getDefinitions().get(CodeSegment.GLOBAL_GI.getPositionCode()).getOffset());
        assertEquals(2, ast.getDefinitions().get(CodeSegment.GLOBAL_GD.getPositionCode()).getOffset());
        assertEquals(6, ast.getDefinitions().get(CodeSegment.GLOBAL_GC.getPositionCode()).getOffset());
    }

    /**
     * Function f Tests
     **/

    @ParameterizedTest(name = "Verifying f() parameter {0} has an offset of {1}")
    @CsvSource({"0, 9",
            "1, 5",
            "2, 4"})
    void fParamOffsets(int index, int expected) {
        FunctionDefinition f = ((FunctionDefinition) ast.getDefinitions().get(CodeSegment.FUNC_F.getPositionCode()));
        FunctionType fType = (FunctionType) f.getType();
        assertEquals(3, fType.getParameters().size());

        assertEquals(expected, fType.getParameters().get(index).getOffset());
    }

    @ParameterizedTest(name = "Verifying f() local variable {0} has an offset of {1}")
    @CsvSource({
		    "0, -4",  //-11
		    "1, -6,", //-9
		    "2, -7"   //-8
    })
    void fLocalOffsets(int index, int expected) {
        FunctionDefinition f = ((FunctionDefinition) ast.getDefinitions().get(CodeSegment.FUNC_F.getPositionCode()));
        assertEquals(7, f.getBody().size());
        assertEquals(expected, ((VariableDefinition) f.getBody().get(index)).getOffset());
    }

    @Test
    void fReturnOffset() {
        assertEquals(2, ((FunctionDefinition) ast.getDefinitions().get(CodeSegment.FUNC_F.getPositionCode())).getReturnType().numberOfBytes());
    }

    /**
     * Function temp Tests
     **/

    @ParameterizedTest(name = "Verifying temp() parameter {0} has an offset of {1}")
    @CsvSource({"0, 20",
            "1, 16",
            "2, 14",
            "3, 10",
            "4, 9",
            "5, 8",
            "6, 4"})
    void tempParamOffsets(int index, int expected) {
        FunctionDefinition temp = ((FunctionDefinition) ast.getDefinitions().get(CodeSegment.FUNC_TEMP.getPositionCode()));
        FunctionType tempType = (FunctionType) temp.getType();
        assertEquals(expected, tempType.getParameters().get(index).getOffset());
    }

	@ParameterizedTest(name = "Verifying temp() local variable {2} has an offset of {1}")
    @CsvSource({
            "0, -2, la",
            "1, -3, lb",
            "2, -7, lc",
            "3, -9, ld",
            "4, -34, myDate",
            "5, -35, le",
            "6, -39, lf",
    })
    void tempLocalOffsets(int index, int expected, String varName) {
        FunctionDefinition temp = ((FunctionDefinition) ast.getDefinitions().get(CodeSegment.FUNC_TEMP.getPositionCode()));
        assertEquals(expected, ((VariableDefinition) temp.getBody().get(index)).getOffset());
    }

    @Test
    void tempReturnOffset() {
        FunctionDefinition temp = ((FunctionDefinition) ast.getDefinitions().get(CodeSegment.FUNC_TEMP.getPositionCode()));
        assertEquals(2, temp.getReturnType().numberOfBytes());
    }

    /**
     * Function main Tests
     **/

    @Test
    void mainParamOffsets() {
        assertEquals(0, ((FunctionType) ast.getDefinitions().get(CodeSegment.FUNC_MAIN.getPositionCode()).getType()).getParameters().size());
    }

    @ParameterizedTest(name = "Verifying main() local variable {0} has an offset of {1}")
    @CsvSource({
            "0, -4",
            "1, -6,",
            "2, -7",
    })
    void mainLocalOffsets(int index, int expected) {
        FunctionDefinition main = ((FunctionDefinition) ast.getDefinitions().get(CodeSegment.FUNC_MAIN.getPositionCode()));
        assertEquals(10, main.getBody().size());
        assertEquals(expected, ((VariableDefinition) main.getBody().get(index)).getOffset());
    }

    @Test
    void mainReturnOffset() {
        FunctionDefinition main = ((FunctionDefinition) ast.getDefinitions().get(CodeSegment.FUNC_MAIN.getPositionCode()));
        assertEquals(0, main.getReturnType().numberOfBytes());
    }

    private enum CodeSegment {
        GLOBAL_GI(0),
        GLOBAL_GD(1),
        GLOBAL_GC(2),
        GLOBAL_SYMBOL(3),
        GLOBAL_LOCATION(4),
        GLOBAL_TIME(5),
        GLOBAL_DATE(6),
        FUNC_F(7),
        FUNC_TEMP(8),
        FUNC_MAIN(9);

        private final int positionCode;

        CodeSegment(int positionCode) {
            this.positionCode = positionCode;
        }

        public int getPositionCode() {
            return positionCode;
        }
    }

}