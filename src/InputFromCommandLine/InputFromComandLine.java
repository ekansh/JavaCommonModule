package InputFromCommandLine;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputFromComandLine {
	public static void main(String[] args) {
		InputStream in = System.in;
		Scanner sc = new Scanner(in);
		try {
		String next = sc.next();
		Integer intValue = Integer.valueOf(next);
		Double doubleVal = Double.valueOf(next);
		System.out.println(intValue+"InputFromComandLine.main()"+next+" "+doubleVal);
		} catch (InputMismatchException e){
			System.out.println("InputFromComandLine.main().InputMismatch");
			e.printStackTrace();
		} catch (NumberFormatException e){
			System.out.println("InputFromComandLine.main().NumberFormat");
			e.printStackTrace();
		}finally {
			System.out.println("Performing the final work");
			
		}
		
		System.out.println("Exiting Program..");
	}
}
