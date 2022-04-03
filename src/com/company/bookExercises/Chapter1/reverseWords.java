package com.company.bookExercises.Chapter1;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class reverseWords {
    private static final String WHiTSPACE = " ";
    private static final Pattern PATTERN = java.util.regex.Pattern.compile(" +");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(reverseW(str));
        System.out.println(reverseW2(str));
    }

    public static String reverseW(String str) {
        String[] words = str.split(WHiTSPACE);
        StringBuilder reverseString = new StringBuilder();

        for (String word:words) {
            StringBuilder reverseWord = new StringBuilder();

            for (int i = word.length()-1; i >=0 ; i--) {
                reverseWord.append(word.charAt(i));
            }
            reverseString.append(reverseWord).append(WHiTSPACE);
        }

        return reverseString.toString();
    }

    public static String reverseW2(String str) {
        return PATTERN.splitAsStream(str).map(w-> new StringBuilder(w).reverse()).collect(Collectors.joining(" "));

    }
}
