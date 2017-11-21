package streams;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import additionalClasses.User;
import additionalClasses.Utils;


public class ShowOperations {
	
	public ShowOperations() throws IOException {
		
		List<User> users = Utils.getUsers();
		System.out.println("");
		
		List<String> names = users.stream()
			.filter((u) -> {
				System.out.println("Filtered: "+u.getName());
				return "Arek".equals(u.getName()); })
			.map( (u) -> {
				System.out.println("Mapped: "+u.getName());
				return u.getName(); })
			.collect(Collectors.toList());
		System.out.println("Names: "+names);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new ShowOperations();
		
	}
	
}
