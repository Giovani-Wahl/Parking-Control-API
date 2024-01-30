package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.models.ParkingSpot;
import jakarta.validation.constraints.NotBlank;


public class ParkingSpotDto {
    private Long id;
    @NotBlank(message = "Required field. ")
    private String parkingSpotNumber;
    @NotBlank(message = "Required field. ")
    private String responsibleName;
    @NotBlank(message = "Required field. ")
    private String apartment;
    @NotBlank(message = "Required field. ")
    private String block;
    private VehicleDTO vehicle;

    public ParkingSpotDto() {
    }

    public ParkingSpotDto(Long id, String parkingSpotNumber, String responsibleName, String apartment, String block, VehicleDTO vehicle) {
        this.id = id;
        this.parkingSpotNumber = parkingSpotNumber;
        this.responsibleName = responsibleName;
        this.apartment = apartment;
        this.block = block;
        this.vehicle = vehicle;
    }
    public ParkingSpotDto(ParkingSpot entity) {
        id = entity.getId();
        parkingSpotNumber = entity.getParkingSpotNumber();
        responsibleName = entity.getResponsibleName();
        apartment = entity.getApartment();
        block = entity.getBlock();
        vehicle = new VehicleDTO(entity.getVehicle());
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }
    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public String getResponsibleName() {
        return responsibleName;
    }
    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartment() {
        return apartment;
    }
    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }
    public void setBlock(String block) {
        this.block = block;
    }

    public VehicleDTO getVehicle() {return vehicle;}
    public void setVehicle(VehicleDTO vehicle) {this.vehicle = vehicle;}
}
