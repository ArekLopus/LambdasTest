package functions.compose;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import additionalClasses.User;

public class ComposeComparators {
	
	public ComposeComparators() {
		
		List<User> users = Arrays.asList(new User("Arek", "Zarek"), new User("Darek", "Warek"), new User("Arek", "Barek"), new User("Darek", "Farek"));
		users.sort(Comparator.comparing(User::getName));
		System.out.println(users);
		users.sort(Comparator.comparing(User::getName).reversed());
		System.out.println(users);
		users.sort(Comparator.comparing(User::getName).reversed().thenComparing(Comparator.comparing(User::getSurname)));
		System.out.println(users);
		users.stream().sorted(Comparator.comparing(User::getName)).forEach(System.out::print);
	}
	
	
	public static void main(String[] args) {
		new ComposeComparators();
	}
	
}

