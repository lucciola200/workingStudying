package com.company.bookExercises.Chapter1;

import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        System.out.println(concatRepeat(str, n));

        //2
        String result = str.repeat(n);
        System.out.println(result);
    }

    public static String  concatRepeat(String str, int n) {
        StringBuilder sb = new StringBuilder(str.length() * n);

        for (int i = 0; i < n; i++) {
            sb.append(str);

        }
        return sb.toString();
    }
}
