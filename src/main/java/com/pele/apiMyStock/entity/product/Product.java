package com.pele.apiMyStock.entity.product;

import com.pele.apiMyStock.entity.movement.Movement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Prod")
    private Long id;

    @Column(name = "name_Prod")
    private String name;
    @Column(nullable = true)
    Integer quantity;
    

}
