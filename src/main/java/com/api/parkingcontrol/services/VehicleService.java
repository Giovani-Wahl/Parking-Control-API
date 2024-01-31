package com.api.parkingcontrol.services;

import com.api.parkingcontrol.dtos.VehicleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VehicleService {
    VehicleDTO created(VehicleDTO dto);
    Page<VehicleDTO> findAll(Pageable pageable);
    VehicleDTO findById(Long id);
    VehicleDTO update(Long id, VehicleDTO dto);
    void delete(Long id);
}
