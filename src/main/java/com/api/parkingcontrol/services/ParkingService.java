package com.api.parkingcontrol.services;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ParkingService {
    ResponseEntity<ParkingSpotDto> created(ParkingSpotDto dto);
    Page<ParkingSpotDto> findAll(Pageable pageable);
    ParkingSpotDto findById(Long id);
}
