package com.api.parkingcontrol.services;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpot;
import com.api.parkingcontrol.models.Vehicle;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.repositories.VehicleRepository;
import com.api.parkingcontrol.services.exceptions.DatabaseException;
import com.api.parkingcontrol.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    ParkingSpotRepository repository;
    @Autowired
    VehicleRepository vehicleRepository;


    @Override
    @Transactional
    public ParkingSpotDto created(ParkingSpotDto dto) {
        try {
            ParkingSpot parkingSpot = new ParkingSpot();
            copyDtoToEntity(dto, parkingSpot);
            parkingSpot.setRegistrationDate(LocalDateTime.now());
            Vehicle vehicle = vehicleRepository.getReferenceById(dto.getVehicle().getId());
            parkingSpot.setVehicle(vehicle);
            parkingSpot = repository.save(parkingSpot);
            return new ParkingSpotDto(parkingSpot);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(" vehicle id not registered or already in use.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ParkingSpotDto> findAll(Pageable pageable) {
        Page<ParkingSpot> parkingList =repository.findAll(pageable);
        return parkingList.map(ParkingSpotDto::new);
    }

    @Override
    @Transactional(readOnly = true)
    public ParkingSpotDto findById(Long id) {
        ParkingSpot entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(" Id not found !"));
        return new ParkingSpotDto(entity);
    }

    @Override
    @Transactional
    public ParkingSpotDto update(Long id, ParkingSpotDto dto) {
        try {
            ParkingSpot parkingSpot = repository.getReferenceById(id);
            copyDtoToEntity(dto, parkingSpot);
            parkingSpot.setUpdateDate(LocalDateTime.now());
            parkingSpot = repository.save(parkingSpot);
            return new ParkingSpotDto(parkingSpot);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found !");
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void  delete(Long id) {
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found !");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("Referential integrity failure !");
        }
    }

    private void copyDtoToEntity(ParkingSpotDto dto, ParkingSpot parkingSpot){
        parkingSpot.setParkingSpotNumber(dto.getParkingSpotNumber());
        parkingSpot.setResponsibleName(dto.getResponsibleName());
        parkingSpot.setApartment(dto.getApartment());
        parkingSpot.setBlock(dto.getBlock());
    }
}
