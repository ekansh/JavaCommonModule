package Generics;

import java.util.List;

public class PECS {

	public static void main(String[] args) {
		
	}
	public void doSomething1(List<? extends Car> cars){
		//cars.add(new Merc());// NOt possible
	}
	public void doSomething2(List<? super Car> cars){
		cars.add(new Merc());
		Object object = cars.get(0);
	}
}
class Car{}
class BMW extends Car{}
class Merc extends Car{}
