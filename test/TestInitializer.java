import ast.Program;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;

import java.io.*;
import java.util.ArrayList;

/**
 * Author: David Walshe
 * Date: 19/12/2019
 * Subject: Programming Language Design
 * Program: Software Architecture and Design
 * College: Cork Institute of Technology
 */

public class TestInitializer {

	private static String sourcePath;
	private static String targetPath;
	private static String comparisonPath;

	public static void main(String[] args) {
		try (PrintWriter out = new PrintWriter("test\\testCompilation.cmd")) {
			out.print("");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}

	static void runCompiler(String srcPath, String tarPath, String compPath) {
		sourcePath = srcPath;
		targetPath = tarPath;
		comparisonPath = compPath;

		Program ast = Main_Lab_05.createAST(sourcePath, false);
		ast = Main_Lab_05.runSemanticAnalysis(ast);
		ast = Main_Lab_05.runOffsetCodeGeneration(ast);
		Main_Lab_05.runCodeGeneration(ast, targetPath, sourcePath);
		buildCompileFile();
	}

	static void setPaths(String srcPath, String tarPath, String compPath) {
		sourcePath = srcPath;
		targetPath = tarPath;
		comparisonPath = compPath;
	}

	static void runIntrospector() throws InterruptedException {
		Program ast = Main_Lab_05.createAST(sourcePath, true);
		ast = Main_Lab_05.runSemanticAnalysis(ast);
//		ast = Main_Lab_05.runOffsetCodeGeneration(ast);

		IntrospectorModel model = new IntrospectorModel("Program", ast);
		new IntrospectorTree("Introspector", model, 800, 1000, 1, 8);
		while (true) {
			Thread.sleep(2000);
		}
	}

	static void buildCompileFile() {
		try (FileWriter fr = new FileWriter("test\\testCompilation.cmd", true);
		     PrintWriter out = new PrintWriter(fr)) {
			out.println("echo " + targetPath);
			out.println("TextVM.exe " + targetPath);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static ArrayList<String> getOutputContent() {
		return readFile(targetPath);
	}

	static ArrayList<String> getComparisonContent() {
		return readFile(comparisonPath);
	}

	static int getOutputContentSize() {
		return readFile(targetPath).size();
	}

	static int getComparisonContentSize() {
		return readFile(comparisonPath).size();
	}

	private static ArrayList<String> readFile(String path) {
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
				System.out.println(e.toString());
			}
		} else {
			System.out.println(targetFile.getAbsoluteFile() + " doesn't exist");
		}

		return returnList;
	}
}
