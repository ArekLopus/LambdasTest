package functions;

import java.util.function.Function;

public class ThisRef {
	
	private int i = 200;
	
	public ThisRef() {
		myClass();
	}
	
	//Methos is declared in ThisRef.class, so 'this' refers to this class
	private void myClass() {
		Runnable r = () -> System.out.println("Inside Runnable: "+this.i+", "+Thread.currentThread().getName());
		new Thread(r).start();
		new Thread(r).start();
	}
	
	public static void main(String[] args) {
		new ThisRef();
		
	}
	
}
