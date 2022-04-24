package com.company.hiperskill.BudgetManager.Stage4_MemorablePurchases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int menu = 0;
        float income = 0;
        ArrayList<String> purchases = new ArrayList<>();
        ArrayList<Float> prices = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        TreeMap<String, List > categorisedList =new TreeMap<>();
        String fileName = "purchases.txt";

        menu = showMenu();
        while (menu != 0) {
            switch (menu) {
                case 1:
                    System.out.println();
                    income = enterIncome();
                    System.out.println();
                    menu = showMenu();
                    break;
                case 2:
                    System.out.println();
                    addPurchase(purchases, prices,categorisedList);
                    System.out.println();
                    menu = showMenu();
                    break;
                case 3:
                    System.out.println();
                    showListOfPurchase(purchases, prices, categorisedList);
                    System.out.println();
                    menu = showMenu();
                    break;
                case 4:
                    System.out.println();
                    showBalance(income,prices);
                    System.out.println();
                    menu = showMenu();
                    break;
                case 5:
                    System.out.println();
                    savePurchases(income,purchases, prices, categorisedList);
                    System.out.println();
                    menu = showMenu();
                    break;
                case 6:
                    System.out.println();
                    income = LoadPurchases(fileName, purchases, prices, categorisedList);
                    System.out.println();
                    System.out.println("Purchases were loaded!");
                    System.out.println();
                    menu = showMenu();
                    break;
                case 0:
                    System.out.println();
                    System.exit(0);
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + menu);
            }
        }
        System.out.println();
        System.out.println("Bye!");

    }


    public static int showMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("0) Exit");
        return scanner.nextInt();
    }

    public static float enterIncome(){
        float inc = 0;
        System.out.println("Enter income:");
        Scanner scanner = new Scanner(System.in);
        inc = scanner.nextFloat();
        System.out.println("Income was added!");
        return inc;
    }

    private static void addPurchase(ArrayList<String> purchases, ArrayList<Float> prices, TreeMap<String, List> categorisedList) {
        int catInt = showCategories();
        String category =  convertCategory(catInt);
        while (catInt > 0 && catInt < 5) {
            List<Integer> indexes = new ArrayList<>();
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter purchase name:");
            purchases.add(scanner.nextLine());
            System.out.println("Enter its price:");
            prices.add(scanner.nextFloat());
            System.out.println("Purchase was added!");


            if (categorisedList.get(category) == null) {
                indexes.add(prices.size()-1);
                categorisedList.put(category, indexes);
            }else {
                indexes = categorisedList.get(category);
                indexes.add(prices.size()-1);
                categorisedList.put(category, indexes);
            }

            System.out.println();
            catInt = showCategories();
            category =  convertCategory(catInt);
        }

    }

    private static int showCategories() {
        System.out.println("Choose the type of purchases");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) Back");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String convertCategory(int i) {
        switch (i) {
            case 1:
                return "Food";
            case 2:
                return "Clothes";
            case 3:
                return "Entertainment";
            case 4:
                return "Other";
            case 5:
                return "All";
            case 6:
                return "Back";
        }
        return "Back";
    }

    private static void showListOfPurchase(ArrayList<String> purchases, ArrayList<Float> prices, TreeMap<String, List> categorisedList) {

        if (categorisedList.size() == 0) {
            System.out.println("The purchase list is empty!");
            return;
        }
        float total = 0;
        int choose = chooseCategories();
        String category =  convertCategory(choose);
        List<Integer> indexes = new ArrayList<>();
        while (choose != 6) {
            System.out.println();
            System.out.println(category + ":");
            if (choose != 5 && categorisedList.get(category) == null){
                System.out.println("The purchase list is empty!");
            }else if (choose != 5){
                total = 0;
                indexes = categorisedList.get(category);
                for (int i = 0; i < indexes.size(); i++) {
                    System.out.print(purchases.get(indexes.get(i)) + " $" + prices.get(indexes.get(i)));
                    total += prices.get(indexes.get(i));
                    System.out.println();
                }System.out.println("Total sum: $" + total);
            }else {
                total = 0;
                for (Map.Entry<String, List> entry  : categorisedList.entrySet()) {
                    indexes = entry.getValue();
                    for (int i = 0; i < indexes.size(); i++) {
                        System.out.print(purchases.get(indexes.get(i)) + " $" + prices.get(indexes.get(i)));
                        total += prices.get(indexes.get(i));
                        System.out.println();
                    }
                }System.out.println("Total sum: $" + total);
            }
            System.out.println();
            choose = chooseCategories();
            category =  convertCategory(choose);
            indexes = new ArrayList<>();
        }


    }

    private static int chooseCategories() {
        System.out.println("Choose the type of purchases");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) All");
        System.out.println("6) Back");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void showBalance(float income, ArrayList<Float> prices) {
        income -= getTotal(prices);
        System.out.printf("Balance: $%.2f", income);
        System.out.println();
    }

    private static float getTotal(ArrayList<Float> prices) {
        float total = 0;
        for (int i = 0; i < prices.size(); i++) {
            total += prices.get(i);
        }
        return total;
    }

    private static void savePurchases(float income, ArrayList<String> purchases, ArrayList<Float> prices, TreeMap<String, List> categorisedList) throws IOException {
        File file = new File("purchases.txt");
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();

        System.out.println(MapToString(categorisedList));
        Path path = Paths.get(file.getPath());
        appendToFile(path,  Float.toString(income) + "\n");
        appendToFile(path,  purchases.toString() + "\n");
        appendToFile(path,  ArrylistToString(prices) + "\n");
        appendToFile(path,  MapToString(categorisedList));
    }

    private static void appendToFile(Path path, String content)
            throws IOException {

        // if file not exists throws java.nio.file.NoSuchFileException
        /* Files.write(path, content.getBytes(StandardCharsets.UTF_8),
						StandardOpenOption.APPEND);*/

        // if file not exists, create and write to it
        // otherwise append to the end of the file
        Files.write(path, content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);

    }

    private static Float LoadPurchases(String fileName, ArrayList<String> purchases, ArrayList<Float> prices, TreeMap<String, List> categorisedList) throws FileNotFoundException {
        File file = new File(fileName); // pathToFile is non null String variable
        Scanner scanner = new Scanner(file);
        ArrayList<String> myList = new ArrayList<String>();
        int lineCount = 1;
        float inc = 0;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            line = line.replace(" ","");
            switch (lineCount){
                case 1:
                    inc = Float.valueOf(line);
                    break;
                case 2:
                    line = line.replace("[","");
                    line = line.replace("]","");
                    ArrayList<String> arrl = new ArrayList<String>(Arrays.asList(line.split(",")));
                    for (String el:arrl) {
                        purchases.add(el);
                    }
                    break;
                case 3:
                    StringToArrylist(line, prices);
                    break;
                case 4:
                    StringToMap(line, categorisedList);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + lineCount);
            }
            lineCount++;
        }
        return inc;
    }

    public static String ArrylistToString(ArrayList<Float> arrL) {
        String str = arrL.toString();
        str = str.replace(" ","");
        str = str.replace("[","");
        str = str.replace("]","");
        return str;
    }

    public static void StringToArrylist(String str, ArrayList<Float> arrLF) {
        List list = Arrays.asList(str.split(","));
        for (Object el:list) {
            arrLF.add(Float.parseFloat((String) el));
        }
    }

    private static String MapToString(TreeMap<String, List> categorisedList) {
        categorisedList.toString();
        String str = categorisedList.toString();
        str = str.replace(" ","");
        str = str.replace("{","");
        str = str.replace("}","");

        return str;
    }

    public static void StringToMap(String str, TreeMap<String, List> tMap) {
        String mstr;
        List list = Arrays.asList(str.split("],"));
        for (Object el:list) {
            mstr = (String) el;
            mstr = mstr.replace("[","");
            mstr = mstr.replace("]","");
            String[] pairs = mstr.split("=");
            if (pairs.length == 2) {
                String[] string = pairs[1].split(",");
                List<Integer> arr = new ArrayList<Integer>();
                for (int i = 0; i < string.length; i++) {
                    arr.add(Integer.valueOf(string[i]));
                }
                tMap.put(pairs[0], arr);
            }
        }
    }
}

