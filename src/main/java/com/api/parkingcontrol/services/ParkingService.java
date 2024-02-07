package com.api.parkingcontrol.services;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.dtos.ReportDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ParkingService {
    ParkingSpotDto created(ParkingSpotDto dto);
    Page<ParkingSpotDto> findAll(Pageable pageable);
    Page<ReportDTO> searchByLicensePlateCar(String licensePlateCar, Pageable pageable);
    ParkingSpotDto findById(Long id);
    ParkingSpotDto update(Long id, ParkingSpotDto dto);
    void delete(Long id);
}
