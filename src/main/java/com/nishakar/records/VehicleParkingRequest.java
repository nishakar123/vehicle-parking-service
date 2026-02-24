package com.nishakar.records;

public record VehicleParkingRequest(String name,
                                    String plateNumber,
                                    String vehicleType,
                                    String engineType,
                                    String color,
                                    Integer weight,
                                    String description,
                                    Integer parkingLotId) {
}
