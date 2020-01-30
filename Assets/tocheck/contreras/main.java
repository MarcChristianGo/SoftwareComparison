import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {

        Compare compare = new Compare();
        System.out.println("Pair 1 has a similarity score of "+ compare.checkFiles("C:\\Users\\TJ\\Desktop\\Code Repositories\\test_program1.java",
                "C:\\Users\\TJ\\Desktop\\Code Repositories\\test_program2.java"));

        System.out.println("Pair 2 has a similarity score of "+compare.checkFiles("C:\\Users\\TJ\\Desktop\\Code Repositories\\test_program1.cpp",
                "C:\\Users\\TJ\\Desktop\\Code Repositories\\test_program2.cpp"));

    }
}
