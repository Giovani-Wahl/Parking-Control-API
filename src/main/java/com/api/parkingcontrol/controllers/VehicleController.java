package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.dtos.VehicleDTO;
import com.api.parkingcontrol.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleService service;

    @PostMapping
    public ResponseEntity<VehicleDTO> created(@Valid @RequestBody VehicleDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.created(dto));
    }
    @GetMapping
    public ResponseEntity<Page<VehicleDTO>> findAll(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> update(@PathVariable Long id, @Valid @RequestBody VehicleDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id,dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
