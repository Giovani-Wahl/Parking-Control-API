package com.api.parkingcontrol.services;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ParkingService {
    ParkingSpotDto created(ParkingSpotDto dto);
    Page<ParkingSpotDto> findAll(Pageable pageable);
    ParkingSpotDto findById(Long id);
}