package com.pele.apiMyStock.controllers;

import com.pele.apiMyStock.entity.movement.Movement;
import com.pele.apiMyStock.service.MovementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movement")
@AllArgsConstructor
public class MovementController {
    MovementService movementService;
    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Movement>> getMovement(){
        List<Movement>movementList=this.movementService.movementsOfProducts();
        return ResponseEntity.status(HttpStatus.OK).body(movementList);
    }
}
