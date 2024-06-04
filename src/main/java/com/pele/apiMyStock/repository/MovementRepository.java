package com.pele.apiMyStock.repository;

import com.pele.apiMyStock.entity.movement.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement,Long> {
}
