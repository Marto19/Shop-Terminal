package org.example;

import org.example.shop.goods.Cashiers;
import org.example.shop.goods.Shop;
import org.example.shop.goods.exeptions.EmployeesExceedShopLimit;
import org.example.shop.goods.goods.Goods;
import org.example.shop.goods.goods.Type;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //WE NEED TO CREATE OUR SHOP,GIVING IT FOOD/NONFOOD MARKUP,numberOfCheckouts, expiryDateDiscount
        Shop shop = new Shop(BigDecimal.valueOf(20), BigDecimal.valueOf(20), 15, 15);
        System.out.println();
        System.out.println("Shop's information: ");
        System.out.println(shop);

        //GENERATING RANDOM CASHIERS
        Cashiers cashiers2 = new Cashiers();
        try {
            cashiers2.generateRandomEmployee(15, shop);
        } catch (EmployeesExceedShopLimit e) {
            System.out.println("Error: The number of employees exceeds the number of checkouts in the shop.");
        }

        System.out.println();
        System.out.println("Id and cashier's name: ");
        shop.printIdAndCashier();       //print all the cashiers with their ids

        //now that we've created our cashiers, we need to assign them checkouts
        shop.assignCashierToCheckout(shop.getNumberOfCheckouts(), shop.getCashiersSet());
        System.out.println();
        System.out.println("Id of the checkout and the cashier information:");
        shop.printCheckoutAndCashier();

    }

}

