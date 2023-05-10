package org.example.shop;

import org.example.shop.goods.Cashiers;
import org.example.shop.goods.Shop;
import org.example.shop.goods.goods.Goods;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Receipt {

    private final int nextNumber;
    private Cashiers cashier;
    private LocalDate localDate;
    private ArrayList<String> goodsList;
    private BigDecimal sum;

    public Receipt(int nextNumber, Cashiers cashier, LocalDate localDate, ArrayList<String> goodsList, BigDecimal sum) {
        this.nextNumber = nextNumber;
        this.cashier = cashier;
        this.localDate = localDate;
        this.goodsList = goodsList;
        this.sum = sum;
    }

    public int getNextNumber() {
        return nextNumber;
    }

    public Cashiers getCashier() {
        return cashier;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public ArrayList<String> getGoodsList() {
        return goodsList;
    }

    public BigDecimal getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "nextNumber=" + nextNumber +
                ", cashier=" + cashier +
                ", localDate=" + localDate +
                ", goodsList=" + goodsList +
                ", sum=" + sum +
                '}';
    }
}
