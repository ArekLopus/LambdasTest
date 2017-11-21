package streams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import additionalClasses.User;
import additionalClasses.Utils;

//limit(), skip(), Stream.concat(), peek();
public class ExtractingCombiningStreams {
	
	private List<User> users = Utils.getUsers();
	private List<User> users2 = Arrays.asList(new User("Jarek", "Karek"), new User("Marek", "Carek"), new User("Arek", "Farek"), new User("Zarek", "Tarek"));
	
	public ExtractingCombiningStreams() throws IOException {
		users.stream().limit(2).forEach(System.out::print);
		System.out.println("");
		
		users.stream().skip(2).forEach(System.out::print);
		System.out.println("");
		
		Stream<User> conUsers = Stream.concat(users.stream(), users2.stream());
		System.out.println("Concat users 4+4? "+conUsers.count());
		
		System.out.println("Peek returns the stream and lets do smth with each el during the creation of the stream");
		Stream powStr = Stream.iterate(1.0, p -> p * 2);
		Object[] powers = powStr.peek(e -> System.out.print("Fetching " + e +", ")).limit(10).toArray();
		//powStr.limit(1).forEach(System.out::println);
		System.out.println("");
		
		List<String> words =  Utils.get5Words();
		Stream<String> wordStr = words.stream().peek( s -> System.out.print(s + ", ") ).map( s -> s+1);
		List<String> words2 = wordStr.collect(Collectors.toList());
		System.out.println("\n"+words2);
	}
	
	public static void main(String[] args) throws IOException {
		new ExtractingCombiningStreams();
		
	}
	
}



