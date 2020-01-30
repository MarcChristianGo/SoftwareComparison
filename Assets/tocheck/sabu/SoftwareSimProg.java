import java.io.*;
import java.util.Scanner;

public class SoftwareSimProg {

    public static void main(String[] args) throws Exception
    {
        StringBuilder prog1String = new StringBuilder();
        StringBuilder prog2String = new StringBuilder();
        StringBuilder prog1StringN = new StringBuilder();
        StringBuilder prog2StringN = new StringBuilder();

        File prog1File = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\prog1.java");
        File prog2File = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\prog2.java");
        File prog1FileN = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\prog1.java");
        File prog2FileN = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\prog2.java");

        Scanner prog1Scan = new Scanner(prog1File);
        Scanner prog2Scan = new Scanner(prog2File);
        Scanner prog1ScanN = new Scanner(prog1FileN);
        Scanner prog2ScanN = new Scanner(prog2FileN);

        while(prog1Scan.hasNext()){
            String prog1Word = prog1Scan.next();
            prog1String.append(prog1Word);
        }

        while(prog2Scan.hasNext()){
            String prog2Word = prog2Scan.next();
            prog2String.append(prog2Word);
        }

        while(prog1ScanN.hasNextLine()){
            String prog1Word = prog1ScanN.nextLine();
            prog1StringN.append(prog1Word + "\n");
            if(prog1StringN.equals(prog2ScanN.hasNextLine()));
        }

        while(prog2ScanN.hasNextLine()){
            String prog2Word = prog2ScanN.nextLine();
            prog2StringN.append(prog2Word + "\n");
        }



        System.out.println("PROG #1: \n" + prog1StringN);
        System.out.println("PROG #2: \n" + prog2StringN);

        StringBuilder longestSamedtString = new StringBuilder();

        //String longestSamedtString = "";
        int diffCharCount = 0,sameCharCount = 0,prog2Length = prog2String.length();

        System.out.println("\nLongest Similar String: ");

        for(int x=0;x<prog2Length;x++){
            StringBuilder finalLongest = new StringBuilder();
            if(prog1String.charAt(x) == prog2String.charAt(x)){
                String character = Character.toString(prog1String.charAt(x));
                longestSamedtString.append(character);
                //System.out.println(longestSamedtString);
                //System.out.print(character);
                //longestSamedtString = longestSamedtString + character;
                sameCharCount++;
            }
            else {
                diffCharCount++;

                finalLongest = longestSamedtString;
                longestSamedtString = new StringBuilder();
                //longestSamedtString = "";
                System.out.println(finalLongest);
            }

            if(x==prog2Length-1){
                System.out.println(finalLongest);
            }
        }


        //System.out.println(finalLongest + "\b");
        int percentage = diffCharCount / sameCharCount;


    }
}
