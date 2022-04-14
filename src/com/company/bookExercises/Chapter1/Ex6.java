package com.company.bookExercises.Chapter1;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char ch = scanner.nextLine().charAt(0);
        System.out.println(countCharactersInString(str, ch));
        System.out.println(countCharactersInString2(str, ch));
    }

    public static int countCharactersInString(String str, char ch) {

        int i = str.length() - str.replace(String.valueOf(ch), "").length();
        return i;
    }

    public static long countCharactersInString2(String str, char ch) {
        return str.chars().filter(c -> c == ch).count();
    }
}
