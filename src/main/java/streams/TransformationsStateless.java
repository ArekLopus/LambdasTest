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

//filter(), map(), flatMap()
public class TransformationsStateless {
	
	private List<User> users = Utils.getUsers();
	private List<User> users2 = Arrays.asList(new User("Jarek", "Karek"), new User("Marek", "Carek"), new User("Arek", "Farek"), new User("Zarek", "Tarek"));
	private List<String> wordList = Utils.readAlice();
	
	
	public TransformationsStateless() throws IOException {
		//filterTest();
		//mapTest();
		flatMapTest();
	}
	
	
	private void filterTest() {
		Stream<String> words = wordList.stream();
		Stream<String> longWords = words.filter(w -> w.length() > 12);
		System.out.println("Filter usage: "+longWords.count());
		
		wordList.stream().filter(w -> w.startsWith("X")).forEach( x -> System.out.print(x+", "));
		System.out.println("");
		
		users.stream().filter( u -> u.getName().equals("Arek") ).forEach(System.out::print);;
		System.out.println("");
	}
	
	private void mapTest() {
		Stream<String> big = wordList.stream().filter(w -> w.startsWith("X"));
		big.map(String::toLowerCase).forEach( x -> System.out.print(x+", "));
		System.out.println("");
		
		users.stream().map(u -> u.getName()).forEach( u -> System.out.print(u+", "));
		System.out.println("");
	}
	
	private void flatMapTest() {
				
		Stream<List<Integer>> integerListStream = Stream.of(
		    Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5)
		);
		//integerListStream .flatMap(Collection::stream).forEach(s -> System.out.print(s+","));
		integerListStream .flatMap( i -> i.stream()).forEach(s -> System.out.print(s+","));
		System.out.println("");
		
		
		List<Developer> team = new ArrayList<>();
        Developer polyglot = new Developer("esoteric");
        polyglot.add("clojure");
        polyglot.add("scala");
        polyglot.add("groovy");
        polyglot.add("go");

        Developer busy = new Developer("pragmatic");
        busy.add("java");
        busy.add("javascript");

        team.add(polyglot);
        team.add(busy);

		team.stream().map(d -> d.getLanguages()).forEach(u -> System.out.print(u+", "));
		System.out.println("");
		//Collection::stream
		List<String> teamLanguages = team.stream().
                map(d -> d.getLanguages()).
                flatMap(l -> l.stream()).
                collect(Collectors.toList());
		System.out.println(teamLanguages);
	}
	
	public static void main(String[] args) throws IOException {
		new TransformationsStateless();
		
	}
	
}

class Developer {

    private String name;
    private Set<String> languages;

    public Developer(String name) {
        this.languages = new HashSet<>();
        this.name = name;
    }

    public void add(String language) {
        this.languages.add(language);
    }

    public Set<String> getLanguages() {
        return languages;
    }
}

