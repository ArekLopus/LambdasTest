package streams;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import additionalClasses.Utils;


public class ReductionsSimple {
	
	public ReductionsSimple() throws IOException {
		
		List<String> words = Utils.get5Words();
		System.out.println("Count words: "+words.stream().count());
		
		Stream<Double> randoms = Stream.generate(Math::random);
		System.out.println("\n"+randoms.limit(5).peek(System.out::print).min(Double::compareTo));
		
		Stream<Double> randoms2 = Stream.generate(Math::random);
		System.out.println("\n"+randoms2.limit(5).peek(System.out::print).max(Double::compareTo));
		
		List<String> alice = Utils.readAlice();
		Optional<String> startsWithQ = alice.stream().filter(s -> s.startsWith("Q")).findFirst();
		if (startsWithQ.isPresent())   System.out.println("findFirst() startsWithQ: " + startsWithQ.get());
		
		Optional<String> startsWithQ2 = alice.stream().parallel().filter(s -> s.startsWith("Q")).findAny();
		if (startsWithQ2.isPresent())   System.out.println("findAny() startsWithQ: " + startsWithQ.get());
		
		boolean b1 = alice.stream().parallel().anyMatch(s -> s.startsWith("Q"));
		System.out.println("anyMatch() startsWithQ: " + b1);
		
		boolean b2 = alice.stream().parallel().allMatch(s -> s.startsWith("Q"));
		System.out.println("allMatch() startsWithQ: " + b2);
		
		boolean b3 = alice.stream().parallel().noneMatch(s -> s.startsWith("Qz"));
		System.out.println("noneMatch() startsWithQ: " + b3);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new ReductionsSimple();
		
	}
	
}
