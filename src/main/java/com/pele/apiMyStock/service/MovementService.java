package com.pele.apiMyStock.service;

import com.pele.apiMyStock.entity.movement.Movement;
import com.pele.apiMyStock.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementService {
    private final MovementRepository movementRepository;

    public List<Movement> movementsOfProducts(){
         List<Movement> movementList=this.movementRepository.findAll();
         return (movementList);
    }


}
