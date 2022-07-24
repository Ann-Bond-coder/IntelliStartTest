package com.company;

import java.util.Scanner;

/**
 * (Medium level)
 * The starter class.
 * Management in the menu is carried out at the expense of selected commands in the console.
 * Variations of operations are presented to the client in the console.
 * The client can stop the program at any time, and the program also terminates with a message
 * if the error happens.
 */
public class Main {

    public static void main(String[] args) {
        menuController();
    }

    /**
     * The method is created to add products and users to a list and
     * perform various operations on the list.
     */
    public static void menuController() {
        int userIdGenerated = 1, productIdGenerated = 1;
        String NameEntered, LastNameEntered;
        double AmountOfMoneyEntered;
        HashSetUsers hashSetUser = new HashSetUsers();
        HashSetProducts hashSetProduct = new HashSetProducts();
        while (true) {
            System.out.print("""
                    You are in menu. Please choose the operation you want to make and write it.\s
                    Operations: 'add user', 'show all users', 'delete user', 'add product','show all products', 'delete product', 'break'.\s
                     Your choice:\s""");
            Scanner in = new Scanner(System.in);
            String operation = in.nextLine();
            switch (operation) {
                case "add user":
                    System.out.print("Enter the user's name: ");
                    NameEntered = in.nextLine();
                    System.out.print("Enter the user's last name: ");
                    LastNameEntered = in.nextLine();
                    System.out.print("Enter the user's amount of money: ");
                    AmountOfMoneyEntered = in.nextDouble();
                    hashSetUser.addUser(userIdGenerated, NameEntered, LastNameEntered,
                            AmountOfMoneyEntered);
                    userIdGenerated++;
                    break;
                case "show all users":
                    if (hashSetUser == null) {
                        System.out.println("There are no users in the list.");
                        System.exit(0);
                    } else {
                        HashSetUsers.showUsers();
                    }
                    break;
                case "delete user":
                    System.out.print("Enter the name of user you want to delete: ");
                    NameEntered = in.nextLine();
                    System.out.print("Enter the last name of user you want to delete: ");
                    LastNameEntered = in.nextLine();
                    hashSetUser.deleteUser(NameEntered, LastNameEntered);
                    break;
                case "add product":
                    System.out.print("Enter the product's name: ");
                    NameEntered = in.nextLine();
                    System.out.print("Enter the product's price: ");
                    AmountOfMoneyEntered = in.nextDouble();
                    hashSetProduct.addProduct(productIdGenerated, NameEntered,
                            AmountOfMoneyEntered);
                    productIdGenerated++;
                    break;
                case "delete product":
                    System.out.print("Enter the name of product you want to delete: ");
                    NameEntered = in.nextLine();
                    hashSetProduct.deleteProduct(NameEntered);
                    break;
                case "show all products":
                    if (hashSetProduct == null) {
                        System.out.println("There are no products in the list.");
                        System.exit(0);
                    } else {
                        hashSetProduct.showProducts();
                    }
                    break;
                case "break":
                    System.exit(0);
                    break;
                default:
                    System.out.print("You've entered the wrong operation.\n");
                    System.exit(0);
            }
        }
    }
}
