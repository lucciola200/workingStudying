package com.company.bookExercises.Chapter1;

import java.util.*;

public class countWovelsAndConsonants {
    private static final Set<Character> allVowels =  new HashSet(Arrays.asList('a', 'e','i','o','u'));
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        countWAndC(input);
        countWAndC2(input);
    }

    public static Map<Integer,Integer> countWAndC(String str) {
        str = str.toLowerCase();
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                vowels++;
            }else {
                consonants++;
            }
        }

        System.out.println("vowels " + vowels);
        System.out.println("consonants " + consonants);
        return Map.of(vowels,consonants);
    }

    //smt is wrong
    public static void countWAndC2(String str) {
        str = str.toLowerCase();
        long vowels = str.chars().filter(c -> allVowels.contains(c)).count();

        long consonants = str.chars().filter(c -> !allVowels.contains(c)).filter(ch -> (ch >= 'a' && ch <= 'z')).count();

        System.out.println("vowels " + vowels);
        System.out.println("consonants " + consonants);

    }
}
