package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * HashSetProducts - contains the list of products.
 * Methods in this class allowed adding new products, deleting the product
 * and printing out the whole list of all products.
 */
public class HashSetProducts {
    static HashSet<Products> productsHashSet = new HashSet<Products>();
    static HashSet<Users> usersHashSet = new HashSet<Users>();

    /**
     * Method for adding a new product with a set of parameters.
     *
     * @param productId    - the id of the product that generated automatically.
     * @param productName  - the name of the product that the client writes in console.
     * @param productPrice - the price of the product that the client writes in console.
     */
    public void addProduct(int productId, String productName, double productPrice) {
        if (productName.isBlank()) {
            System.out.println("The product's name is incorrect!");
            System.exit(0);
        } else {
            if (productPrice < 0) {
                System.out.println("You entered the wrong price! " +
                        "The product's price must be more than 0!");
                System.exit(0);
            } else {
                productsHashSet.add(new Products(productId, productName, productPrice));
                System.out.println("The product has been added.");
            }
        }
    }

    /**
     * Method for showing all products that had been added before.
     * The whole information about the product is being printed out
     * (The product's id, name and price).
     */
    public void showProducts() {
        System.out.println(productsHashSet.toString());
    }

    /**
     * Method for deleting the product out of the list.
     * <p>
     * The product that should be deleted finds by the name.
     * The deletion criteria is specified by the client in the console.
     * The method catches exceptions, such as: empty list of products and misprinting.
     *
     * @param productName - the name of the product that the client writes in console.
     */
    public void deleteProduct(String productName) {
        if (!productsHashSet.isEmpty()) {
            Iterator<Products> iterator = productsHashSet.iterator();
            Products product = iterator.next();
            Iterator<Users> iteratorUsers = usersHashSet.iterator();
            Users user = iteratorUsers.next();
            /*For deleting the product from the list*/
            while ((iterator.hasNext()) && (!product.getProductName().equals(productName))) {
                product = iterator.next();
            }
            if (product.getProductName().equals(productName)) {
                iterator.remove();
                System.out.println("The product " + productName + "has been deleted successfully.");
            } else {
                System.out.println("Error. There are no products with this name in the list! ");
                System.exit(0);
            }
            /*For deleting the product from user purchases*/
            while ((iteratorUsers.hasNext()) && (!user.getPurchases().equals(productName))) {
                user = iteratorUsers.next();
            }
            if (user.getPurchases().equals(productName)) {
                user.setPurchases(null);
            }
        } else {
            System.out.println("Error. There are no products in the list.");
            System.exit(0);
        }
    }
}