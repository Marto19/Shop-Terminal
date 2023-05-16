package org.example.shop.goods;

import org.example.shop.goods.exeptions.ShopEmptyException;
import org.example.shop.goods.goods.Goods;
import org.example.shop.goods.goods.Type;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Customer {
    private String name;
    private BigDecimal balance;
    private Map<Goods, Integer> shoppingList = new HashMap<>();        //that's the shopping list
    private static final String[] CUSTOMER_NAMES = {"John", "Emily", "Michael", "Emma", "Daniel", "Olivia", "David", "Sophia"};
    private static final BigDecimal MAX_BALANCE = new BigDecimal("1000");
    private static final int MAX_GOODS_PER_CUSTOMER = 5;
    private static final int MAX_QUANTITY_PER_GOOD = 10;

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
    public Map<Goods, Integer> getShoppingList() {
        return shoppingList;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    //-------------------------methods to generate random customer--------------------------------
//    public static List<Customer> generateRandomCustomers(int count) {
//        List<Customer> customers = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            customers.add(generateRandomCustomer());
//        }
//        return customers;
//    }
//
//    private static Customer generateRandomCustomer() {
//        Random random = new Random();
//        String name = getRandomName(random);
//        BigDecimal balance = getRandomBalance(random);
//        Map<Goods, Integer> shoppingList = generateRandomShoppingList(random);
//        return new Customer(name, balance, shoppingList);
//    }
//
//    private static String getRandomName(Random random) {
//        int index = random.nextInt(CUSTOMER_NAMES.length);
//        return CUSTOMER_NAMES[index];
//    }
//
//    private static BigDecimal getRandomBalance(Random random) {
//        double value = random.nextDouble() * MAX_BALANCE.doubleValue();
//        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
//    }
//
//    private static Map<Goods, Integer> generateRandomShoppingList(Random random) {
//        Map<Goods, Integer> shoppingList = new HashMap<>();
//        int goodsCount = random.nextInt(MAX_GOODS_PER_CUSTOMER) + 1;
//        for (int i = 0; i < goodsCount; i++) {
//            Goods goods = generateRandomGoods(random);
//            int quantity = random.nextInt(MAX_QUANTITY_PER_GOOD) + 1;
//            shoppingList.put(goods, quantity);
//        }
//        return shoppingList;
//    }
//
//    private static Goods generateRandomGoods(Random random) {
//        long id = random.nextLong();
//        String name = "Random Goods";
//        BigDecimal unitShippingCost = BigDecimal.valueOf(random.nextDouble() * 100).setScale(2, RoundingMode.HALF_UP);
//        Type type = Type.values()[random.nextInt(Type.values().length)];
//        return new Goods(id, name, unitShippingCost, type, null, 0);
//    }

    public static void printCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }


}
