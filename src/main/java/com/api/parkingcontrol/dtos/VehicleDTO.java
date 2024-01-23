package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.models.Vehicle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VehicleDTO {
    private Long id;
    @NotBlank(message = "Required field. ")
    @Size(max = 7)
    private String licensePlateCar;
    @NotBlank(message = "Required field. ")
    private String brandCar;
    @NotBlank(message = "Required field. ")
    private String modelCar;
    @NotBlank(message = "Required field. ")
    private String colorCar;

    public VehicleDTO() {
    }

    public VehicleDTO(Long id, String licensePlateCar, String brandCar, String modelCar, String colorCar) {
        this.id = id;
        this.licensePlateCar = licensePlateCar;
        this.brandCar = brandCar;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
    }
    public VehicleDTO(Vehicle entity) {
        id = entity.getId();
        licensePlateCar = entity.getLicensePlateCar();
        brandCar = entity.getBrandCar();
        modelCar = entity.getModelCar();
        colorCar = entity.getColorCar();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }
    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getBrandCar() {
        return brandCar;
    }
    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }
    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }
    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }
}
