package algorithm;

import java.util.Objects;

class Token {
    private final int hash;
    private final int lineNo;

    Token(int hash, int lineNo) {
        this.hash = hash;
        this.lineNo = lineNo;
    }

    public int getLineNo() {
        return lineNo;
    }


    public int getHash() {
        return hash;
    }

    @Override
    public boolean equals(Object other){
        Token ref = (Token)other;
        return ref.hash == this.hash &&  ref.lineNo == this.lineNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash, lineNo);
    }
//    @Override
//    public int hashCode(){
//        return hash + lineNo;
//    }




}
