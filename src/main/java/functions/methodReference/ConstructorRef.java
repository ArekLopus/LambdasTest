package functions.methodReference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import additionalClasses.User;

public class ConstructorRef {
	
	
	public ConstructorRef() {
		
		Supplier<String> sup = String::new;
		String str = sup.get();
		System.out.println(str.getClass().getName()+", lenght: "+str.length());
		System.out.println("---------------------------");
		
		Function<String, String> fun = String::new;
		String res = fun.apply("Arek");
		System.out.println(res);
		System.out.println("---------------------------");
		
		List<String> list = Arrays.asList("One ","Two ","Three ","Four ");
		String[] ar = list.stream().sorted().toArray(String[]::new);
		System.out.println(ar.length+", "+Arrays.asList(ar));
		System.out.println("---------------------------");
		
		Function<String, Integer> fun2 = Integer::new;
		abc2("42", fun2);
		System.out.println("---------------------------");
		
		List<String> labels = Arrays.asList("Jarek", "Arek","Marek","Darek");
		Stream<User> stream = labels.stream().map(User::new);
		List<User> users = stream.collect(Collectors.toList());
		System.out.println(users);
		
		//users.stream().sorted(Comparator.comparing(User::getName).thenComparing(User::getSurname)).forEach(System.out::println);;
		
	}
	
	public void abc2(String s, Function<String, Integer> f) {
		System.out.println(f.apply(s));
	}
	
	
	
	public static void main(String[] args) {
		new ConstructorRef();
	}
	

}
