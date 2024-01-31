package com.api.parkingcontrol.services;

import com.api.parkingcontrol.dtos.VehicleDTO;
import com.api.parkingcontrol.models.Vehicle;
import com.api.parkingcontrol.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public class VehicleServiceImpl implements VehicleService{
    @Autowired
    VehicleRepository repository;

    @Override
    public VehicleDTO created(VehicleDTO dto) {
        return null;
    }

    @Override
    public Page<VehicleDTO> findAll(Pageable pageable) {
        Page<Vehicle> vehicles = repository.findAll(pageable);
        return vehicles.map(VehicleDTO::new);
    }

    @Override
    public VehicleDTO findById(Long id) {
        Vehicle entity = repository.findById(id).orElseThrow();
        return new VehicleDTO(entity);
    }

    @Override
    public VehicleDTO update(Long id, VehicleDTO dto) {
        Vehicle entity = repository.getReferenceById(id);
        copyDtoToEntity(dto,entity);
        entity.setUpdateDate(LocalDateTime.now());
        entity = repository.save(entity);
        return new VehicleDTO(entity);
    }

    @Override
    public void delete(Long id) {

    }

    private void copyDtoToEntity(VehicleDTO dto, Vehicle entity) {
        entity.setLicensePlateCar(dto.getLicensePlateCar());
        entity.setBrandCar(dto.getBrandCar());
        entity.setModelCar(dto.getModelCar());
        entity.setModelCar(dto.getModelCar());
    }
}