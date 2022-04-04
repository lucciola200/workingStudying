package com.company.hiperskill.BudgetManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountNumbersInAFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\teona.odisharia\\Downloads\\dataset_91022.txt");
        Scanner scanner = new Scanner(file);
        int count =0;
        while (scanner.hasNext()) {
            if (scanner.nextInt() >= 9999) {
                count++;
            }
        }
        System.out.println(count);
    }
}
