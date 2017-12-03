package io.write;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileWriter {
	public static void main(String[] args) {
		String fileName = "res/input1.txt";

		try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName))) {

			String line="hello ";
			br.write(line);
			br.write(line+"world");
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
