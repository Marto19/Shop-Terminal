package org.example.shop.goods;

import org.example.shop.Chekout;
import org.example.shop.goods.exeptions.idExistsExeption;
import org.example.shop.goods.goods.Goods;
import org.example.shop.goods.goods.Type;
import org.example.shop.goods.overridenstructures.LimitedHashMap;

import java.math.BigDecimal;
import java.util.*;

public class Shop {
    private BigDecimal foodMarkup;                          //food markup       --ENUM MAP
    private BigDecimal nonFoodMarkup;                       //non food markup --ENUM MAP//KEY TYPE, VALUE BIGDECIMAL
    private EnumMap<Type, BigDecimal> foodTypeMarkup;
    private int numberOfCheckouts;                          //the amount of checkouts in the store
    private BigDecimal expiryDateDiscount;                         //expiry date discount
    //dateuntils-DOBAWI DNITE SPORED MAGAZINA
    private int daysUntilExpiry;

    private Map<Chekout, Cashiers> cashiersCheckoutMap;    //hashmap to stoNE TRWQQre the assigment of each cashier to a checkout
    private Map<Long, String> idAndCashier;             //hashmap to store cashier's id and his/hers name. Nore: randomly generated
    private Set<Cashiers> cashiersSet;      //set to store all the cashiers
    private Set<Goods> storeGoods;          //store's inventory
    private Set<Chekout> checkoutSet;       //set with the checkouts


    public Shop(BigDecimal foodMarkup, BigDecimal nonFoodMarkup, int numberOfCheckouts, BigDecimal expiryDateDiscount) {
        this.foodMarkup = foodMarkup;
        this.nonFoodMarkup = nonFoodMarkup;
        this.numberOfCheckouts = numberOfCheckouts;
        this.expiryDateDiscount = expiryDateDiscount;   //when creating a shop object, the user needs to specify only
        this.cashiersCheckoutMap = new HashMap<>();     //the food/nonfood markup, the number of chouts and expiry date discount
        this.idAndCashier = new LimitedHashMap<>(numberOfCheckouts);  //when creating a new store the other storages will be created automatically
        this.cashiersSet = new HashSet<>();
        this.storeGoods = new HashSet<>();
        this.checkoutSet = new HashSet<>();
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

    public BigDecimal getExpiryDateDiscount() {
        return expiryDateDiscount;
    }

    public Map<Chekout, Cashiers> getCashiersCheckoutMap() {
        return cashiersCheckoutMap;
    }


    public Map<Long, String> getIdAndCashier() {
        return idAndCashier;
    }

    public Set<Cashiers> getCashiersSet() {
        return cashiersSet;
    }

    public Set<Chekout> getCheckoutSet() {
        return checkoutSet;
    }

    public Set<Goods> getStoreGoods() {
        return storeGoods;
    }

    public Cashiers checkIfIdExists(Cashiers cashiers) throws idExistsExeption {
        if (idAndCashier.containsKey(cashiers.getId())) {
            throw new idExistsExeption("ID already exists");
        } else {
            return cashiers;
        }
    }

    public void addEmployeeToStore(Cashiers cashier) {
        idAndCashier.put(cashier.getId(), cashier.getName());
    }

    public void addCashierToSet(Cashiers cashier) {
        cashiersSet.add(cashier);
    }

    public void addGoodsToSet(Goods goods) {
        storeGoods.add(goods);
    }

    public void addCheckoutToSet(Chekout chekout) {
        checkoutSet.add(chekout);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "foodMarkup=" + foodMarkup +
                ", nonFoodMarkup=" + nonFoodMarkup +
                ", numberOfCheckouts=" + numberOfCheckouts +
                ", expiryDateDiscount=" + expiryDateDiscount +
                ", cashiersCheckoutMap=" + cashiersCheckoutMap +
                ", idAndCashier=" + idAndCashier +
                ", quantityAndGoods=" + storeGoods +
                '}';
    }

    public void assignCashierToCheckout(Set<Chekout> checkoutSet, Set<Cashiers> cashierSet) {
        Iterator<Cashiers> cashierIterator = cashierSet.iterator();
        for (Chekout checkout : checkoutSet) {
            if (cashierIterator.hasNext()) {
                Cashiers cashier = cashierIterator.next();
                cashiersCheckoutMap.put(checkout, cashier);
                cashiersCheckoutMap.containsValue(cashier); //
            } else {
                break; // stop assigning cashiers if we run out of cashiers
            }
        }
    }

    public void printCheckoutAndCashier() {
        for (Map.Entry<Chekout, Cashiers> entry : cashiersCheckoutMap.entrySet()) {
            System.out.println("Checkout: " + entry.getKey() + " | " + " name: " + entry.getValue().getName() + " id = " + entry.getValue().getId());
        }
    }

    public void printCheckoutSet() {
        for (Chekout chekout : checkoutSet) {
            System.out.println(chekout);
        }
    }

    public void printIdAndCashier() {
        for (Map.Entry<Long, String> entry : idAndCashier.entrySet()) {
            System.out.println("Id: " + entry.getKey() + " | " + "name: " + entry.getValue());
        }
    }

    public void printCashiers() {
        for (Cashiers cashier : cashiersSet) {
            System.out.println(cashier);
        }
    }


    public void printStoreGoods() {
        for (Goods goods : getStoreGoods()) {
            System.out.println(goods);
        }
    }


}

//TODO: CREATE RECEIPT CLASS, EVERYTIME WE SELL A GOOD FROM THE STORE TO BE CREATED. INFO NEEDED:Next number,
//cashier who issues the receipt, date and time of issuance of the receipt, list of
//goods that are included in the receipt including their price and quantity and the total
//value to be paid by the customer
