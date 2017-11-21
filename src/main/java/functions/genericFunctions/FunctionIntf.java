package functions.genericFunctions;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FunctionIntf {

	public FunctionIntf() {
		abc(System.out::println);
		abc( (s) -> System.out.println(s) );
		
		System.out.println("def: "+def(Math::pow));
		System.out.println("def: "+def((x,y) -> Math.pow(x,y)));
	}
	
	
	public void abc(Consumer<String> con) {
		con.accept("Blabla");
	}
	
	public Double def(BiFunction<Double, Double, Double> biFun) {
		Double d = biFun.apply(2.0, 8.0);
		return d;
	}
	
	
	public static void main(String[] args) {
		new FunctionIntf();
		
	}
	
}

