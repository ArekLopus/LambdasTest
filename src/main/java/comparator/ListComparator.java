package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListComparator {

	public ListComparator() {

		List<String> list = Arrays.asList("Arek", "Marek", "Darek", "osiołek", "matołek", "ameba", "Abecadło");
		
		Comparator<String> strComp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		};
		
		list.sort(strComp);
		
		//list.sort( (x,y) -> x.compareTo(y));
		//list.sort(String::compareToIgnoreCase);
		//list.sort(Comparator.comparing(String::length).thenComparing( (s1,s2) -> s1.compareToIgnoreCase(s2) ));
		
		list.forEach(System.out::println);
		
		//list.stream().sorted(String::compareToIgnoreCase).forEach(System.out::println);
		//list.stream().sorted(String::compareToIgnoreCase).filter(e -> e.contains("a")).forEach(System.out::println);
		
	}
	
	
	public static void main(String[] args) {
		new ListComparator();
		
	}
	
}
