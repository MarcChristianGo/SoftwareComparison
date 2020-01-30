package algorithm;

import java.io.IOException;
import java.io.Reader;

@FunctionalInterface
public interface ComparisonStrategy {
    Double compare(Reader str1, Reader str2) throws IOException;
}
