package com.company;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file1 = new File("C:/Users/nelsonsee/IdeaProjects/test_program1.java");
        File file2 = new File("C:/Users/nelsonsee/IdeaProjects/test_program2.java");

        if (file1.compareTo(file2) == 0) {
            System.out.println("Both codes are equal");
        } else {
            System.out.println("Both codes are not equal");
        }
    }

}
