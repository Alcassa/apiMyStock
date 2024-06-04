package com.pele.apiMyStock.entity.product.exceptions;

public class ProductZeroQuantity extends RuntimeException{
   public ProductZeroQuantity(String message){
       super(message);
   }

}
