package com.company.hiperskill.BudgetManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FindTheGreatestNumberInAFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\teona.odisharia\\Downloads\\dataset_91007.txt");
        Scanner s = new Scanner(file);
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        System.out.println(Collections.max(list));

        File fl = new File("C:\\Users\\teona.odisharia\\Downloads\\file.txt");

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("Lorem ipsum");
            fileWriter.write(" dolor sit amet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
