package org.example.shop.goods;

import org.example.shop.goods.exeptions.EmployeesExceedShopLimit;

import java.math.BigDecimal;
import java.util.Random;
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
                BigDecimal monthlySalary = BigDecimal.valueOf(random.nextInt(5000) + 2000);

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

}
