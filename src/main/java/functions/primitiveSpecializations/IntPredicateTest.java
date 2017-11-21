package functions.primitiveSpecializations;

import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;

public class IntPredicateTest {
	
	public IntPredicateTest() {
		IntPredicate evenPred1 = (int i) -> i % 2 == 0;
		System.out.println("Tested int predicarte: "+evenPred1.test(1000));	//true (no boxing)
		IntPredicate evenPred2 = (int i) -> i % 2 == 1;
		System.out.println("Tested int predicarte: "+evenPred2.test(1000));	//false (no boxing)
	}
	IntFunction<String>	fromInt = String::valueOf;
	ToIntFunction<String> toInt = Integer::parseInt;
	
	public static void main(String[] args) {
		new IntPredicateTest();
	}
	
}

