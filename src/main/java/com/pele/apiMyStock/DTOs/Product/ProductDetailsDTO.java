package com.pele.apiMyStock.DTOs.Product;

import com.pele.apiMyStock.entity.movement.Movement;

public record ProductDetailsDTO(Long id, String  name, Integer quantity, Movement movement) {
}
