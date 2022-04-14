package com.company.bookExercises.Chapter1;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(isPalindrom(str));
        System.out.println(isPalindrom2(str));
        System.out.println(isPalindrom3(str));
    }

    public static boolean isPalindrom(String str) {
        int left = 0;
        int right = str.length()-1;
        while (left<right){
            if (str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrom2(String str) {
        int n = str.length();
        for (int i = 0; i < n/2; i++) {
            if (str.charAt(i)!=str.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrom3(String str) {
        return str.equals(new StringBuilder(str).reverse());
    }



}
