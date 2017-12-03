package streams;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateTest {
	int x=1;
public static void main(String[] args) {
	System.out.println("Introduction");
	List<Integer> asList = Arrays.asList(1,2,3,4,10,22,21,33,27,11);
	asList.stream().filter( (e)->e<4).
	forEach((e)-> System.out.println(e) )// Predicate : take a value and return boolean 
//	.forEach((e)-> e=0 )// Consumer: consumes/take a value and perform an action on it.
	;
	
	asList.stream().collect(Collectors.toList()); // collector example
    Double result = Stream.of(1,2,3,4).collect(Collectors.averagingInt(v->v));
	System.out.println("arithmatic mean "+result);
	
	//find any
	System.out.println("using Optional , orElse, findAny");
	Optional<Integer> found = Stream.of(1,2,3,4,10,22,21,33,27,11).filter((e)->e%3==0).findAny();
	Integer orElse = found.orElse(24); // without optional  you will not be able to continue the chain
	System.out.println(orElse);
	//find any in parallel mode
	System.out.println("using parallel stream Optional  , orElse, findAny");
	Optional<Integer> foundParallel= asList.parallelStream().filter((e)->e%3==0).findAny();
	System.out.println("foundParallel "+foundParallel);
	
	// using Map and any match 
	System.out.println("using generate function reference map anyMatch");
	boolean anyMatch = Stream.generate(PredicateTest::getRandom).map((e)->e.doubleValue()).anyMatch((e)->e==3);
	System.out.println(anyMatch);
	//using flatMap
	System.out.println("using generate flatmap distinct sorted collect anyMatch");
	Map<Integer,List<String>> myMap = new HashMap<>();
	myMap.put(1, Arrays.asList("hello","world","Super"));
	myMap.put(2, Arrays.asList("Hello","PWorld","ss"));
	myMap.put(3, Arrays.asList("YO","ss","DO"));
	myMap.put(4, Arrays.asList("ss","TT","HH"));
	
	String collect = myMap.keySet().stream().filter((e)->e%2==0)
			.flatMap((e)-> myMap.get(e).stream())
			.distinct().sorted().collect(Collectors.joining(","));
	System.out.println(collect);
	
	System.out.println("using generate function SUPPLIER reference limit reduce");
	Integer reduce = Stream.generate(PredicateTest::getRandom).limit(5).reduce(-10, Integer::max);
	System.out.println("MAX value "+reduce);
	
}
public static int getRandom(){
	return (int)(Math.random()*100);
}
}
