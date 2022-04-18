package com.company.bookExercises.Chapter1;

import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(maicontainSubString(str, str2));
    }

    public static boolean maicontainSubString(String text, String subText) {
        return text.indexOf(subText) != -1;
    }
}
