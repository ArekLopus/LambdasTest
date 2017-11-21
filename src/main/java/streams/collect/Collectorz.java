package streams.collect;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summingInt;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import additionalClasses.City;
import additionalClasses.User;
import additionalClasses.Utils;

public class Collectorz {
	
	public Collectorz() throws IOException {
		//counts how many locales there are for each country
		List<Locale> locales = Arrays.asList(Locale.getAvailableLocales());
		Map<String, Long> countryToLocCounts = locales.stream().collect(groupingBy(Locale::getCountry, counting()));
		System.out.println("Collectors.counting(): "+countryToLocCounts.get("CH"));
		
		//the sum of populations per state in a stream of cities
		List<City> cities = Utils.getCities();
		Map<String, Integer> stateToCityPop = cities.stream().collect(groupingBy(City::getState,summingInt(City::getPopulation)));
		System.out.println("Collectors.summingInt(): "+stateToCityPop.get("New York"));
		
		//The largest city per stat
		Map<String, Optional<City>> stateToLargestCity = cities.stream().collect(groupingBy(City::getState, maxBy(Comparator.comparing(City::getPopulation))));
		System.out.println("Collectors.maxBy(): "+stateToLargestCity.get("Maine").get().getPopulation());
		
		//We group cities by state. Within each state, we produce the names of the cities and reduce by maximum length.
		Map<String, Optional<String>> stateToLongestCityName = cities.stream().collect(
				groupingBy(City::getState, mapping(City::getName, maxBy(Comparator.comparing(String::length)))));
		System.out.println("Collectors.mapping(): "+stateToLongestCityName);
		
		//The mapping() also yields a nicer solution to a problem from the preceding section, to gather a set of all languages in a country.
		Map<String, Set<String>> countryToLanguages = locales.stream().collect(
		groupingBy(l -> l.getDisplayCountry(), mapping(l -> l.getDisplayLanguage(), Collectors.toSet())));
		System.out.println("Collectors.mapping(): "+countryToLanguages.get("Stany Zjednoczone Ameryki"));
		
		//If the grouping() or mapping() has return type int, long, or double, you can collect elements into a summary statistics object
		Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities.stream().collect(
			groupingBy(City::getState, Collectors.summarizingInt(City::getPopulation)));
		System.out.println("Collectors.mapping(): "+stateToCityPopulationSummary);
		
		//An example that gets a comma-separated string of all city names in each state. We map each city to its name and then concatenate them.
		Map<String, String> stateToCityNames = cities.stream().collect(groupingBy(City::getState, 
				Collectors.reducing("", City::getName, (s, t) -> s.length() == 0 ? t : s + ", " + t)));
		System.out.println("Collectors.reducing(): "+stateToCityNames);
		
		//As with Stream.reduce, Collectors.reducing is rarely necessary. In this case, you can achieve the same result more naturally as
		Map<String, String> stToCity = cities.stream().collect(groupingBy(City::getState, mapping(City::getName, Collectors.joining(", "))));
		System.out.println("Collectors.mapping(): "+stToCity);
		
		List<User> users = Utils.getUsers();
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new Collectorz();
		
	}
	
}
