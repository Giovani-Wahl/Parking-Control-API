package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.services.ParkingService;
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
@RequestMapping("/parking-spot")
public class ParkingController {
    @Autowired
    ParkingService service;

    @PostMapping
    public ResponseEntity<ParkingSpotDto> created(@Valid @RequestBody ParkingSpotDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.created(dto));
    }
    @GetMapping
    public ResponseEntity<Page<ParkingSpotDto>> findAll(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpotDto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpotDto> update(@PathVariable Long id, @Valid @RequestBody ParkingSpotDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id,dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return null;
    }
}
