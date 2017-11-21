package streams;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import additionalClasses.Utils;


public class PrimitiveStreams {
	
	int i = 0;
	
	public PrimitiveStreams() throws IOException {
		
		IntStream streamInt = IntStream.of(1, 1, 2, 3, 5);
		//stream = Arrays.stream(values, from, to); // values is an int[] array
		
		IntStream.generate( () -> ++i ).limit(5).forEach(s -> System.out.print(s+", "));
		System.out.println("");
		
		IntStream.iterate(2, (x) -> x*2 ).limit(8).forEach(s -> System.out.print(s+", "));
		System.out.println("");
		
		IntStream zeroToNinetyNine = IntStream.range(0, 100); // Upper bound is excluded
		IntStream zeroToHundred = IntStream.rangeClosed(0, 100); // Upper bound is included
		System.out.println("IntStream.range: "+zeroToNinetyNine.count());
		System.out.println("IntStream.rangeClosed: "+zeroToHundred.count());
		
		List<String> words = Utils.get5Words();
		words.stream().mapToInt(String::length).forEachOrdered(s -> System.out.print(s+" | "));;
		System.out.println("");
		
		Stream<Integer> integers = streamInt.boxed();
		System.out.println("integers count: "+integers.count());
		
		System.out.println("");
		String sentence = "\uD835\uDD46-the set of octonions.";	// \uD835\uDD46 is the UTF-16 encoding of the letter , unicode U+1D546
		IntStream codes = sentence.codePoints();					// The stream with hex values 1D546 20 69 73 20 . . .
		IntStream codes2 = sentence.chars();
		codes.peek(a -> System.out.print(a+" ")).forEach(s -> System.out.print((char)s+", "));
		System.out.println();
		codes2.peek(a -> System.out.print(a+" ")).forEach(s -> System.out.print((char)s+", "));
		//System.out.println(sentence);
		System.out.println();
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new PrimitiveStreams();
		
	}
	
}
