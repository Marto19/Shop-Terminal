package org.example.shop;

import org.example.shop.goods.Customer;
import org.example.shop.goods.Shop;
import org.example.shop.goods.services.CheckoutServices;

import java.util.UUID;

public class Chekout implements CheckoutServices {
    private final int uid;

    public Chekout(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return "Chekout: " +
                "uid=" + uid;
    }

    public void generateCheckOuts(int numberOfChekouts, Shop shop){
        for (int i = 0; i < numberOfChekouts; ++i){
            Chekout chekout = new Chekout(i);
            shop.addCheckoutToSet(chekout);
        }
    }


    @Override
    public void sellGoods(Customer customer, Shop shop) {

    }
}
