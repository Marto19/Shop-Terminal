package org.example.shop.goods;

import org.example.shop.goods.exeptions.idExistsExeption;
import org.example.shop.goods.goods.Goods;
import org.example.shop.goods.overridenstructures.LimitedHashMap;

import javax.security.auth.callback.CallbackHandler;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Shop {
    private BigDecimal foodMarkup;
    private BigDecimal nonFoodMarkup;
    private int numberOfCheckouts;
    private int expiryDateDiscount;
    private Map<Integer, Cashiers> cashiersCheckoutMap;
    private Map<Long, Goods> idAndGoods;
    private Map<Long, String> idAndCashier;
    private Map<Integer, String> quantityAndGoods;
    private Set<Cashiers> cashiersSet;


    public Shop(BigDecimal foodMarkup, BigDecimal nonFoodMarkup, int numberOfCheckouts, int expiryDateDiscount) {
        this.foodMarkup = foodMarkup;
        this.nonFoodMarkup = nonFoodMarkup;
        this.numberOfCheckouts = numberOfCheckouts;
        this.expiryDateDiscount = expiryDateDiscount;
        this.cashiersCheckoutMap = new HashMap<>();
        this.idAndGoods = new HashMap<>();
        this.idAndCashier = new LimitedHashMap<>(numberOfCheckouts);
        this.quantityAndGoods = new HashMap<>();
        this.cashiersSet = new HashSet<>();
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

    public Map<Long, String> getIdAndCashier() {
        return idAndCashier;
    }

    public Map<Integer, String> getQuantityAndGoods() {
        return quantityAndGoods;
    }

    public Set<Cashiers> getCashiersSet() {
        return cashiersSet;
    }

    public Cashiers checkIfIdExists(Cashiers cashiers) throws idExistsExeption {
        if (idAndCashier.containsKey(cashiers.getId())){
            throw new idExistsExeption("ID already exists");
        }
        else{
            return cashiers;
        }
    }

    public void addEmployeeToStore(Cashiers cashier){
        idAndCashier.put(cashier.getId(), cashier.getName());
    }

    public void addEmployeeToSet(Cashiers cashier){
        cashiersSet.add(cashier);
    }


    public void addGoodsToMap(Goods goods, int quantity){
        //principno tuk shte e po-dobre da gi razdedlish na foodtype i nonfoodtype
        quantityAndGoods.put(quantity, goods.getName());
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
                ", idAndCashier=" + idAndCashier +
                ", quantityAndGoods=" + quantityAndGoods +
                '}';
    }

    public void printIdAndCashier(){
        for (Map.Entry<Long, String> entry : idAndCashier.entrySet()){
            System.out.println("Id: " + entry.getKey() + " | " + "name: " + entry.getValue());
        }
    }

    public void printCashiers(){
        for (Cashiers cashier : cashiersSet){
            System.out.println(cashier);
        }
    }

    public void addCashierToSet(Cashiers cashier){
        cashiersSet.add(cashier);
    }

    public void assignCashierToCheckout(int numberOfCheckouts, Set<Cashiers> cashiersSet) {
        int checkoutNumber = 1;
        for (Cashiers cashier : cashiersSet) {
            cashiersCheckoutMap.put(checkoutNumber++, cashier);
        }
    }

    public void printCheckoutAndCashier(){
        for (Map.Entry<Integer, Cashiers> entry : cashiersCheckoutMap.entrySet()){
            System.out.println("Checkout: " + entry.getKey() + " | " + " name: " + entry.getValue().getName() + " id = " + entry.getValue().getId());
        }
    }
//        int checkoutNumber = 1;
//        for (Map.Entry<Long, Cashiers> entry : idAndCashier.entrySet()) {
//            Long id = entry.getKey();
//            Cashiers cashier = entry.getValue();
//            if (checkoutNumber > numberOfCheckouts) {
//                checkoutNumber = 1;
//            }
//            cashiersCheckoutMap.put(checkoutNumber++, cashier);
//        }

//cashiersCheckoutMap.put(checkoutNumber, cashier);
}
