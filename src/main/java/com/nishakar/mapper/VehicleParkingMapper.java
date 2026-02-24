package com.nishakar.mapper;

import com.nishakar.entity.Vehicle;
import com.nishakar.records.VehicleParkingResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface VehicleParkingMapper {

    VehicleParkingResponse vehicleToVehicleParkingResponse(Vehicle vehicle);

    List<VehicleParkingResponse> vehiclesToVehicleParkingResponseList(List<Vehicle> vehicles);

}
