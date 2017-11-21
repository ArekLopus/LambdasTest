package functions.localVars;

public class Closure {
	
	private int instanceVar = 2;
	public static int staticVar = 22;
	
	public Closure() {
		int localVar = 11; 
		Runnable r = () -> System.out.println("Local Variable: "+localVar+", Instance Variable: "+instanceVar+", Static Variable: "+staticVar+", Thread: "+Thread.currentThread().getName());
		r.run();
		
		//localVar++;  //Cant do this - Local variable localVar defined in an enclosing scope must be final or effectively final
		instanceVar++;
		staticVar++;
		
		r = () -> System.out.println("Local Variable: "+localVar+", Instance Variable: "+instanceVar+", Static Variable: "+staticVar+", Thread: "+Thread.currentThread().getName());
		r.run();
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		new Closure();
	}
	
}

