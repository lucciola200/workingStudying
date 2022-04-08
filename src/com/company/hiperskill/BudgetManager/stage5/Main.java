package com.company.hiperskill.BudgetManager.stage5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Float> foodPurchases = new LinkedHashMap<>();
    private static Map<String, Float> clothesPurchases = new LinkedHashMap<>();
    private static Map<String, Float> entertainmentPurchases = new LinkedHashMap<>();
    private static Map<String, Float> otherPurchases = new LinkedHashMap<>();
    private static Float balance = 0F;
    private static Float foodBalance = 0F;
    private static Float clothesBalance = 0F;
    private static Float entertainmentBalance = 0F;
    private static Float otherBalance = 0F;
    private static File file = new File("purchases.txt");

    public static void main(String[] args) {
        boolean exit = false;

        do {
            printMenu();

            int check = Integer.parseInt(scanner.nextLine());

            printBlankLine();

            switch (check) {
                case 1:
                    addIncome();
                    break;
                case 2:
                    addPurchase();
                    break;
                case 3:
                    showList();
                    break;
                case 4:
                    printBalance();
                    break;
                case 5:
                    saveFile();
                    break;
                case 6:
                    loadFile();
                    break;
                case 7:
                    analyze();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }

            printBlankLine();
        } while (!exit);

        System.out.println("Bye!");
    }

    static private void printBlankLine() {
        System.out.println();
    }

    static private void printMenu() {
        System.out.printf(
                "%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                "Choose your action:",
                "1) Add income",
                "2) Add purchase",
                "3) Show list of purchases",
                "4) Balance",
                "5) Save",
                "6) Load",
                "7) Analyze (Sort)",
                "0) Exit"
        );
    }

    static private void printAddTypeMenu() {
        System.out.printf(
                "%s\n%s\n%s\n%s\n%s\n%s\n",
                "Choose the type of purchase",
                "1) Food",
                "2) Clothes",
                "3) Entertainment",
                "4) Other",
                "5) Back"
        );
    }

    static private void printShowTypeMenu() {
        System.out.printf(
                "%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                "Choose the type of purchase",
                "1) Food",
                "2) Clothes",
                "3) Entertainment",
                "4) Other",
                "5) All",
                "6) Back"
        );
    }

    static private void addIncome() {
        System.out.println("Enter income:");

        balance += Float.parseFloat(scanner.nextLine());

        System.out.println("Income was added!");
    }

    static private void addPurchase() {
        boolean exit = false;

        do {
            printAddTypeMenu();

            int type = Integer.parseInt(scanner.nextLine());

            printBlankLine();
            switch (type) {
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.println("Enter purchase name:");

                    String purchaseName = scanner.nextLine();

                    System.out.println("Enter its price:");

                    float purchasePrice = Float.parseFloat(scanner.nextLine());

                    addPurchase(purchaseName, purchasePrice, type);

                    System.out.println("Purchase was added!");

                    printBlankLine();
                    break;
                default:
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    static private void addPurchase(String name, float price, int type) {
        switch (type) {
            case 1:
                foodPurchases.put(name, price);
                foodBalance += price;
                break;
            case 2:
                clothesPurchases.put(name, price);
                clothesBalance += price;
                break;
            case 3:
                entertainmentPurchases.put(name, price);
                entertainmentBalance += price;
                break;
            case 4:
                otherPurchases.put(name, price);
                otherBalance += price;
                break;
            default:
                break;
        }
    }

    static private void showList() {
        if (foodPurchases.isEmpty() && clothesPurchases.isEmpty() && otherPurchases.isEmpty() && entertainmentPurchases.isEmpty()) {
            System.out.println("Purchase list is empty");
        }

        boolean exit = false;

        do {
            printShowTypeMenu();

            int type = Integer.parseInt(scanner.nextLine());

            printBlankLine();

            switch (type) {
                case 1:
                    System.out.println("Food:");
                    showList(foodPurchases);
                    System.out.printf("Total sum: $%.2f\n", foodBalance);
                    printBlankLine();
                    break;
                case 2:
                    System.out.println("Clothes:");
                    showList(clothesPurchases);
                    System.out.printf("Total sum: $%.2f\n", clothesBalance);
                    printBlankLine();
                    break;
                case 3:
                    System.out.println("Entertainment:");
                    showList(entertainmentPurchases);
                    System.out.printf("Total sum: $%.2f\n", entertainmentBalance);
                    printBlankLine();
                    break;
                case 4:
                    System.out.println("Other:");
                    showList(otherPurchases);
                    System.out.printf("Total sum: $%.2f\n", otherBalance);
                    printBlankLine();
                    break;
                case 5:
                    System.out.println("All:");
                    showList(foodPurchases);
                    showList(clothesPurchases);
                    showList(entertainmentPurchases);
                    showList(otherPurchases);
                    System.out.printf("Total sum: $%.2f\n", foodBalance + clothesBalance + entertainmentBalance + otherBalance);
                    printBlankLine();
                    break;
                default:
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    static private void showList(Map<String, Float> purchases) {
        purchases.forEach(
                (product, price) -> {
                    System.out.printf("%s $%.2f\n", product , price);
                }
        );
    }

    static private void printBalance() {
        System.out.printf("Balance: $%.2f\n", balance - foodBalance - clothesBalance - entertainmentBalance - otherBalance);
    }

    static public void saveFile() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Cannot create the file: " + file.getPath());
        }

        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.printf("Balance:%.2f\n", balance);
            printList(foodPurchases, printWriter, "1");
            printList(clothesPurchases, printWriter, "2");
            printList(entertainmentPurchases, printWriter, "3");
            printList(otherPurchases, printWriter, "4");
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }

        System.out.println("\nPurchases were saved!\n");
    }

    static private void printList(Map<String, Float> purchases, PrintWriter writer, String category) {
        purchases.forEach(
                (product, price) -> {
                    writer.printf("%s,%s,%.2f\n", category, product , price);
                }
        );
    }

    static public void loadFile() {
        try (Scanner scanner = new Scanner(file)) {
            String balanceLine = scanner.nextLine();

            if (balanceLine.contains("Balance")) {
                balance = Float.parseFloat(balanceLine.split(":")[1]);
            }

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] arr = line.split(",");

                int type = Integer.parseInt(arr[0]);
                String item = arr[1];
                float price = Float.parseFloat(arr[2]);

                addPurchase(item, price, type);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + file);
        }

        System.out.println("Purchases were loaded!");
    }

    static private void printSortMenu() {
        System.out.printf(
                "%s\n%s\n%s\n%s\n%s\n",
                "How do you want to sort?",
                "1) Sort all purchases",
                "2) Sort by type",
                "3) Sort certain type",
                "4) Back"
        );
    }

    static private void printSortTypeMenu() {
        System.out.printf(
                "%s\n%s\n%s\n%s\n%s\n",
                "Choose the type of purchase",
                "1) Food",
                "2) Clothes",
                "3) Entertainment",
                "4) Other"
        );
    }

    static private void analyze() {

        boolean exit = false;

        do {
            printSortMenu();

            int type = Integer.parseInt(scanner.nextLine());

            printBlankLine();

            switch (type) {
                case 1:
                    if (foodPurchases.isEmpty() && clothesPurchases.isEmpty() && otherPurchases.isEmpty() && entertainmentPurchases.isEmpty()) {
                        System.out.println("Purchase list is empty");

                        printBlankLine();
                        break;
                    }

                    System.out.println("All:");
                    List<Map.Entry<String, Float>> list = new ArrayList<>(foodPurchases.entrySet());
                    list.addAll(clothesPurchases.entrySet());
                    list.addAll(entertainmentPurchases.entrySet());
                    list.addAll(otherPurchases.entrySet());
                    list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

                    for (Map.Entry<String, Float> entry : list) {
                        System.out.printf("%s $%.2f\n", entry.getKey(), entry.getValue());
                    }

                    System.out.printf("Total: $%.2f\n", foodBalance + clothesBalance + entertainmentBalance + otherBalance);
                    printBlankLine();
                    break;
                case 2:
                    System.out.printf(
                            "%s\n%s%.2f\n%s%.2f\n%s%.2f\n%s%.2f\n%s%.2f\n",
                            "Types:",
                            "Food - $",
                            foodBalance,
                            "Entertainment - $",
                            entertainmentBalance,
                            "Clothes - $",
                            clothesBalance,
                            "Other - $",
                            otherBalance,
                            "Total sum: $",
                            foodBalance + clothesBalance + entertainmentBalance + otherBalance
                    );
                    printBlankLine();
                    break;
                case 3:
                    printSortTypeMenu();
                    printSortedType();
                    printBlankLine();
                    break;
                default:
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    static private void printSortedType() {
        if (foodPurchases.isEmpty() && clothesPurchases.isEmpty() && otherPurchases.isEmpty() && entertainmentPurchases.isEmpty()) {
            System.out.println("Purchase list is empty");
        }

        int type = Integer.parseInt(scanner.nextLine());

        printBlankLine();

        switch (type) {
            case 1:
                if (foodPurchases.isEmpty()) {
                    System.out.println("Purchase list is empty");
                    break;
                }

                System.out.println("Food:");

                foodPurchases.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .forEachOrdered(x -> System.out.printf("%s $%.2f\n", x.getKey(), x.getValue()));

                System.out.printf("Total sum: $%.2f\n", foodBalance);
                break;
            case 2:
                if (clothesPurchases.isEmpty()) {
                    System.out.println("Purchase list is empty");
                    break;
                }

                System.out.println("Clothes:");

                clothesPurchases.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .forEachOrdered(x -> System.out.printf("%s $%.2f\n", x.getKey(), x.getValue()));

                System.out.printf("Total sum: $%.2f\n", clothesBalance);
                break;
            case 3:
                if (otherPurchases.isEmpty()) {
                    System.out.println("Purchase list is empty");
                    break;
                }

                System.out.println("Entertainment:");

                otherPurchases.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .forEachOrdered(x -> System.out.printf("%s $%.2f\n", x.getKey(), x.getValue()));

                System.out.printf("Total sum: $%.2f\n", entertainmentBalance);
                break;
            case 4:
                if (entertainmentPurchases.isEmpty()) {
                    System.out.println("Purchase list is empty");
                    break;
                }

                System.out.println("Other:");

                entertainmentPurchases.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .forEachOrdered(x -> System.out.printf("%s $%.2f\n", x.getKey(), x.getValue()));

                System.out.printf("Total sum: $%.2f\n", otherBalance);
                break;
            default:
                break;
        }

        printBlankLine();
    }
}
