package com.pele.apiMyStock.entity.product.exceptions;

public class ProductQuantityException extends RuntimeException{
    public ProductQuantityException(String message){
        super(message);
    }
}
