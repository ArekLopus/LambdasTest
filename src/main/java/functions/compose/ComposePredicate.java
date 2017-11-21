package functions.compose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import additionalClasses.Apple;
import additionalClasses.User;

public class ComposePredicate {
	
	List<Apple> inv = Arrays.asList(new Apple(80, "green", "Poland"), new Apple(155, "green", "Germany"), new Apple(120, "red", "Greece")); 
	
	public ComposePredicate() {
		System.out.println("All apples:\t\t"+inv);
		
		Predicate<Apple> green = ComposePredicate::isGreenApple;
		List<Apple> result = filterApples(inv, green);
		System.out.println("Green apples:\t\t"+result);
		
		Predicate<Apple> notGreen = green.negate();
		result = filterApples(inv, notGreen);
		System.out.println("NOT Green apples:\t"+result);
		
		Predicate<Apple> greenAndHeavy = green.and(a -> a.getWeight() > 150);
		result = filterApples(inv, greenAndHeavy);
		System.out.println("Green and Hevy apples:\t"+result);
		
		Predicate<Apple> greenAndHeavyOrRed = green.and(ComposePredicate::isHeavyApple).or(ComposePredicate::isRedApple);
		result = filterApples(inv, greenAndHeavyOrRed);
		System.out.println("Green and Hevy or red:\t"+result);
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
	public static boolean isRedApple(Apple apple) {
		return "red".equals(apple.getColor());
	}
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}
	
	public static void main(String[] args) {
		new ComposePredicate();
	}
	

}
