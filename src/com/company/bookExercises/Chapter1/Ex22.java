package com.company.bookExercises.Chapter1;

public class Ex22 {
    public static void main(String[] args) {
        String[] text = {"abcd","abc","ab","abcde","abcdef"};

        System.out.println(publicLongestPrefix(text));
    }

    public static String publicLongestPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        int firstLenght = strs[0].length();
        for (int prefixLenght = 0; prefixLenght < firstLenght; prefixLenght++) {
            char ch = strs[0].charAt(prefixLenght);
            for (int i = 0; i < strs.length; i++) {
                if (prefixLenght >= strs[i].length()
                || strs[i].charAt(prefixLenght) != ch){
                    return strs[i].substring(0,prefixLenght);
                }
            }
            
        }

        return strs[0];
    }
}
