package com.company.hiperskill.BudgetManager;

import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            try {
                int x = Integer.parseInt(str);
                if (x == 0) {
                    return;
                }
                System.out.println(x * 10);

            } catch (Exception e) {
                System.out.println("Invalid user input: " + str);
            }
        }
    }
}
