package org.example;

import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static LemonadeStand lemonadeStand = new LemonadeStand();

    public static void main(String[] args) {
        System.out.println("Hello world!");
        mainMenu();
    }

    public static void mainMenu() {
        while (true) {
            System.out.println("--------------------------------");
            System.out.println(" Main Menu");
            System.out.println("--------------------------------");
            System.out.println("1. Enter Normal Sale");
            System.out.println("2. Enter Custom Sale");
            System.out.println("3. Display Inventory");
            System.out.println("4. Display Money");
            System.out.println("5. Buy Supplies");
            System.out.println("6. Sell Discounted Lemonade");
            System.out.println("7. Exit");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                enterNormalSale();
            } else if (choice.equals("2")) {
                enterCustomSale();
            } else if (choice.equals("3")) {
                displayInventory();
            } else if (choice.equals("4")) {
                displayMoney();
            } else if (choice.equals("5")) {
                buySupplies();
            } else if (choice.equals("6")){
                enterDiscountedSale();
            } else if (choice.equals("7")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    public static void enterNormalSale() {
        System.out.println("Enter the number of lemonades to sell:");
        int numLemonades = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numLemonades; i++) {
            if (lemonadeStand.sellLemonade()) {
                System.out.println("Lemonade sold!");
            } else {
                System.out.println("Not enough supplies to sell lemonade.");
            }
        }
    }

    public static void enterDiscountedSale() {
        System.out.println("Enter the number of lemonades to sell:");
        int numLemonades = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the discount:");
        double discountRate = Double.parseDouble(scanner.nextLine());

        for (int i = 0; i < numLemonades; i++) {
            if (lemonadeStand.sellLemonade(discountRate)) {
                System.out.println("Lemonade sold!");
            } else {
                System.out.println("Not enough supplies to sell lemonade.");
            }
        }
    }

    public static void enterCustomSale() {
        System.out.println("Enter the number of lemons to use:");
        int lemons = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the number of sugar to use:");
        int sugar = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the number of ice to use:");
        int ice = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the number of lemonades to sell:");
        int numLemonades = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numLemonades; i++) {
            if (lemonadeStand.sellLemonade(lemons, sugar, ice)) {
                System.out.println("Lemonade sold!");
            } else {
                System.out.println("Not enough supplies to sell lemonade.");
            }
        }
    }

    public static void displayInventory() {
        System.out.println("Lemons: " + lemonadeStand.getLemons());
        System.out.println("Sugar: " + lemonadeStand.getSugar());
        System.out.println("Ice: " + lemonadeStand.getIce());
    }

    public static void displayMoney() {
        System.out.println("Money: $" + lemonadeStand.getMoney());
    }

    public static void buySupplies() {
        System.out.println("Enter the number of lemons to buy:");
        int lemons = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the number of sugar to buy:");
        int sugar = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the number of ice to buy:");
        int ice = Integer.parseInt(scanner.nextLine());

        lemonadeStand.buySupplies(lemons, sugar, ice);
    }
}