package functions.genericFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import additionalClasses.Apple;

public class TestPredicate {
	
	List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red")); 
	
	public TestPredicate() {
		List<Apple> res = filterApples(inventory, TestPredicate::isGreenApple); 
		System.out.println("Apples (is green): "+res);
		res = filterApples(inventory, TestPredicate::isHeavyApple); 
		System.out.println("Apples (isHeavy): "+res);
		
		res = filterApples(inventory, (Apple a) -> "red".equals(a.getColor()) );
		System.out.println("Apples (is red): "+res);
		
		filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "red".equals(a.getColor()) );
		System.out.println("Apples (notHeavy&red): "+res);
	}
	
	
	List<Apple> filterApples (List<Apple> inv, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for(Apple ap: inv) {
			if(p.test(ap)) {
				result.add(ap);
			}
		}
		return result;
	}
	
	
	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}
	
	
	public static void main(String[] args) {
		new TestPredicate();
	}

}

//public inteface Predicate<T>  {
//	boolean test(T t);
//}

