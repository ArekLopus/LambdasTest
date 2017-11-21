package streams.collect;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import additionalClasses.User;
import additionalClasses.Utils;


public class CollectingToMap {
	
	public CollectingToMap() throws IOException {
		
		List<User> users = Utils.getUsers2();
		Map<String, User> nameToUser = users.stream().collect(Collectors.toMap(User::getName, Function.identity()));
		System.out.println("Keys: "+nameToUser.keySet()+", 1 value: "+nameToUser.get("Arek"));
		
		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
		Map<String, String> languageNames = locales.collect(Collectors.toMap(
		    l -> l.getDisplayLanguage(),
		    l -> l.getDisplayLanguage(l),
		    (existingValue, newValue) -> existingValue));
		System.out.println(languageNames.size());
		
		Stream<Locale> locales2 = Stream.of(Locale.getAvailableLocales());
		Map<String, Set<String>> countryLanguageSets = locales2.collect(Collectors.toMap(
			    l -> l.getDisplayCountry(),
			    l -> Collections.singleton(l.getDisplayLanguage()),
			    (a, b) -> { // Union of a and b
			        Set<String> r = new HashSet<>(a);
			        r.addAll(b);
			        return r; }));
		System.out.println(countryLanguageSets.size());
		
		List<User> users2 = Utils.getUsers2();
		Map<String, User> nameToUsr = users2.stream().collect(Collectors.toMap(
			    User::getName,
			    Function.identity(),
			    (existingValue, newValue) -> { throw new IllegalStateException(); }, TreeMap::new));
		System.out.println("Keys: "+nameToUser.keySet()+", 1 value: "+nameToUser.get("Arek"));
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new CollectingToMap();
		
	}
	
}
