package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
