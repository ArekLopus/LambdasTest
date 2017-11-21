package streams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import additionalClasses.User;
import additionalClasses.Utils;

//distinct(), sorted()
public class TransformationsStateful {
	
	
	public TransformationsStateful() throws IOException {
		
		List<String> list = Arrays.asList("merrily", "merrily", "merrily", "gently");
		list.stream().distinct().forEach(s -> System.out.print(s+", "));
		System.out.println("");
		
		List<String> list2 = Utils.get5Words();
		list2.stream().sorted().forEach(s -> System.out.print(s+", "));
		System.out.println("");
		
	}
	
	
	public static void main(String[] args) throws IOException {
		new TransformationsStateful();
		
	}
	
}
