package functions.genericFunctions;

import java.util.function.Function;

public class TestFunction {
	
	int red = 255;
	
	public TestFunction() {
		abc((f) -> red);
		System.out.println("");
		abc((f) -> 1);
		abc((f) -> 2.0);
		abc((f) -> "Abc");
		System.out.println("");
		abc2(1, (f) -> f*10);
		abc2(2, (f) -> f*10);
		System.out.println("");
		abc3((f) -> f*10);
	}
	
	
	public void abc(Function<String, Object> intf) {
		Object o = intf.apply("anything");
		System.out.println("We got from a Function: "+o+",\tClass: "+o.getClass().getName());
	}
	public void abc2(int no, Function<Integer, Object> intf) {
		Object o = intf.apply(no);
		System.out.println("We got from a Function: "+o+",\tClass: "+o.getClass().getName());
	}
	public void abc3(Function<Integer, Object> intf) {
		Object o = intf.apply(11);
		System.out.println("We got from a Function: "+o+",\tClass: "+o.getClass().getName());
	}
	
	public static void main(String[] args) {
		new TestFunction();
		
	}
	
}


//public class Main {
//	  interface MyCalcLambda {
//	    BigInteger run(BigInteger input);
//	  }
//	  public static void runCalc(MyCalcLambda calc) {
//	    // ???
//	  }
//	  public static void main(String[] args) {
//	    runCalc(a -> a.multiply(a));
//	  }
//	}