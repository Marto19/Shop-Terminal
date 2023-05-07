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
    private BigDecimal foodMarkup;                          //food markup
    private BigDecimal nonFoodMarkup;                       //non food markup
    private int numberOfCheckouts;                          //the amount of checkouts in the store
    private int expiryDateDiscount;                         //expiry date discount
    private Map<Integer, Cashiers> cashiersCheckoutMap;    //hashmap to store the assigment of each cashier to a checkout
    private Map<Long, Goods> idAndGoods;                //hashmap to store the id of the goods------------
    private Map<Long, String> idAndCashier;             //hashmap to store cashier's id and his/hers name. Nore: randomly generated
    private Map<Goods, Integer> goodsAndQuantity;       //hashmap to store goods and they're quantity in the store
    private Set<Cashiers> cashiersSet;      //set to store all the cashiers
    private Map<Goods, Integer> goodsAndQuantityAfterMarking;   //map to store the goods and they're quantity after marking/selling



    public Shop(BigDecimal foodMarkup, BigDecimal nonFoodMarkup, int numberOfCheckouts, int expiryDateDiscount) {
        this.foodMarkup = foodMarkup;
        this.nonFoodMarkup = nonFoodMarkup;
        this.numberOfCheckouts = numberOfCheckouts;
        this.expiryDateDiscount = expiryDateDiscount;   //when creating a shop object, the user needs to specify only
        this.cashiersCheckoutMap = new HashMap<>();     //the food/nonfood markup, the number of chouts and expiry date discount
        this.idAndGoods = new HashMap<>();
        this.idAndCashier = new LimitedHashMap<>(numberOfCheckouts);  //when creating a new store the other storages will be created automatically
        this.goodsAndQuantity = new HashMap<>();
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

    public Map<Goods, Integer> getQuantityAndGoods() {
        return goodsAndQuantity;
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
        goodsAndQuantity.put(goods, quantity);
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
                ", quantityAndGoods=" + goodsAndQuantity +
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

    public void removeGoodsQuantity(Shop shop, Goods good, int quantity){
        Integer currentQuantity = shop.goodsAndQuantity.get(good);
        if (currentQuantity != null) {
            int newQuantity = currentQuantity - quantity;
            if (newQuantity <= 0) {
                // if the new quantity is zero or negative, remove the good from the map
                shop.goodsAndQuantity.remove(good);
            } else {
                // otherwise, update the map with the new quantity
                shop.goodsAndQuantity.put(good, newQuantity);
            }
        }
    }
}
