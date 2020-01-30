package algorithm;

class TokenTest {
    public static void main(String[] args){
        Token token1 = new Token(123, 1);
        Token token2 = new Token(1234, 1);
        Token token3 = new Token(1234, 1);
        System.out.println(token1.hashCode());
        System.out.println(token2.hashCode());
        System.out.println(token3.hashCode());
    }
}
