package com.pele.apiMyStock.controllers;


import com.pele.apiMyStock.DTOs.Product.*;
import com.pele.apiMyStock.entity.product.Product;
import com.pele.apiMyStock.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Product>> getProduct(){
        List<Product> productList=this.productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }
    @GetMapping(value ="/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ProductNameDTO> getByIdProduct(@PathVariable Long id){
        ProductNameDTO productDetailsDTO=this.productService.getProductIdDetail(id);
        return ResponseEntity.ok(productDetailsDTO);
    }
    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ProductIdDTO> createProduct(@RequestBody ProductRequestDTO body){
        ProductIdDTO product=this.productService.createProduct(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @PutMapping(value = "/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ProductAddingDTO> addingProduct(@RequestBody ProductMovementDTO body){
        ProductAddingDTO dto=this.productService.addingProduct(body);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PutMapping(value = "/withdraw")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ProductWithDrawDTO> removeProduct(@RequestBody ProductMovementDTO body){
        ProductWithDrawDTO dto =this.productService.withdrawProduct(body);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
