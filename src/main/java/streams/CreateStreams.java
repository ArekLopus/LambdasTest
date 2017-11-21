package streams;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class CreateStreams {
	
	public CreateStreams() throws IOException {
		List<String> l1 = Arrays.asList("One ", "Two ", "Three ");
		l1.stream().forEach(System.out::print);						//Collection.stream()
		System.out.println("");
		
		Stream<String> str1 = Stream.of("gently ", "down ", "the ", "stream ");
		str1.forEach(System.out::print);		System.out.println("");
		
		Stream<String> str2 = Stream.empty();
		System.out.println("Empty stream: "+str2.count());
		
		int[] arrStr = new int[] {1,2,3,4};
		Arrays.stream(arrStr).forEach(System.out::print);;		System.out.println("");
		
		Arrays.stream(arrStr, 0, 2).forEach(System.out::print);;
		System.out.println("");
		
		Stream<String> echos = Stream.generate(() -> "Echo ");	//Infinite stream
		echos.limit(5).forEach(System.out::print);		System.out.println("");
		
		Stream<Double> randoms = Stream.generate(Math::random);
		randoms.limit(3).forEach(System.out::print);		System.out.println("");
		
		Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
		integers.limit(5).forEach(System.out::print);		System.out.println("");
		
		Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream("One, Two, Three ");
		words.forEach(System.out::print);		System.out.println("");
		
		try (Stream<String> lines = Files.lines(Paths.get("alice.txt"))) {
			lines.limit(1).forEach(System.out::print);		System.out.println("");
		}
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new CreateStreams();
		
	}
	
}
