package reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflectioneg {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class c = Employee.class;
		
		Method method = c.getMethod("printname", null);
		
		Employee newEmp = new Employee();
		Class<?> type = method.getReturnType();
		System.out.println(type);
		Boolean typee = (Boolean) method.invoke(newEmp, null);
		System.out.println(typee);
		Object invoke = method.invoke(newEmp, null);
		System.out.println(invoke);
	}
	
	

}

class Employee {

	public Boolean printname() {
		System.out.println("All employee names");
		return true;
	}
	
	
}