package functions.genericFunctions;

import java.awt.Color;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class FunctionIdentity {

	public FunctionIdentity() {
		
		test( (String s) -> new Integer(s)  );
		test2(new Color(127,127,127), Color::brighter);
	}
	
	
	public void test (Function<String, Integer> fun) {
		Function.identity();
		Function<Integer,Integer> id = Function.identity();
	    
	    System.out.println(id.apply(3));
		
		Predicate<String> i  = Predicate.isEqual("1");
		System.out.println(i.test("1"));
		
	}
	public void test2 (Color col, UnaryOperator<Color> uo) {
		System.out.println(col);
		col = uo.apply(col);
		System.out.println(col);
	}
	
	public static void main(String[] args) {
		new FunctionIdentity();
	}
	
}
