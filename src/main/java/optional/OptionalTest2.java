package optional;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

import additionalClasses.Utils;

//The key to using Optional effectively is to use a method that either consumes the correct value or produces an alternative
public class OptionalTest2 {
	
	public OptionalTest2() throws IOException {
		
		Optional<String> ark = getStg("Arek");
		Optional<String> ark2 = getStg(null);
		
		ark.ifPresent(System.out::print);
		System.out.println();
		
		System.out.println("If null: ");
		System.out.println(ark2.orElse("Nima!"));
		String s = ark2.orElseGet( () -> "NiMa");
		System.out.println(s);
		ark2.orElseThrow(NoSuchElementException::new);
		
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new OptionalTest2();
		
	}
	
	public Optional<String> getStg(String abc) {
		return Optional.ofNullable(abc);
	}
	
}
