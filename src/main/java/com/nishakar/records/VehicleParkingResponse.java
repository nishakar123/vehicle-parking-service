package com.nishakar.records;

import com.nishakar.commons.enums.EngineType;
import com.nishakar.commons.enums.VehicleType;
import com.nishakar.entity.ParkingLot;

public record VehicleParkingResponse(Integer id,
                                     String name,
                                     String plateNumber,
                                     VehicleType vehicleType,
                                     EngineType engineType,
                                     String color,
                                     Integer weight,
                                     String description,
                                     ParkingLot parkingLot) {
}
