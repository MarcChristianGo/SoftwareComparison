import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Matrix {
    public GridPane grid;
    ArrayList<String> file = new ArrayList<>();


    int size;

    public void initialize() throws IOException, IndexOutOfBoundsException {
        double score = 0;
        Matrix compare = new Matrix();
        ArrayList<String> files = new ArrayList<>();
        files = compare.read("Assets/GitHubSubmissions", files);
        String nextName[] = {""};
        String currentName[];
        int numberOfFiles = 1;

        grid.setAlignment(Pos.CENTER);
        for (int m = 0; m < files.size(); m++) {
            String name[] = files.get(m).split("/");
            grid.getColumnConstraints().addAll(new ColumnConstraints(80));

            grid.add(new Label(name[2]), 0, m + 1);
            grid.add(new Label(name[2]), m + 1, 0);

            for (int h = 0; h < files.size(); h++) {
                if(h+1<files.size()) {
                    nextName = files.get(h + 1).split("/");
                }

                score = score + compare.compare(files.get(m), files.get(h), m, h);
                System.out.println(name[2]+nextName[2]);
                if (name[2].equals(nextName[2])) {
                    numberOfFiles++;
                    System.out.println("same");
                }
                else {
                    System.out.println(numberOfFiles);
                    score = score / numberOfFiles;
                    grid.add(new Label(String.valueOf(score)), m + 1, h + 1);
                    numberOfFiles = 1;
                    score=0;
                }

            }
        }


    }

    public void setFile(ArrayList<String> file) {
        this.file = file;
    }

    public void setSize(int size) {
        this.size = size;
    }


    ArrayList<String> read(String file, ArrayList<String> files) {
        File folder = new File(file);
        File[] fileList = folder.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile()) {
                files.add(file + "/" + fileList[i].getName());
            } else if (fileList[i].isDirectory()) {
                read(file.toString() + "/" + fileList[i].getName(), files);
            }
        }
        return files;
    }

    void compareNew() throws IOException {


    }

    double compare(String file1, String file2, int m, int h) throws IOException {
        File test_program1 = new File(file1);
        File test_program2 = new File(file2);

        BufferedReader tp1 = new BufferedReader(new FileReader(test_program1));
        BufferedReader tp2 = new BufferedReader(new FileReader(test_program2));

        String string1 = tp1.readLine();
        String string2 = tp2.readLine();

        string1 = string1.replaceAll("\\s", "");
        string2 = string2.replaceAll("\\s", "");
        double total = 0;
        double same = 0;

        while (string1 != null) {
            total++;
            if (string1.equals(string2)) {
                same++;
            }
            string1 = tp1.readLine();
            string2 = tp2.readLine();
        }
        double percent = same / total;
        percent = Math.round(percent * 100.0) / 100.0;

        return percent;
    }
}
