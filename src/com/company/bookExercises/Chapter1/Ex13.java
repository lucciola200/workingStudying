package com.company.bookExercises.Chapter1;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ch = sc.nextLine().charAt(0);
        System.out.println(removeCharacter(str,ch));
        System.out.println(removeCharacter2(str,ch));
        System.out.println(removeCharacter3(str,ch));


    }

    public static String removeCharacter(String str, char ch) {
        return str.replaceAll(Pattern.quote(String.valueOf(ch)),"");
    }

    public static String removeCharacter2(String str, char ch) {
        StringBuilder sb = new StringBuilder();
        char[] chArray = str.toCharArray();
        for (char c: chArray) {
            if (c != ch) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String removeCharacter3(String str, char ch) {

        return str.chars()
                .filter(c->c != ch)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}
