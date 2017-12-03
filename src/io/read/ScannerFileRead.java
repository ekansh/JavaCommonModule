package io.read;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerFileRead {
public static void main(String[] args) {
	String fileName = "res/input.txt";

	try (Scanner scanner = new Scanner(new File(fileName))) {

		while (scanner.hasNextLine()){
			System.out.println(scanner.nextLine());
		}

	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
