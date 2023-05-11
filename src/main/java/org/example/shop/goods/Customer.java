package org.example.shop.goods;

import org.example.shop.goods.goods.Goods;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private String name;
    private BigDecimal balance;
    private Map<Goods, Integer> shoppingList = new HashMap<>();        //thats the shopping list

    public Customer(String name, BigDecimal balance, Map<Goods, Integer> shoppingList) {
        this.name = name;
        this.balance = balance;
        this.shoppingList = shoppingList;
    }

    public Customer(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Map<Goods, Integer> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(Map<Goods, Integer> shoppingList) {
        this.shoppingList = shoppingList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", shoppingList=" + shoppingList +
                '}';
    }

    public static List<Customer> generateRandomCustomers(int numCustomers) {
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < numCustomers; i++) {
            customers.add(generateRandomCustomer());
        }
        return customers;
    }

    public static Customer generateRandomCustomer() {
        String name = getRandomName();
        BigDecimal balance = getRandomBalance();
        Map<String, Integer> shoppingList = getRandomShoppingList();
        return new Customer(name, balance, shoppingList);
    }

    private static String getRandomName() {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Emily", "Frank", "Grace", "Henry", "Isabelle", "Jack"};
        return names[(int) (Math.random() * names.length)];
    }

    private static BigDecimal getRandomBalance() {
        return new BigDecimal(Math.random() * 500 + 50).setScale(2, RoundingMode.HALF_UP);
    }

    private static Map<String, Integer> getRandomShoppingList() {
        Map<String, Integer> shoppingList = new HashMap<>();
        String[] goods = {"apple", "banana", "orange", "peach", "pear", "grape", "watermelon", "pineapple", "mango"};
        //NEED TO MAKE IT WITH THE ITEMS THAT STORE OFFERS, IF THE STORE DO NOT OFFER-EXCEPTION
        int numItems = (int) (Math.random() * 5 + 1);
        for (int i = 0; i < numItems; i++) {
            String item = goods[(int) (Math.random() * goods.length)];
            int quantity = (int) (Math.random() * 5 + 1);
            shoppingList.put(item, quantity);
        }
        return shoppingList;
    }

    public static void printCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

}
