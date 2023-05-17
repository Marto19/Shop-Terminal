package org.example.shop.goods.services;

import org.example.shop.goods.Customer;
import org.example.shop.goods.Shop;

public interface CheckoutServices {
    public void sellGoods(Customer customer, Shop shop);
}
