package org.example.shop.goods;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String name;
    private BigDecimal balance;
    private Map<String, Integer> shoppingList = new HashMap<>();

    public Customer(String name, BigDecimal balance, Map<String, Integer> shoppingList) {
        this.name = name;
        this.balance = balance;
        this.shoppingList = shoppingList;
    }

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

    public Map<String, Integer> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(Map<String, Integer> shoppingList) {
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
}
