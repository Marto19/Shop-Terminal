package org.example.shop.goods;

import java.math.BigDecimal;

public class Cashiers {
    private String name;
    private final long id;
    private BigDecimal monthlySalary;

    public Cashiers(String name, long id, BigDecimal monthlySalary) {
        this.name = name;
        this.id = id;
        this.monthlySalary = monthlySalary;
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

}
