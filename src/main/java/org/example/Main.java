package org.example;

import org.example.shop.goods.Cashiers;
import org.example.shop.goods.Shop;
import org.example.shop.goods.goods.Goods;
import org.example.shop.goods.goods.Type;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(BigDecimal.valueOf(20), BigDecimal.valueOf(20), 15, 15);
        System.out.println(shop);

        Cashiers cashier1 = new Cashiers("Marinka", 1,BigDecimal.valueOf(1500));
        shop.addEmployeeToStore(cashier1);
        shop.printCashierAndId();

        Goods good1 = new Goods(1, "bob", BigDecimal.valueOf(3), Type.FOOD, LocalDate.of(2023,6,5));
    }
}

