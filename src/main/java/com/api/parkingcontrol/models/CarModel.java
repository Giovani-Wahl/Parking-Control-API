package com.api.parkingcontrol.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CAR")
public class CarModel implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;
    @Column(nullable = false, length = 50)
    private String brandCar;
    @Column(nullable = false, length = 50)
    private String modelCar;
    @Column(nullable = false, length = 50)
    private String colorCar;
    @Column(nullable = false)
    private LocalDateTime registrationDate;
}
