package com.company.bookExercises.Chapter1;

import java.util.*;


public class Ex14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        occurenseMax(str);

    }

    public static void occurenseMax(String str) {
        char[] chArray = str.toCharArray();
        char currentCh = ' ';
        int codeCh = 0;
        for (int i = 0; i < chArray.length; i++) {
            if ((int) chArray[i] > codeCh) {
                codeCh = (int) chArray[i];
                currentCh = chArray[i];
            }
        }
        System.out.println(codeCh + " " + currentCh);
    }
}
