package optional;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

import additionalClasses.Utils;


public class OptionalTest {
	
	public OptionalTest() throws IOException {
		
		List<String> words = Utils.get5Words();

		Optional<String> startsWithQ = words.stream().filter(s -> s.startsWith("O")).findFirst();
		if (startsWithQ.isPresent()) {
			System.out.println("findFirst() startsWithQ: " + startsWithQ.get());
		}
		
		System.out.println(startsWithQ.orElse("Ni ma!"));
		startsWithQ.orElseGet( () -> "NiMa");
		startsWithQ.orElseThrow(NoSuchElementException::new);
		
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new OptionalTest();
		
	}
	
}
