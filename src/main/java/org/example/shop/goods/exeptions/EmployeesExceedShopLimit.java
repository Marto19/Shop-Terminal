package org.example.shop.goods.exeptions;

public class EmployeesExceedShopLimit extends Throwable {
    public EmployeesExceedShopLimit(String s) {
        super(s);
    }
}
