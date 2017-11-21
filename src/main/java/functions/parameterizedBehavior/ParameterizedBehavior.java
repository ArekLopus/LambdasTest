package functions.parameterizedBehavior;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.function.Consumer;

public class ParameterizedBehavior {
	
	public static String str = "abc\ndef\nghi";
	
	public ParameterizedBehavior() throws IOException {
		//System.out.println(str);
		processFile(System.out::println, (BufferedReader br) -> br.readLine() );
		processFile(System.out::println,  (BufferedReader br) -> br.readLine() + br.readLine() );
	}
	
	public static void processFile(Consumer<String> consumer, BufferedReaderProcessorIntf p) throws IOException {
        try(BufferedReader br = new BufferedReader(new StringReader(str))) {
            consumer.accept(p.process(br));	//processing the BufferedReader object
        }
	}
	
	public static void main(String[] args) throws IOException {
		new ParameterizedBehavior();
	}
	
	
//	public interface BufferedReaderProcessor {
//	    String process(BufferedReader b) throws IOException;
//	}
}

