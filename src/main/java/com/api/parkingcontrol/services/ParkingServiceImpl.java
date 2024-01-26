package com.api.parkingcontrol.services;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpot;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
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
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    ParkingSpotRepository repository;


    @Override
    @Transactional
    public ParkingSpotDto created(@Valid @RequestBody ParkingSpotDto dto) {
        ParkingSpot parkingSpot = new ParkingSpot();
        copyDtoToEntity(dto, parkingSpot);
        parkingSpot.setRegistrationDate(LocalDateTime.now());
        parkingSpot = repository.save(parkingSpot);
        return new ParkingSpotDto(parkingSpot);
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
        ParkingSpot entity = repository.findById(id).orElseThrow();
        return new ParkingSpotDto(entity);
    }

    @Override
    @Transactional
    public ParkingSpotDto update(Long id, ParkingSpotDto dto) {
        ParkingSpot parkingSpot = repository.getReferenceById(id);
        copyDtoToEntity(dto, parkingSpot);
        parkingSpot.setUpdateDate(LocalDateTime.now());
        parkingSpot = repository.save(parkingSpot);
        return new ParkingSpotDto(parkingSpot);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void  delete(Long id) {
        repository.deleteById(id);
    }

    private void copyDtoToEntity(ParkingSpotDto dto, ParkingSpot parkingSpot){
        parkingSpot.setParkingSpotNumber(dto.getParkingSpotNumber());
        parkingSpot.setResponsibleName(dto.getResponsibleName());
        parkingSpot.setApartment(dto.getApartment());
        parkingSpot.setBlock(dto.getBlock());
    }
}
