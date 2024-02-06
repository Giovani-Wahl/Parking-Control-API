package com.api.parkingcontrol.services;

import com.api.parkingcontrol.dtos.VehicleDTO;
import com.api.parkingcontrol.models.Vehicle;
import com.api.parkingcontrol.repositories.VehicleRepository;
import com.api.parkingcontrol.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    VehicleRepository repository;

    @Override
    @Transactional
    public VehicleDTO created(@Valid @RequestBody VehicleDTO dto) {
        Vehicle entity = new Vehicle();
        copyDtoToEntity(dto, entity);
        entity.setRegistrationDate(LocalDateTime.now());
        entity = repository.save(entity);
        return new VehicleDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<VehicleDTO> findAll(Pageable pageable) {
        Page<Vehicle> vehicles = repository.findAll(pageable);
        return vehicles.map(VehicleDTO::new);
    }

    @Override
    @Transactional(readOnly = true)
    public VehicleDTO findById(Long id) {
        Vehicle entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(" Id not found !"));
        return new VehicleDTO(entity);
    }

    @Override
    @Transactional
    public VehicleDTO update(Long id, VehicleDTO dto) {
        try {
            Vehicle entity = repository.getReferenceById(id);
            copyDtoToEntity(dto,entity);
            entity.setUpdateDate(LocalDateTime.now());
            entity = repository.save(entity);
            return new VehicleDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found !");
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found !");
        }
        repository.deleteById(id);
    }

    private void copyDtoToEntity(VehicleDTO dto, Vehicle entity) {
        entity.setLicensePlateCar(dto.getLicensePlateCar());
        entity.setBrandCar(dto.getBrandCar());
        entity.setModelCar(dto.getModelCar());
        entity.setColorCar(dto.getColorCar());
    }
}
