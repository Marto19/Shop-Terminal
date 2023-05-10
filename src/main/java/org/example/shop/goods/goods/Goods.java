package org.example.shop.goods.goods;

import org.example.shop.goods.Shop;
import org.example.shop.goods.exeptions.expiryDateExeption;
import org.example.shop.goods.services.Services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class Goods implements Services {
    private final long id;
    private String name;
    private BigDecimal unitShippingCost;
    private Type type;
    private LocalDate expiryDate;
    private boolean isMarked;
    private int quantity;

    private final String[] FOODNAMES = {"apple", "banana", "orange", "watermelon", "grape", "pineapple", "mango", "pear", "kiwi", "strawberry"};
    private final String[] NONFOODNAMES = {"shampoo", "battery", "glass", "notebook", "keyboard", "monitor", "headphones", "skate", "book", "bike"};
    private final BigDecimal MAX_COST = new BigDecimal("100");

    public Goods(long id, String name, BigDecimal unitShippingCost, Type type, LocalDate expiryDate, int quantity) {
        this.id = id;
        this.name = name;
        this.unitShippingCost = unitShippingCost;
        this.type = type;
        this.expiryDate = expiryDate;
        this.isMarked = false;
        this.quantity = quantity;
    }

    public Goods() {
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitShippingCost() {
        return unitShippingCost;
    }

    public Type getType() {
        return type;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitShippingCost=" + unitShippingCost +
                ", type=" + type +
                ", expiryDate=" + expiryDate +
                ", isMarked=" + isMarked +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public BigDecimal calculateGoodsSellingPrice(Shop shop) {
        LocalDate currentDate = LocalDate.now();
        long daysUntilExpiry = currentDate.until(expiryDate, ChronoUnit.DAYS);
        if (type == Type.FOOD ) {
            if (daysUntilExpiry <= 10) {
                unitShippingCost = applyFoodMarkup(unitShippingCost, shop.getFoodMarkup());//new number = old number + (old number * 0.1)
                subtractFromPrice(unitShippingCost, shop);//SUBTRACT FROM THE PRICE
            } else {
                handleExpiredProduct();
            }
        } else if(type == Type.NONFOOD){
            if(daysUntilExpiry <= 10){
                unitShippingCost = applyFoodMarkup(unitShippingCost, shop.getNonFoodMarkup());//new number = old number + (old number * 0.1)
                subtractFromPrice(unitShippingCost, shop);//SUBTRACT FROM THE PRICE
            } else{
                handleExpiredProduct();
            }
        }
        return null;
    }

    private BigDecimal applyFoodMarkup(BigDecimal cost, BigDecimal markup) {
        BigDecimal percent = markup.divide(BigDecimal.valueOf(100));
        unitShippingCost = cost.add(cost.multiply(percent));
        return percent;
    }

    private BigDecimal applyNonFoodMarkup(BigDecimal cost, BigDecimal markup) {
        BigDecimal percent = markup.divide(BigDecimal.valueOf(100));
        unitShippingCost = cost.add(cost.multiply(percent));
        return percent;
    }

    private BigDecimal subtractFromPrice(BigDecimal unitShippingCost, Shop shop) {
        unitShippingCost = unitShippingCost.multiply(BigDecimal.valueOf(shop.getExpiryDateDiscount()).divide(BigDecimal.valueOf(100)));
        return unitShippingCost;                // logic to subtract from price goes here
    }

    private void handleExpiredProduct() {
        try {
            throw new expiryDateExeption("This product has expired.");
        } catch (expiryDateExeption e) {
            throw new RuntimeException(e);
        }
    }

    //when generating random goods we need to put them in the set
    public void generateGoods(int number, Shop shop, int quantity) {
        Random rand = new Random();
        Set<Goods> goodsSet = shop.getStoreGoods();
        int id = goodsSet.size() + 1; // initialize the id to the size of goodsSet + 1

        for (int i = 1; i <= number; i++) {
            Type type = Type.values()[rand.nextInt(Type.values().length)];
            String[] names = type == Type.FOOD ? FOODNAMES : NONFOODNAMES;
            String name = names[rand.nextInt(names.length)];

            BigDecimal unitShippingCost = new BigDecimal(rand.nextInt(MAX_COST.intValue()) + 1);
            LocalDate expiryDate = LocalDate.now().plusDays(rand.nextInt(365));

            Goods goods = new Goods(id, name, unitShippingCost, type, expiryDate, quantity);
            shop.addGoodsToSet(goods);
            id++; // increment the id by 1
        }
    }

}

