package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.CarModel;
import com.api.parkingcontrol.repositories.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    @Transactional
    public CarModel save(CarModel carModel){
        return carRepository.save(carModel);
    }
    @Transactional
   public void delete(CarModel carModel){
        carRepository.delete(carModel);
   }
   public Page<CarModel> findAll(Pageable pageable){
        return carRepository.findAll(pageable);
   }
   public Optional<CarModel> findById(UUID id){
        return carRepository.findById(id);
   }
}
