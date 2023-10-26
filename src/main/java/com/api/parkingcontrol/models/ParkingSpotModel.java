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
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false,unique = true,length = 10)
    private String parkingSpotNumber;
    @Column(nullable = false,length = 130)
    private String responsibleName;
    @Column(nullable = false,length = 10)
    private String apartment;
    @Column(nullable = false,length = 10)
    private String block;
    @Column(nullable = false)
    private LocalDateTime registrationDate;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "car_id")
   private CarModel vehicle;
}
