package algorithm;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

class HashingTokenizer {
    private StreamTokenizer tokenizer;
    static final int EOF = 0;
    static final int EOL = 1;
    static final int IGNORE = 3;
    static final int OTHER = 2;
    static final int QUOTE = '"';

    Token getNextTokenInfo() throws IOException {
        int tokenNumber = tokenizer.nextToken();
        int hash = IGNORE;
        switch(tokenNumber){
            case StreamTokenizer.TT_EOF:
                hash = EOF;
                break;
            case StreamTokenizer.TT_EOL:
                hash = EOL;
                break;

            case StreamTokenizer.TT_NUMBER:
                Integer placeHolder = tokenNumber;
                hash = placeHolder.hashCode();
                break;

            case StreamTokenizer.TT_WORD:
                hash = tokenizer.sval.hashCode();
                break;


            default:
                //extra checks
                if (tokenNumber == QUOTE) hash = tokenizer.sval.hashCode();
                else hash = IGNORE;
                break;

        }

        return new Token(hash, tokenizer.lineno());
    }

    HashingTokenizer(Reader reader){
        tokenizer = new StreamTokenizer(reader);
        tokenizer.quoteChar(QUOTE);
    }
}
