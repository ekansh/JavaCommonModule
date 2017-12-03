package lambdas;

public class LambdaTest {
	int z= 23;
	public static void main(String[] args) {
		
		
		
//		AFunctional f = (z)-> z+1; // this will lead to 
		AFunctional f = (z)-> {
						System.out.println("fsda");
						return z+1;
					};
		fx(f);
	}
	public static void fx(AFunctional f){
		int doSomething = f.doSomething(4);
		System.out.println(doSomething);
	}
}

interface AFunctional{
	public int doSomething(int z);
}
