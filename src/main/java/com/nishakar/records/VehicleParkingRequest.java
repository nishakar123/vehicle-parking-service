package com.nishakar.records;

public record VehicleParkingRequest(Integer id,
                                    String name,
                                    String plateNumber,
                                    String vehicleType,
                                    String engineType,
                                    String color,
                                    Integer weight,
                                    String description,
                                    Integer parkingLotId) {
}
