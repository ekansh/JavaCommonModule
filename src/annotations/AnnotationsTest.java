package annotations;

import java.lang.reflect.Field;

public class AnnotationsTest {
	@CheckNotNull
	String myMessage;
	public static void main(String[] args)  {
		AnnotationsTest t= new 
				AnnotationsTest();
		
		Field[] fields = t.getClass().getDeclaredFields();
		for (Field field : fields) {
			boolean annotationPresent = field.isAnnotationPresent(CheckNotNull.class);
			if (annotationPresent){
				if (t.myMessage==null){
					System.out.println("Null value present");
				}
			}
		}
		
	} 
	
}
