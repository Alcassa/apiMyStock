package com.pele.apiMyStock.DTOs.Product;

import java.time.LocalDateTime;

public record ProductWithDrawDTO(Long id, String name, String type, Integer quantity, LocalDateTime data) {
}
