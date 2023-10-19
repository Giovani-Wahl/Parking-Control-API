package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.models.ParkingSpotModel;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    @NotBlank
    private String licensePlateCar;
    @NotBlank
    private String brandCar;
    @NotBlank
    private String modelCar;
    @NotBlank
    private String colorCar;

    private ParkingSpotModel spotModel;
}
