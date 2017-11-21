package functions.primitiveSpecializations;

import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class TestPrimitiveSpec {
	
	public TestPrimitiveSpec() {
		IntFunction<String>	fromInt = String::valueOf;
		ToIntFunction<String> toInt = Integer::parseInt;
		
		System.out.println(fromInt.apply(10).getClass());
		System.out.println(toInt.applyAsInt("10"));
	}
	
	public static void main(String[] args) {
		new TestPrimitiveSpec();
	}
	
}

