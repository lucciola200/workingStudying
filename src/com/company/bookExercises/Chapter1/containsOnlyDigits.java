package com.company.bookExercises.Chapter1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class containsOnlyDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(containsOnlyDig(str));
        System.out.println(containsOnlyDig2(str));
        System.out.println(containsOnlyDig3(str));
    }

    public static boolean containsOnlyDig(String str) {

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsOnlyDig2(String str) {
        return str.chars().anyMatch(n -> Character.isDigit(n));//works not for all digits. just if string contains only 1 it returns true.  asdf132 -> true
    }

    public static boolean containsOnlyDig3(String str) {
        return str.matches("[0-9]+");
    }
}
