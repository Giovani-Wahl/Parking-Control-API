package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.models.ParkingSpot;

public class ReportDTO {
    private String responsibleName;
    private String parkingSpotNumber;
    private String licensePlateCar;

    public ReportDTO(String responsibleName, String parkingSpotNumber, String licensePlateCar) {
        this.responsibleName = responsibleName;
        this.parkingSpotNumber = parkingSpotNumber;
        this.licensePlateCar = licensePlateCar;
    }
    public ReportDTO(ParkingSpot entity) {
        responsibleName = entity.getResponsibleName();
        parkingSpotNumber = entity.getParkingSpotNumber();
        licensePlateCar = entity.getVehicle().getLicensePlateCar();
    }

    public String getResponsibleName() {
        return responsibleName;
    }
    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }
    public String getLicensePlateCar() {
        return licensePlateCar;
    }
}
