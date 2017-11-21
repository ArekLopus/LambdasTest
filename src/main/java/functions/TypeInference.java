package functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import additionalClasses.Apple;

public class TypeInference {
	
	List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red")); 
	
	public TypeInference() {
		filterApples(inventory, (Apple a) -> "red".equals(a.getColor()) );
		filterApples(inventory, a -> "red".equals(a.getColor()) );			//No explicit type on the parameter a
		//when a lambda has just one param whose type is inferred, the parentheses surrounding the param can also be omitted
		
		Comparator<Apple> c1 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());  //Without type inference
		Comparator<Apple> c2 = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());  //With type inference

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
	
	public static void main(String[] args) {
		new TypeInference();
	}
	
}
