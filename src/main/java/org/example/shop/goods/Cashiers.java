package org.example.shop.goods;

import org.example.shop.goods.exeptions.EmployeesExceedShopLimit;
import org.example.shop.goods.goods.Goods;
import org.example.shop.goods.goods.Type;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class Cashiers {
    private String name;
    private final long id;
    private BigDecimal monthlySalary;

    public Cashiers(String name, long id, BigDecimal monthlySalary) {
        this.name = name;
        this.id = id;
        this.monthlySalary = monthlySalary;
    }

    public Cashiers() {             //HAVE THAT IN MIND
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "Cashiers{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", monthlySalary=" + monthlySalary +
                '}';
    }

    public void generateRandomEmployee(int numberOfEmployees, Shop shop) throws EmployeesExceedShopLimit {
        if(numberOfEmployees > shop.getNumberOfCheckouts()){
            handleExceedingEmployees();
        }
        else {
            Random random = new Random();
            for(int i = 0; i < numberOfEmployees; i++){
                String name = "Cashier" + random.nextInt(1000);
                //long id = random.nextLong();
                long id = i+1;
                BigDecimal monthlySalary = BigDecimal.valueOf(2000);//BigDecimal.valueOf(random.nextInt(5000) + 2000)
                Cashiers cashier = new Cashiers(name, id, monthlySalary); //THE NAME IS RANDOMLY GENERATED SUCH AS: Cashier660, THAT'S THE NAME
                shop.addEmployeeToStore(cashier);
                shop.addCashierToSet(cashier);
            }
        }
    }

    private void handleExceedingEmployees() throws EmployeesExceedShopLimit {
        try {
            throw new EmployeesExceedShopLimit("The amount of employees exceeds the maximum checkouts");
        } catch (EmployeesExceedShopLimit e) {
            throw new RuntimeException(e);
        }
    }

    public void productMarking(Shop shop, Cashiers cashiers, Customer customer) {           //customers
        Map<String, Integer> shoppingList = customer.getShoppingList();
        for (Map.Entry<String, Integer> entry : shoppingList.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            boolean itemExists = checkIfItemExists(shop, itemName, quantity);
            if (!itemExists) {
                System.out.println("Sorry, we don't have enough " + itemName + " in stock for your purchase.");
            }
        }
    }

    private boolean checkIfItemExists(Shop shop, String itemName, int quantity) {
        for (Goods goods : shop.getStoreGoods()) {
            if (goods.getName().equals(itemName) && goods.getQuantity() >= quantity) {
                goods.setMarked(true);
                return true;
            }
        }
        return false;
    }


}
