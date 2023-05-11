package org.example.shop.goods;

import org.example.shop.Chekout;
import org.example.shop.goods.exeptions.idExistsExeption;
import org.example.shop.goods.goods.Goods;
import org.example.shop.goods.overridenstructures.LimitedHashMap;

import javax.security.auth.callback.CallbackHandler;
import java.math.BigDecimal;
import java.util.*;

public class Shop {
    private BigDecimal foodMarkup;                          //food markup       --ENUM MAP
    private BigDecimal nonFoodMarkup;                       //non food markup --ENUM MAP//KEY TYPE, VALUE BIGDECIMAL
    private int numberOfCheckouts;                          //the amount of checkouts in the store
    private BigDecimal expiryDateDiscount;                         //expiry date discount
    //dateuntils-DOBAWI DNITE SPORED MAGAZINA

    private Map<Chekout, Cashiers> cashiersCheckoutMap;    //hashmap to stoNE TRWQQre the assigment of each cashier to a checkout
    private Map<Long, Goods> idAndGoods;                //hashmap to sNE TRQQ tore the id of the goods------------im not sure if i need it
    private Map<Long, String> idAndCashier;             //hashmap to store cashier's id and his/hers name. Nore: randomly generated
    //private Map<Goods, Integer> goodsAndQuantity;       //hashmap to store goods and they're quantity in the store
    private Set<Cashiers> cashiersSet;      //set to store all the cashiers
    private Set<Goods> storeGoods;          //store's inventory
    private Set<Chekout> checkoutSet;       //set with the checkouts


    public Shop(BigDecimal foodMarkup, BigDecimal nonFoodMarkup, int numberOfCheckouts, int expiryDateDiscount) {
        this.foodMarkup = foodMarkup;
        this.nonFoodMarkup = nonFoodMarkup;
        this.numberOfCheckouts = numberOfCheckouts;
        this.expiryDateDiscount = expiryDateDiscount;   //when creating a shop object, the user needs to specify only
        this.cashiersCheckoutMap = new HashMap<>();     //the food/nonfood markup, the number of chouts and expiry date discount
        this.idAndGoods = new HashMap<>();
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

    public int getExpiryDateDiscount() {
        return expiryDateDiscount;
    }

    public Map<Chekout, Cashiers> getCashiersCheckoutMap() {
        return cashiersCheckoutMap;
    }

    public Map<Long, Goods> getIdAndGoods() {
        return idAndGoods;
    }

    public Map<Long, String> getIdAndCashier() {
        return idAndCashier;
    }

//    public Map<Goods, Integer> getQuantityAndGoods() {
//        return goodsAndQuantity;
//    }

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

//    public void addGoodsToMap(Goods goods, int quantity){
//        //principno tuk shte e po-dobre da gi razdedlish na foodtype i nonfoodtype
//        goodsAndQuantity.put(goods, quantity);
//    }

//    public Map<Goods, Integer> getGoodsAndQuantity() {
//        return goodsAndQuantity;
//    }

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
                //", quantityAndGoods=" + goodsAndQuantity +
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


//    public void removeGoodsQuantity(Customer customer, Shop shop) {
//        Map<String, Integer> shoppingList = customer.getShoppingList();
//        Set<Goods> storeGoods = shop.getStoreGoods();
//        for (Map.Entry<String, Integer> entry : shoppingList.entrySet()) {
//            String goodName = entry.getKey();
//            int desiredQuantity = entry.getValue();
//            if (!storeGoods.stream().anyMatch(g -> g.getName().equals(goodName))) {
//                // Skip if the good is not in the inventory
//                continue;
//            }
//            Goods good = storeGoods.stream()
//                    .filter(g -> g.getName().equals(goodName))
//                    .findFirst()
//                    .orElse(null);
//
//            if (good != null && good.getQuantity() >= desiredQuantity) {
//                int availableQuantity = good.getQuantity();
//                int updatedQuantity = availableQuantity - desiredQuantity;
//                good.setQuantity(updatedQuantity);
//            } else {
//                // Skip if the desired quantity is greater than the available quantity
//                continue;
//            }
//        }
//
//        shop.setStoreGoods(storeGoods);
//    }

}

//TODO: CREATE RECEIPT CLASS, EVERYTIME WE SELL A GOOD FROM THE STORE TO BE CREATED. INFO NEEDED:Next number,
//cashier who issues the receipt, date and time of issuance of the receipt, list of
//goods that are included in the receipt including their price and quantity and the total
//value to be paid by the customer
