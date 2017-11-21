package streams;

import java.io.IOException;
import java.util.List;

import additionalClasses.Utils;


public class Test {
	
	public Test() throws IOException {
		
		List<String> words = Utils.readAlice();
		System.out.println("Words: "+words.size());
		
		int count = 0;
		for (String w : words) {
			if (w.length() > 10) count++;
		}
		System.out.println("Count: "+count);
		
		long start = System.currentTimeMillis();
		
		long count1 = words.stream().filter(w -> w.length() > 0).count();
		long result = System.currentTimeMillis() - start;
		System.out.println("Count2: "+count1+", result: "+result);
		
		start = System.currentTimeMillis();
		long count2 = words.parallelStream().filter(w -> w.length() > 0).count();
		result = System.currentTimeMillis() - start;
		System.out.println("Count2: "+count2+", result: "+result);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new Test();
		
	}
	
}
