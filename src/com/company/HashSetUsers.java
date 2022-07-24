package com.company;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSetUsers - contains the list of users.
 * Methods in this class allowed adding new users, deleting the user
 * and printing out the whole list of all users.
 */
public class HashSetUsers {
    static HashSet<Users> usersHashSet = new HashSet<Users>();

    /**
     * Method for adding a new user with a set of parameters.
     *
     * @param userId            - the id of user that generated automatically.
     * @param userName          - the name of user that the client writes in console.
     * @param userLastName      - the last name of user that the client writes in console.
     * @param userAmountOfMoney - the money that user has,
     *                          also the client writes in console the amount.
     */
    public void addUser(int userId, String userName, String userLastName, double userAmountOfMoney, String purchases) {
        if (userName.isBlank() || userLastName.isBlank()) {
            System.out.println("The user's name or last name is incorrect!");
            System.exit(0);
        } else {
            if (userAmountOfMoney < 0) {
                System.out.println("You entered the wrong amount of money! " +
                        "The client's money amount must be more than 0!");
                System.exit(0);
            } else {
                usersHashSet.add(new Users(userId, userName, userLastName, userAmountOfMoney, purchases));
                System.out.println("The user has been added.");
            }
        }
    }

    /**
     * Method for showing all users that had been added before.
     * The whole information about the user is being printed out.
     * (The user's id, name, last name and amount of money that they have).
     */
    public static void showUsers() {
        System.out.println(usersHashSet.toString());
    }

    /**
     * Method for deleting the user out of the list.
     * <p>
     * The user that should be deleted finds by the name and last name.
     * The deletion criteria are specified by the client in the console.
     * The method catches exceptions, such as: empty list of users and misprinting.
     *
     * @param userName     - the name of user that the client writes in console.
     * @param userLastName - the last name of user that the client writes in console.
     */
    public void deleteUser(String userName, String userLastName) {
        if (!usersHashSet.isEmpty()) {
            Iterator<Users> iterator = usersHashSet.iterator();
            Users user = iterator.next();
            while ((iterator.hasNext()) && (!user.getUserName().equals(userName)) && (!user.getUserLastName().equals(userLastName))) {
                user = iterator.next();
            }
            if ((user.getUserName().equals(userName)) && (user.getUserLastName().equals(userLastName))) {
                iterator.remove();
                System.out.println("The user " + userName + " " + userLastName + "has been deleted successfully.");
            } else {
                System.out.println("Error. There are no users with this name and last name in the list!");
                System.exit(0);
            }
        } else {
            System.out.println("Error. There are no users in the list.");
            System.exit(0);
        }
    }
}


