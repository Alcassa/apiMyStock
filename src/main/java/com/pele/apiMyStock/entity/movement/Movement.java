package com.pele.apiMyStock.entity.movement;

import com.pele.apiMyStock.entity.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "tb_Movement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Movement")
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "Type")
    private String type;

    @Column(name = "Data",nullable = true)
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "id_prod")
    private Product product;
}

