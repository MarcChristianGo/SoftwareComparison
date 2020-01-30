package algorithm;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

public class LineComparisonStrategy implements ComparisonStrategy {

    private HashMap<Token, Integer> occurences;

    public LineComparisonStrategy(){
        occurences = new HashMap<>();
    }
    private void tabulateOccurences(Reader reader) throws IOException {
        HashingTokenizer tokenizer = new HashingTokenizer(reader);
        Token currentToken = null;
        do {
            currentToken = tokenizer.getNextTokenInfo();
            if (currentToken.getHash() == HashingTokenizer.IGNORE) continue;
            occurences.putIfAbsent(currentToken, 0);
            occurences.put(currentToken,
                    occurences.get(currentToken) + 1);
        } while (currentToken.getHash() != HashingTokenizer.EOF);
    }


    //returns a score between 0.0 and 1.0
    @Override
    public Double compare(Reader str1, Reader str2) throws IOException {
        tabulateOccurences(str1);
        tabulateOccurences(str2);

        double collisionCount = 0;
        double total = 0;
        for (Integer count : occurences.values()){
            if (count >= 2) collisionCount++;
            total++;
        }

        return collisionCount / total;
    }


}
