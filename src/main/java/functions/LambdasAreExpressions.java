package functions;

import java.util.function.Supplier;

public class LambdasAreExpressions {

	public LambdasAreExpressions() {
		test( () -> "Arek" );				//"Arek" is an expression
		test( () -> {return "Arek";} );		//explicit return must be in curly braces
		test( () -> {return String.valueOf(1); } );
		
		//test( () -> { "Arek"; } );		//This is expressionm, not a statement
		test( () -> { return "Arek"; } );	//Tak
		test( () -> "Arek" );				//Albo tak
		
		//test( (String s) -> "Iron Man"+s );
		
	}
	
	
	public void test (Supplier<String> s) {
		System.out.println(s.get());
	}
	
	
	public static void main(String[] args) {
		new LambdasAreExpressions();
	}
	
}
