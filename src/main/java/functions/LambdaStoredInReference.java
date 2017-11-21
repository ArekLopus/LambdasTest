package functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javafx.scene.control.Button;

public class LambdaStoredInReference {
	
	
	public LambdaStoredInReference() {
		final Map<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		final BiFunction<String, Integer, Integer> remapper = (k, v) -> v == null ? 42 : v + 4;
		map.compute("A", remapper);
		System.out.println(map.get("A"));
		
		Consumer<String> con = System.out::println;
		con.accept("Abc");
		
		Predicate<String> pre = (String s) -> s.length() > 5;
		con.accept("Length > 5? "+pre.test("Arek123"));
		
		Function<String, String> fun = (String a) -> "Def "+a;
		con.accept(fun.apply("Ghi"));
		
	}
	
	
	public static void main(String[] args) {
		new LambdaStoredInReference();
	}
	
}
