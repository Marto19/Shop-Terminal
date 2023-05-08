package org.example;

import org.example.shop.goods.Cashiers;
import org.example.shop.goods.Customer;
import org.example.shop.goods.Shop;
import org.example.shop.goods.exeptions.EmployeesExceedShopLimit;
import org.example.shop.goods.goods.Goods;

import java.math.BigDecimal;
import java.util.List;

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

        System.out.println();
        System.out.println("CASHIERS:");
        shop.printCashiers();

        //now that we've created our cashiers, we need to assign them checkouts
        shop.assignCashierToCheckout(shop.getNumberOfCheckouts(), shop.getCashiersSet());
        System.out.println();
        System.out.println("Id of the checkout and the cashier information:");
        shop.printCheckoutAndCashier();

        //now we need customers
        List<Customer> customers = Customer.generateRandomCustomers(5);
        System.out.println();
        System.out.println("These are the customers: ");
        Customer.printCustomers(customers);

        //and now that we have our shop ready, the cashiers ready
        System.out.println();
        System.out.println("NQKWI GOODS TAM: ");
        Goods goods = new Goods();
        goods.generateGoods(5, shop, 50);
        shop.printStoreGoods();
    }

}

