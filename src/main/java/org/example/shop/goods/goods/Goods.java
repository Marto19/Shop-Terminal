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

    public Goods(long id, String name, BigDecimal unitShippingCost, Type type, LocalDate expiryDate) {
        this.id = id;//sdsdsd
        this.name = name;
        this.unitShippingCost = unitShippingCost;
        this.type = type;
        this.expiryDate = expiryDate;
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

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitShippingCost=" + unitShippingCost +
                ", type=" + type +
                ", expiryDate=" + expiryDate +
                '}';
    }

    @Override
    public BigDecimal calculateGoodsSellingPrice(Shop shop) {
        LocalDate currentDate = LocalDate.now();
        long daysUntilExpiry = currentDate.until(expiryDate, ChronoUnit.DAYS);
        if (type == Type.FOOD ) {
            if (daysUntilExpiry <= 10) {
                unitShippingCost = unitShippingCost.add(unitShippingCost.multiply(shop.getFoodMarkup().divide(BigDecimal.valueOf(100))));//new number = old number + (old number * 0.1)
                //Make it do something//SUBTRACT FROM THE PRICE
            } else {
                try {
                    throw new expiryDateExeption("Тhis product has expired.");
                } catch (expiryDateExeption e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else if(type == Type.NONFOOD){
            if(daysUntilExpiry <= 10){
                //make it do something else//SUBTRACT FROM THE PRICE
            }else{
                try {
                    throw new expiryDateExeption("Тhis product has expired.");
                } catch (expiryDateExeption e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }
}
