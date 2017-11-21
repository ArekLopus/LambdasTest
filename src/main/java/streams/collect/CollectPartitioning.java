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


public class CollectPartitioning {
	
	public CollectPartitioning() throws IOException {
		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
		Map<Boolean, List<Locale>> engAndOtherLoc = locales.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
		List<Locale> englishLocales = engAndOtherLoc.get(true);
		System.out.println(""+englishLocales);
		
		//Dzieli na 2 grupy z danym imieniem i innych userów
		List<User> users = Utils.getUsers();
		Map<Boolean, List<User>> areks = users.stream().collect(Collectors.partitioningBy(u -> u.getName().equals("Arek")));
		System.out.println("With Arek: "+areks.get(true));
		System.out.println("W/o  Arek: "+areks.get(false));
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new CollectPartitioning();
		
	}
	
}
