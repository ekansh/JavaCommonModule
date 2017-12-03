package serialization_deserailization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class serializationTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Employee e = new Employee();
		e.empName = "jhfbkjdfn";
		e.SSN = 123456;
		
		FileOutputStream fileout = new FileOutputStream("res/fileemp.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileout);
		out.writeObject(e);
		out.close();
		fileout.close();
		
		FileInputStream fileinpu = new FileInputStream("res/fileemp.ser");
		ObjectInputStream in = new ObjectInputStream(fileinpu);
		Employee readObject = (Employee)in.readObject();
		System.out.println(readObject.empName);
		System.out.println(readObject.SSN);
	}

}

class Employee implements Serializable{
	public String empName;
	public transient int SSN;
	
}