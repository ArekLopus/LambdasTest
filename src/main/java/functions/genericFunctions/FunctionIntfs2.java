package functions.genericFunctions;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionIntfs2 {
	
	
	public FunctionIntfs2() {
		Consumer<String> print = System.out::println; 
		print.accept("Abc");
		
		UnaryOperator<String> uo = s -> s+", added";
		abc("Arek", uo);
		
		BinaryOperator<String> bo = (s1, s2) -> s1+" added "+s2;
		abc1("Arek", "Darek", bo);
		
		Function<String, Integer> fun = Integer::new;
		abc2("42", fun);

	}
	
	public void abc(String a, UnaryOperator<String> uo) {
		System.out.println(uo.apply(a));
	}
	public void abc1(String a, String b, BinaryOperator<String> bo) {
		System.out.println(bo.apply(a, b));
	}
	
	public void abc2(String s, Function<String, Integer> f) {
		System.out.println(f.apply(s));
	}
	
	public <T> void abc3() {
		//System.out.println(new T[3]);	//Cannot create a generic array of T
	}
	
	
	public static void main(String[] args) {
		new FunctionIntfs2();
	}
	
}


