package com.company.bookExercises.Chapter1;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(removeWhitespaces(str));
    }

    public static String removeWhitespaces(String str) {
        return str.replaceAll("\\s", "");
    }
}
