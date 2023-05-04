package org.example;

import org.example.shop.goods.Shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.2), 15);

    }
}