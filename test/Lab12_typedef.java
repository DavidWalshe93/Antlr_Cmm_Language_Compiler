import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Author: David Walshe
 * Date: 20/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class Lab12_typedef {

	private static final int fileSize = 408;
	private static String sourcePath = "lab_12/extra_features/type_defs/input.txt";
	private static String targetPath = "lab_12/extra_features/type_defs/test-output.txt";
	private static String comparisonPath = "lab_12/extra_features/type_defs/output.txt";

	@AfterAll
	static void afterAll() throws InterruptedException {
//		TestInitializer.setPaths(sourcePath, targetPath, comparisonPath);
//		TestInitializer.runIntrospector();
	}

	@BeforeAll
	static void beforeAll() {
		try {
			TestInitializer.runCompiler(sourcePath, targetPath, comparisonPath);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Test
	void mockTest() {

	}

}
