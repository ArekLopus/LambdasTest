package streams;

import java.util.Arrays;
import java.util.List;

public class TestStream {
	
	public TestStream() {

		List<String> list = Arrays.asList("One ","Two ","Three ","Four ");
		list.stream().sorted().forEach(System.out::print);
		System.out.println("\n---------------------------");
		list.stream().filter(e -> e.length() > 4).sorted().forEach(System.out::print);
		System.out.println("\n---------------------------");
		String[] ar = list.stream().sorted().toArray(String[]::new);
		System.out.println(ar.length);
		
	}
	
	
	public static void main(String[] args) {
		new TestStream();
	}
	
}

