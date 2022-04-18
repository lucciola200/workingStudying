package com.company.bookExercises.Chapter1;

import java.util.Scanner;

public class Ex17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(countSubString(str, str2));
    }

    public static int countSubString(String text, String toFind) {
        int position = 0;
        int count = 0;
        int n = toFind.length();

        while ((position = text.indexOf(toFind,position)) !=-1){
            position = position + n;
            count++;
        }
        return count;
    }
}
