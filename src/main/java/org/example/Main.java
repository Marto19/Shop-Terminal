package org.example;

import org.example.shop.Chekout;
import org.example.shop.goods.Cashiers;
import org.example.shop.goods.Customer;
import org.example.shop.goods.Shop;
import org.example.shop.goods.exeptions.EmployeesExceedShopLimit;
import org.example.shop.goods.goods.Goods;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //WE NEED TO CREATE OUR SHOP,GIVING IT FOOD/NONFOOD MARKUP,numberOfCheckouts, expiryDateDiscount
        Shop shop = new Shop(BigDecimal.valueOf(20), BigDecimal.valueOf(20), 15, BigDecimal.valueOf(5));
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

        System.out.println();
        System.out.println("CASHIERS:");
        shop.printCashiers();

        //now that we've created our cashiers, we need to assign them checkouts
        Chekout chekout = new Chekout(1);
        chekout.generateCheckOuts(shop.getNumberOfCheckouts(), shop);

        System.out.println();
        System.out.println("The checkouts: ");
        shop.printCheckoutSet();

        shop.assignCashierToCheckout(shop.getCheckoutSet(), shop.getCashiersSet());
        System.out.println();
        System.out.println("Id of the checkout and the cashier information:");
        shop.printCheckoutAndCashier();

        //now we need customers
//        List<Customer> customers = Customer.generateRandomCustomers(10);
//        System.out.println();
//        System.out.println("These are the customers: ");
//        Customer.printCustomers(customers);


        //and now that we have our shop ready, the cashiers ready
        System.out.println();
        System.out.println("Shops Inventory: ");
        Goods goods = new Goods();
        goods.generateGoods(10, shop, 50);
        shop.printStoreGoods();
    }

}

