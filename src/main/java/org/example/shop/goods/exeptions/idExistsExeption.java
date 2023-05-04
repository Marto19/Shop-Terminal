package org.example.shop.goods.exeptions;

public class idExistsExeption extends Throwable {
    public idExistsExeption(String idAlreadyExists) {
        super(idAlreadyExists);
    }
}
