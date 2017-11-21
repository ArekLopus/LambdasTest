package functions.returnLambda;

import java.util.function.Function;

import additionalClasses.User;

public class FunctionIntf {

	public FunctionIntf() {
		abc(makeSurnamedUser("Smith"));
		abc(makeSurnamedUser("Johnson"));
	}
	
	public static Function<String, User> makeSurnamedUser(String surname) {
	    return n -> new User(n, surname);
	}
	
	public void abc(Function<String, User> sup) {
		System.out.println(sup.apply("Arek"));
	}
	
	
	
	public static void main(String[] args) {
		new FunctionIntf();
		
	}
	
}

//Jakaś zmienna i zwracamy fun z tą zmienną
//Arrays.sort(values, comparatorGenerator(customization arguments))