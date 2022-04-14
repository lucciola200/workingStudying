package com.company.bookExercises.Chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char delimiter =  sc.nextLine().charAt(0);
        List<String> list = new ArrayList<String>();
        while (sc.hasNext()){
            list.add(sc.nextLine());
        }
        System.out.println(joinBydelimiter(delimiter, list));
        System.out.println(joinBydelimiter2(delimiter, list));
    }

    public static String joinBydelimiter(char delimiter,List args) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < args.size(); i++) {
            if (i == args.size()-1) {
                result.append(args.get(i));
            }else {
                result.append(args.get(i)).append(delimiter);
            }
        }
        return result.toString();
    }

    public static String joinBydelimiter2(char delimiter,List args) {
        StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));

        for (Object el:args) {
            joiner.add((String) el);
        }
        return joiner.toString();
    }
}
