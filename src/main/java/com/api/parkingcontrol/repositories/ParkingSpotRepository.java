package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.dtos.ReportDTO;
import com.api.parkingcontrol.models.ParkingSpot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {

    @Query("SELECT  new com.api.parkingcontrol.dtos.ReportDTO(obj.responsibleName," +
            "obj.parkingSpotNumber, obj.vehicle.licensePlateCar) " +
            "FROM ParkingSpot obj " +
            "WHERE UPPER(obj.vehicle.licensePlateCar) LIKE UPPER(CONCAT('%',:licensePlateCar,'%'))")
    Page<ReportDTO> searchByLicensePlateCar(String licensePlateCar, Pageable pageable);
}
