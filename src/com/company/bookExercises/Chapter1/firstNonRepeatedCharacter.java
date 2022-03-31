package com.company.bookExercises.Chapter1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class firstNonRepeatedCharacter {
    private static final int EXTENDED_ASCII_CODES = 256;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        firstNonRepeatedCh(input);
        firstNonRepeatedCh2(input);

    }

    public static Character firstNonRepeatedCh(String str) {
        int flags[] = new int[EXTENDED_ASCII_CODES];

        for (int i = 0; i < flags.length; i++) {
            flags[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (flags[ch] == -1) {
                flags[ch] = i;
            }else {
                flags[ch] = -2;
            }
        }

        int position = Integer.MAX_VALUE;

        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (flags[i] >= 0) {
                position = Integer.min(position, flags[i]);
            }
        }

        System.out.println(str.charAt(position));
        return 'a';
    }

    public static Character firstNonRepeatedCh2(String str) {
        Map<Character, Integer> chars = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            chars.compute(ch, (k,v) -> (v == null) ? 1 : ++v );
        }

        for (Map.Entry<Character, Integer> entry: chars.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                return entry.getKey();
            }
        }
        
        return Character.MIN_VALUE;
    }

    public static String firstNonRepeatedCh3(String str) {
//        Map<String, Long> chs = (Map<String, Long>) str.codePoints().mapToObj(cp -> cp)
//                .collect(groupingBy(c->c, Collectors.counting()));

        return"";
    }
}
