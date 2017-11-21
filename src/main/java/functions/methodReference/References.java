package functions.methodReference;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class References extends TestReferencesSuper{
	
	List<String> list = Arrays.asList("Arek", "Marek", "Darek", "osiołek", "matołek", "ameba");
	
	public References() {
		abc(list::get);
		abc(this::bla);
		
		Function<Integer, String> f = this::bla;
		System.out.println(f.apply(2));
		System.out.println("-------------");
		
		abc2(super::getStg);
	}
	
	private void abc(Function<Integer, String> fun) {
		Random ran = new Random();
		System.out.println(fun.apply(ran.nextInt(list.size())));
		System.out.println("-------------");
	}
	private void abc2(Supplier<String> sup) {
		System.out.println(sup.get());
		System.out.println("-------------");
	}
	
	public String bla(int i) {
		return list.get(i);
	}
	
	public String getStg() {
		return "this.getStg()";
	}
	
	public static void main(String[] args) {
		new References();
	}

}

class TestReferencesSuper {
	public String getStg() {
		return "super.getStg()";
	}
}
