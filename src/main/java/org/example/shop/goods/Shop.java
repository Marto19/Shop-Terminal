package org.example.shop.goods;

import org.example.shop.goods.exeptions.idExistsExeption;
import org.example.shop.goods.goods.Goods;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Shop {
    private BigDecimal foodMarkup;
    private BigDecimal nonFoodMarkup;
    private int numberOfCheckouts;
    private int expiryDateDiscount;
    private Map<Integer, Cashiers> cashiersCheckoutMap;
    private Map<Long, Goods> idAndGoods;
    private Map<Long, Cashiers> cashierAndId;

    public Shop(BigDecimal foodMarkup, BigDecimal nonFoodMarkup, int numberOfCheckouts, int expiryDateDiscount) {
        this.foodMarkup = foodMarkup;
        this.nonFoodMarkup = nonFoodMarkup;
        this.numberOfCheckouts = numberOfCheckouts;
        this.expiryDateDiscount = expiryDateDiscount;
        this.cashiersCheckoutMap = new HashMap<>();
        this.idAndGoods = new HashMap<>();
        this.cashierAndId = new HashMap<>();
    }

    public BigDecimal getFoodMarkup() {
        return foodMarkup;
    }

    public BigDecimal getNonFoodMarkup() {
        return nonFoodMarkup;
    }

    public int getNumberOfCheckouts() {
        return numberOfCheckouts;
    }

    public int getExpiryDateDiscount() {
        return expiryDateDiscount;
    }

    public Map<Integer, Cashiers> getCashiersCheckoutMap() {
        return cashiersCheckoutMap;
    }

    public Map<Long, Goods> getIdAndGoods() {
        return idAndGoods;
    }

    public Map<Long, Cashiers> getCashierAndId() {
        return cashierAndId;
    }

    public Cashiers checkIfIdExists(Cashiers cashiers) throws idExistsExeption {
        if (cashierAndId.containsKey(cashiers.getId())){
            throw new idExistsExeption("ID already exists");
        }
        else{
            return cashiers;
        }
    }

    public void addEmployeeToStore(long id, Cashiers cashier){
        cashierAndId.put(cashier.getId(), cashier);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "foodMarkup=" + foodMarkup +
                ", nonFoodMarkup=" + nonFoodMarkup +
                ", numberOfCheckouts=" + numberOfCheckouts +
                ", expiryDateDiscount=" + expiryDateDiscount +
                ", cashiersCheckoutMap=" + cashiersCheckoutMap +
                ", idAndGoods=" + idAndGoods +
                ", cashierAndId=" + cashierAndId +
                '}';
    }
}
