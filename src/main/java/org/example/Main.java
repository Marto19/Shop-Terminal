package org.example;

import org.example.shop.goods.Cashiers;
import org.example.shop.goods.Shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(BigDecimal.valueOf(20), BigDecimal.valueOf(20), 15, 15);
        System.out.println(shop);

        Cashiers cashier1 = new Cashiers("Marinka", 1,BigDecimal.valueOf(1500));
        shop.addEmployeeToStore(cashier1);
        shop.printCashierAndId();
    }
}