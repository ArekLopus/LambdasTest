package streams;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import additionalClasses.Utils;


public class Reductions {
	
	public Reductions() throws IOException {
		
		List<Integer> ints = Arrays.asList(1,2,3,4,5);

		Optional<Integer> sum = ints.stream().reduce((x, y) -> x + y);
		System.out.println(sum);
		
		Optional<Integer> sum1 = ints.stream().reduce(Integer::sum);
		System.out.println(sum1);
		
		Integer int1 = ints.stream().reduce(0, Integer::sum);
		System.out.println(int1);
		
		List<String> words = Utils.readAlice();
		//1 funkcja dodaje długość  wyrazów, a druga przy parallel łączy wyniki w całość
		int result = words.stream().reduce(0,(total, word) -> total + word.length(), (total1, total2) -> total1 + total2);
		System.out.println(result);
		
		//To samo inaczej
		System.out.println(words.stream().map(String::length).reduce(Integer::sum));
		System.out.println(words.stream().map(String::length).reduce(Integer::sum).get());
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new Reductions();
		
	}
	
}
