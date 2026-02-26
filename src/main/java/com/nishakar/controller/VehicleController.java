package com.nishakar.controller;

import com.nishakar.mapper.VehicleParkingMapper;
import com.nishakar.records.VehicleParkingRequest;
import com.nishakar.records.VehicleParkingResponse;
import com.nishakar.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vehicle-parking-service")
public class VehicleController {

    private final VehicleService vehicleService;

    private final VehicleParkingMapper vehicleParkingMapper;

    @PostMapping("/park/vehicle")
    public VehicleParkingResponse parkVehicle(@RequestBody VehicleParkingRequest vehicleParkingRequest) {
        log.info("VehicleController -> parkVehicle !");
        return vehicleParkingMapper.vehicleToVehicleParkingResponse(vehicleService.parkVehicle(vehicleParkingRequest));
    }

    @GetMapping("/parked/vehicles")
    public List<VehicleParkingResponse> findAllVehicleParked(){
        log.info("VehicleController -> findAllVehicleParked");
        return vehicleParkingMapper.vehiclesToVehicleParkingResponseList(vehicleService.findAllVehicles());
    }

    @DeleteMapping("/delete/vehicle/{id}")
    public void deleteVehicleParked(@PathVariable Integer id) {
        log.info("VehicleController -> deleteVehicleParked !");
        vehicleService.deleteParkedVehicle(id);
    }

}
