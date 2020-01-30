import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class Plagiarism {
    public static void main(String[] args) {

        int countChar=0;
        int countTotal=0;
        float percentage;
        try {
            File program1 = new File("C:\\Users\\Jay Chan\\IdeaProjects\\KENACT01\\Files\\test_program1.cpp");
            File program2 = new File("C:\\Users\\Jay Chan\\IdeaProjects\\KENACT01\\Files\\test_program2.cpp");
            Scanner myProg1 = new Scanner(program1);
            Scanner myProg2 = new Scanner(program2);
            while (true) {
                if(myProg1.hasNext() && myProg2.hasNext())
                {
                    String data1 = myProg1.nextLine();
                    String data2 = myProg2.nextLine();
                    int i=0;
                    while(true)
                    {
                        if(i<data1.length() && i<data2.length()){
                            if(data1.charAt(i)==data2.charAt(i))
                            {
                                countChar++;
                                countTotal++;
                            }
                            i++;
                        }
                        else if(i<data2.length())
                        {
                            countTotal++;
                            i++;
                        }
                        else if(i<data1.length())
                        {
                            countTotal++;
                            i++;
                        }
                        else
                        {
                            break;
                        }
                    }

                }
                else if(myProg1.hasNext())
                {
                    countTotal=countTotal+myProg1.nextLine().length();
                }
                else if(myProg2.hasNext())
                {
                    countTotal=countTotal+myProg2.nextLine().length();
                }
                else{
                    break;
                }

            }
            myProg1.close();
            myProg2.close();
            percentage=(float)countChar/(float) countTotal;
            System.out.println("The plagiarism content is "+percentage*100+"%");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}