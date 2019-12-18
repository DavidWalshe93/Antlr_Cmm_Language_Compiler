import ast.Program;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Author: David Walshe
 * Date: 18/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class Lab12a {

	private static Program ast;
	private static String sourcePath = "lab_12\\ex1\\input-1.txt";
	private static String targetPath = "lab_12\\ex1\\test_output-1.txt";
	private static String comparisonPath = "lab_12\\ex1\\output-1.txt";

	private static ArrayList<String> comparisonContent;
	private static ArrayList<String> outputContent;

	@AfterAll
	static void afterAll() throws InterruptedException {
//        Program ast = Main_Lab_05.createAST(sourcePath);
//        ast = Main_Lab_05.runSemanticAnalysis(ast);
//        ast = Main_Lab_05.runOffsetCodeGeneration(ast);
//        ast = Main_Lab_05.runCodeGeneration(ast, targetPath, sourcePath);
//
//        IntrospectorModel model = new IntrospectorModel("Program", ast);
//        new IntrospectorTree("Introspector", model, 800, 1000, 1, 8);
//        while (true) {
//            Thread.sleep(2000);
//        }
	}

	@BeforeAll
	static void beforeAll() {
		Program ast = Main_Lab_05.createAST(sourcePath);
		ast = Main_Lab_05.runSemanticAnalysis(ast);
		ast = Main_Lab_05.runOffsetCodeGeneration(ast);
		ast = Main_Lab_05.runCodeGeneration(ast, targetPath, sourcePath);

		outputContent = readFile(targetPath);
		comparisonContent = readFile(comparisonPath);
	}

	static ArrayList<String> readFile(String path) {
		File targetFile = new File(path);
		ArrayList<String> returnList = new ArrayList<>();
		if (targetFile.exists()) {

			try (BufferedReader in = new BufferedReader(new FileReader(targetFile))) {

				returnList = new ArrayList<String>();
				String line;
				while ((line = in.readLine()) != null) {
					returnList.add(line);
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		} else {
			System.out.println(targetFile.getAbsoluteFile() + " doesn't exist");
		}

		return returnList;
	}

	@DisplayName("Testing line")
	@RepeatedTest(value = 212, name = "{displayName} - {currentRepetition}")
	void testSource(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		try {
			int i = repetitionInfo.getCurrentRepetition();
			System.out.println(comparisonContent.get(i - 1));
			assertEquals(comparisonContent.get(i - 1), outputContent.get(i - 1));
		} catch (IndexOutOfBoundsException err) {
			System.err.println("Verify the relative code is in input.txt\n" + err.toString());
			fail();
		}
	}

}
