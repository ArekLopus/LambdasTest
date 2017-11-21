package additionalClasses;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Utils {

	public static List<String> readAlice() throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8); // Read file into string
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));	// Split into words; nonletters are delimiters
		return words;
	}
	
	public static List<User> getUsers() {
		return Arrays.asList(new User("Arek", "Zarek"), new User("Darek", "Warek"), new User("Arek", "Barek"), new User("Darek", "Farek"));
	}
	
	public static List<User> getUsers2() {
		return Arrays.asList(new User("Arek", "Zarek"), new User("Darek", "Warek"), new User("Marek", "Barek"), new User("Jarek", "Farek"));
	}
	
	public static List<String> get5Words() { 
		return Arrays.asList("One", "Two", "Three", "Four", "Five"); 
	}
	
	public static List<City> getCities() {
		return Arrays.asList(new City("Boston" ,"New York", 1000), new City("Philadelphia","New York", 2000), new City("New York", "New York",3000), new City("Portland", "Maine", 1500), new City("Wahabi", "Maine", 2100));
	}
}
