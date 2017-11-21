package streams.collect;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import additionalClasses.Utils;


public class CollectingResults {
	
	public CollectingResults() throws IOException {
		
		List<Integer> ints = Arrays.asList(1,2,3,4,5);
		List<String> words = Utils.readAlice();
		List<String> words5 = Utils.get5Words();
		
		Iterator<String> iter = words5.stream().iterator();
		System.out.println(iter.next());
		
		String[] strArr = words5.stream().toArray(String[]::new);
		System.out.println("Array size: "+strArr.length);
		
		//You dont have to do that beacause of Collect
		HashSet<String> result = words5.stream().collect(HashSet::new, HashSet::add, HashSet::addAll);
		System.out.println("HashSet size: "+result.size());
		
		Set<String> result2 = words5.stream().collect(Collectors.toSet());
		System.out.println("Collectors Set size: "+result2.size());
		
		List<String> result3 = words5.stream().collect(Collectors.toList());
		System.out.println("Collectors List size: "+result3.size());
		
		TreeSet<String> result4 = words5.stream().collect(Collectors.toCollection(TreeSet::new));
		System.out.println("Collectors TreeSet size: "+result4.size());
		
		String result5 = words5.stream().collect(Collectors.joining());
		System.out.println("Collectors joining size: "+result5);
		
		String result6 = words5.stream().collect(Collectors.joining(", "));
		System.out.println("Collectors joining size: "+result6);
		
		IntSummaryStatistics summary = words5.stream().collect(Collectors.summarizingInt(String::length));
		double averageWordLength = summary.getAverage();
		double minWordLength = summary.getMin();
		double maxWordLength = summary.getMax();
		System.out.println("averageWordLength: "+averageWordLength+", minWordLength: "+minWordLength+", maxWordLength: "+maxWordLength);
		
		words5.stream().forEach(System.out::print);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new CollectingResults();
		
	}
	
}
