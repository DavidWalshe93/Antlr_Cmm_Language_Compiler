import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Author: David Walshe
 * Date: 18/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class Lab12b {

	private static String sourcePath = "lab_12\\ex2\\input-2.txt";
	private static String targetPath = "lab_12\\ex2\\test_output-2.txt";
	private static String comparisonPath = "lab_12\\ex2\\output-2.txt";

	private static final int fileSize = 482;

	@AfterAll
	static void afterAll() throws InterruptedException {
		//TestInitializer.runIntrospector();
	}

	@BeforeAll
	static void beforeAll() {
		try {
			TestInitializer.runCompiler(sourcePath, targetPath, comparisonPath);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@DisplayName("Testing line")
	@RepeatedTest(value = fileSize, name = "{displayName} - {currentRepetition}")
	void testSource(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		try {
			int i = repetitionInfo.getCurrentRepetition();
			assertEquals(TestInitializer.getComparisonContent().get(i - 1), TestInitializer.getOutputContent().get(i - 1));
		} catch (IndexOutOfBoundsException err) {
			System.err.println("Verify the relative code is in input.txt\n" + err.toString());
			fail();
		}
	}

}
