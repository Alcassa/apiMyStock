package com.pele.apiMyStock.controllers;

import com.pele.apiMyStock.entity.product.exceptions.ProductIdException;
import com.pele.apiMyStock.entity.product.exceptions.ProductQuantityException;
import com.pele.apiMyStock.entity.product.exceptions.ProductQuantityNotPermitted;
import com.pele.apiMyStock.entity.product.exceptions.ProductZeroQuantity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductIdException.class)
    private ResponseEntity<String> productNotFoundHandler(ProductIdException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
    }
    @ExceptionHandler(ProductQuantityException.class)
    private ResponseEntity<String> quantityNotSupportedHandler(ProductQuantityException exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Produto fora de estoque");
    }
    @ExceptionHandler(ProductQuantityNotPermitted.class)
    private ResponseEntity<String> quantityNotSupportedHandler(ProductQuantityNotPermitted exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("a quantidade solicitada é maior que a quantidade em estoque");
    }
    @ExceptionHandler(ProductZeroQuantity.class)
    private ResponseEntity<String> quantityNotSupportedHandler(ProductZeroQuantity exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não é possivel adicionar/retirar 0 ");
    }

}
