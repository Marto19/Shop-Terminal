package org.example.shop.goods.services;

import org.example.shop.goods.Shop;

import java.math.BigDecimal;

public interface Services {
    BigDecimal calculateGoodsSellingPrice(Shop shop);
}
