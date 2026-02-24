package com.nishakar.records;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nishakar.entity.Vehicle;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ParkingLotResponse(Integer id,
                                 String parkingLotName,
                                 List<Vehicle> vehicles,
                                 String parkingLotDescription) {
}
