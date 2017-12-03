package io.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileUsingInputStream {
public static void main(String[] args) {
	try(FileInputStream fis = new FileInputStream(new File("res/input.txt"))){
		int content;
		while ((content = fis.read()) != -1) {
			// convert to char and display it
			System.out.println((char) content);
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
