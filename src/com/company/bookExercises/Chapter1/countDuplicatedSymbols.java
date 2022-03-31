package com.company.bookExercises.Chapter1;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class countDuplicatedSymbols{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        countDuplicatedCharacters(input);
        countDuplicatedCharacters2(input);
        countDuplicatedCharacters3(input);
    }

    public static Map<Character, Integer> countDuplicatedCharacters(String str) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.compute(ch, (k,v) -> (v == null) ? 1 : ++v);
        }
        System.out.println(result);
        return result;
    }
    public static Map<Character, Long> countDuplicatedCharacters2(String str) {
        Map<Character, Long> result =  str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(result);
        return result;
    }

    public static Map<String, Long> countDuplicatedCharacters3(String str) {
        Map<String, Long> result = str.codePoints()
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
        System.out.println(result);
        return result;
    }
}
