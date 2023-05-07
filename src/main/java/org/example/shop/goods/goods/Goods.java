package org.example.shop.goods.goods;

import org.example.shop.goods.Shop;
import org.example.shop.goods.exeptions.expiryDateExeption;
import org.example.shop.goods.services.Services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Goods implements Services {
    private final long id;
    private String name;
    private BigDecimal unitShippingCost;
    private Type type;
    private LocalDate expiryDate;
    private boolean isMarked;

    public Goods(long id, String name, BigDecimal unitShippingCost, Type type, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.unitShippingCost = unitShippingCost;
        this.type = type;
        this.expiryDate = expiryDate;
        this.isMarked = false;
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
            throw new expiryDateExeption("Тhis product has expired.");
        } catch (expiryDateExeption e) {
            throw new RuntimeException(e);
        }
    }

}
