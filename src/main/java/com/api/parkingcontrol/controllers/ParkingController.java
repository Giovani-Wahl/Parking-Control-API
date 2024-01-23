package com.api.parkingcontrol.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking-spot")
public class ParkingController {
    @PostMapping
    public ResponseEntity<?> created(){
        return null;
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return null;
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id){
        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return null;
    }
}
