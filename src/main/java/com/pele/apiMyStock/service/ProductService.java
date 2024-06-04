package com.pele.apiMyStock.service;

import com.pele.apiMyStock.DTOs.Product.*;

import com.pele.apiMyStock.entity.movement.Movement;
import com.pele.apiMyStock.entity.product.Product;
import com.pele.apiMyStock.entity.product.exceptions.ProductIdException;
import com.pele.apiMyStock.entity.product.exceptions.ProductQuantityException;
import com.pele.apiMyStock.entity.product.exceptions.ProductQuantityNotPermitted;
import com.pele.apiMyStock.entity.product.exceptions.ProductZeroQuantity;
import com.pele.apiMyStock.repository.MovementRepository;
import com.pele.apiMyStock.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final MovementRepository movementRepository;
    private MovementService movementService;

    public List<Product> getProducts(){
        List<Product> productList=this.productRepository.findAll();
        return productList;
    }

    public ProductNameDTO getProductIdDetail(Long id){
        Product product=this.getProductByID(id);
        return new ProductNameDTO(product.getId(),product.getName());
    }

    public ProductIdDTO createProduct(ProductRequestDTO body){
        Product newProduct=new Product();
        newProduct.setName(body.name());
        newProduct.setQuantity(body.quantity());

        this.productRepository.save(newProduct);
        return new ProductIdDTO(newProduct.getId());
    }

    public ProductAddingDTO addingProduct(ProductMovementDTO body){
        Product product=this.getProductByID(body.id());

        if(body.quantity()<=0){
             throw new ProductZeroQuantity("Quantity is not permitted");
         }

        if(product.getQuantity() != null){
            Integer totalQuantity= product.getQuantity() + body.quantity();
            product.setQuantity(totalQuantity);

        }else{
            product.setQuantity(body.quantity());
        }
        Movement mov=new Movement();
        mov.setQuantity(body.quantity());
        mov.setType("Adicionou");
        mov.setData(LocalDateTime.now());
        mov.setProduct(product);
        this.productRepository.save(product);
        this.movementRepository.save(mov);
        return new ProductAddingDTO(product.getId(), product.getName(),
                mov.getType(), mov.getQuantity(), mov.getData());
    }
    public ProductWithDrawDTO withdrawProduct(ProductMovementDTO body){
        Product product=this.getProductByID(body.id());
        Movement mov=new Movement();
        if(product.getQuantity() == null){
            throw new ProductQuantityException( "Product out of stock");
        }
        if (product.getQuantity() < body.quantity()){
            throw new ProductQuantityNotPermitted("the requested quantity is greater than the stock quantity");
        }
        if(body.quantity()<=0){
            throw new ProductZeroQuantity("Unable to add/remove  0");
        }
        Integer totalQuantity= product.getQuantity() - body.quantity();
        mov.setQuantity(body.quantity());
        mov.setData(LocalDateTime.now());
        mov.setProduct(product);
        mov.setType("Retirou");
        this.movementRepository.save(mov);
        product.setQuantity(totalQuantity);
        this.productRepository.save(product);
        return new ProductWithDrawDTO(product.getId(), product.getName(),
                mov.getType(), mov.getQuantity(), mov.getData());
    }

    private Product getProductByID(Long id){
        Product product=this.productRepository.findById(id)
                .orElseThrow(()->new ProductIdException("ID not Found "+id));
        return product;
    }
}
