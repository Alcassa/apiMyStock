package com.pele.apiMyStock.DTOs.Product;

import java.time.LocalDateTime;

public record ProductAddingDTO(Long id, String name, String type, Integer quantity, LocalDateTime data) {
}
