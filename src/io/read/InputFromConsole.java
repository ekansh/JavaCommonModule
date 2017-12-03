package io.read;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputFromConsole {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		String read = bufferedReader.readLine();
		System.out.println(read);
	}
}
