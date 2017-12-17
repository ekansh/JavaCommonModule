package exceptions;

import java.io.IOException;

public class ThrowingExceptionExample extends ParentClassOfThrowingExceptionExample {
	public void throwsException() throws IOException {
		int a = 9;
		if (a == 2) {
			throw new IOException();
		}
	}
}

class ParentClassOfThrowingExceptionExample {
	public void throwsException() throws Exception {
	}
}

