package com.pele.apiMyStock.entity.product.exceptions;

public class ProductQuantityNotPermitted extends RuntimeException {
    public ProductQuantityNotPermitted(String message){
        super(message);
    }
}
