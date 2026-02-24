package com.nishakar.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nishakar.commons.enums.EngineType;
import com.nishakar.commons.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Builder
@ToString
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String plateNumber;
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    @Enumerated(EnumType.STRING)
    private EngineType engineType;
    private String color;
    private Integer weight;
    private String description;
    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    @JsonBackReference
    private ParkingLot parkingLot;
}
