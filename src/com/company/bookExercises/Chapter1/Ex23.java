package com.company.bookExercises.Chapter1;

import java.util.Arrays;
import java.util.List;

public class Ex23 {
    public static void main(String[] args) {
        String days = "Monday\n" + "Tuesday\n" + "Wednesday\n" +"Thursday\n" +"Friday\n" + "Saturday\n" + "Sunday\n";
        System.out.print(days.indent(10));

        List<String> daysList = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        for (int i = 0; i < daysList.size(); i++) {
            System.out.print(daysList.get(i).indent(i));
        }
    }
}
