package functions.compose;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import additionalClasses.User;

public class ComposeFunction {
	
	public ComposeFunction() {
		
		Function<Integer, Integer> f = x -> x+1;
		Function<Integer, Integer> g = x -> x*2;
		Function<Integer, Integer> h = f.andThen(g);
		int result = h.apply(1);
		System.out.println(result);
		
		Function<Integer, Integer> h2 = f.compose(g);
		result = h2.apply(1);
		System.out.println(result);
		
	}
	
	
	public static void main(String[] args) {
		new ComposeFunction();
	}
	
}

