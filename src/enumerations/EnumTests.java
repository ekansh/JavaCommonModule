package enumerations;

public class EnumTests {
public static void main(String[] args) {
	Day d =Day.MONDAY ;
	System.out.println("ordinal "+d.ordinal());
	System.out.println(d.getTypeOfDay());
	if(d instanceof Day){
		System.out.println(d.getClass());
		System.out.println(d.getDeclaringClass());
	}
}
}


