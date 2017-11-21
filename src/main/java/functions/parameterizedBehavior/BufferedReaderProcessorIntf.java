package functions.parameterizedBehavior;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderProcessorIntf {
    String process(BufferedReader b) throws IOException;
}
