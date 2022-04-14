package com.company.bookExercises.Chapter1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //1
        permutedAndPrint(str);
        //2
        System.out.println(permutedAndStore(str));
    }

    //1
    public static void permutedAndPrint(String str) {
        permutedAndPrint("",str);
    }

    private static void permutedAndPrint(String prefix, String str) {
        int n = str.length();

        if (n == 0) {
            System.out.println(prefix + " ");
        }else {
            for (int i = 0; i < n; i++) {
                permutedAndPrint(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i));
            }
        }
    }

    //2
    public static Set<String> permutedAndStore(String str) {
       return permutedAndStore("",str);
    }

    private static Set<String> permutedAndStore(String prefix, String str) {
        Set<String> permutation = new HashSet<>();
        int n = str.length();

        if (n == 0) {
            permutation.add(prefix);
        }else {
            for (int i = 0; i < n; i++) {
                permutation.addAll(permutedAndStore(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i)));
            }
        }
        return permutation;
    }
}
