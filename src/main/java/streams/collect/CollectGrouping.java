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


public class CollectGrouping {
	
	public CollectGrouping() throws IOException {
		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
		Map<String, List<Locale>> countryToLocales = locales.collect(Collectors.groupingBy(Locale::getCountry));
		System.out.println(""+countryToLocales.size());
		List<Locale> swissLocales = countryToLocales.get("CH");
		System.out.println(""+swissLocales);
		
		//Mapuje imiona do listy wszytkich userów z tym imieniem (Imię -> Wszyscy Userzy z danym imieniem)
		List<User> users = Utils.getUsers();
		Map<String, List<User>> areks = users.stream().collect(Collectors.groupingBy(User::getName));
		System.out.println("With Arek: "+areks.get("Arek"));
		System.out.println("With Darek: "+areks.get("Darek"));
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new CollectGrouping();
		
	}
	
}
