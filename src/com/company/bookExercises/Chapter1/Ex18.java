package com.company.bookExercises.Chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class Ex18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str2 = sc.nextLine();

        System.out.println(isAnagram(str, str2));
    }

    public static boolean isAnagram(String str1, String str2) {

        char[] chStr1 = str1.replaceAll("\\s","").toLowerCase().toCharArray();
        char[] chStr2 = str2.replaceAll("\\s","").toLowerCase().toCharArray();

        Arrays.sort(chStr1);
        Arrays.sort(chStr2);

        return Arrays.equals(chStr1,chStr2);
    }
}
