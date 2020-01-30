import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Main compare = new Main();
        compare.read("Assets/tocheck");
    }
    void read(String file){
        File folder = new File(file);
        File[] fileList = folder.listFiles();
        for(int i = 0; i <fileList.length; i++){
            if(fileList[i].isFile()){
                System.out.println("File " + fileList[i].getName());
            }
            else if (fileList[i].isDirectory()) {
                System.out.println("\nDirectory " + fileList[i].getName());
                read(file.toString()+"/"+fileList[i].getName());
            }
        }
    }
    void compareNew() throws IOException{

    }
    void compare(String file1, String file2) throws IOException{
        File test_program1 = new File(file1);
        File test_program2 = new File(file2);

        BufferedReader tp1 = new BufferedReader(new FileReader(test_program1));
        BufferedReader tp2 = new BufferedReader(new FileReader(test_program2));

        String string1=tp1.readLine();
        String string2=tp2.readLine();

        double total=0;
        double same=0;

        while (string1!=null){
            total++;
            if(string1.equals(string2)){
                same++;
            }
            string1=tp1.readLine();
            string2=tp2.readLine();
        }
        double percent = same/total*100;
        System.out.println("Java programs are "+percent+" % similar");
    }
}
