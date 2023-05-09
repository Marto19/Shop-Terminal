package org.example.shop;

import org.example.shop.goods.Shop;

import java.util.UUID;

public class Chekout {
    private final int uid;

    public Chekout(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return "Chekout{" +
                "uid=" + uid +
                '}';
    }

    public void generateCheckOuts(int shop){

    }
}
