package com.nishakar.service;

import com.nishakar.commons.enums.EngineType;
import com.nishakar.commons.enums.VehicleType;
import com.nishakar.entity.ParkingLot;
import com.nishakar.entity.Vehicle;
import com.nishakar.records.VehicleParkingRequest;
import com.nishakar.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    private final ParkingLotService parkingLotService;

    public Vehicle parkVehicle(VehicleParkingRequest vehicleParkingRequest) {
        log.info("VehicleService -> parkVehicle !");
        final ParkingLot parkingLot = findAllParkingLots()
                .stream()
                .filter(p -> Objects.equals(p.getId(), vehicleParkingRequest.parkingLotId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No parking lot with id " + vehicleParkingRequest.parkingLotId()));
        Vehicle vehicle = Vehicle.builder()
                .name(vehicleParkingRequest.name())
                .plateNumber(vehicleParkingRequest.plateNumber())
                .vehicleType(VehicleType.valueOf(vehicleParkingRequest.vehicleType()))
                .engineType(EngineType.valueOf(vehicleParkingRequest.engineType()))
                .color(vehicleParkingRequest.color())
                .weight(vehicleParkingRequest.weight())
                .description(vehicleParkingRequest.description())
                .parkingLot(parkingLot)
                .build();
        final Vehicle saved = vehicleRepository.save(vehicle);
        return saved.getParkingLot()
                .getVehicles()
                .stream()
                .filter(v -> Objects.equals(v.getId(), saved.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No vehicle with id " + saved.getId()));
    }

    public List<ParkingLot> findAllParkingLots(){
        log.info("VehicleService -> findAllByParkingLots");
        return parkingLotService.getParkingLots();
    }

    public List<Vehicle> findAllVehicles(){
        log.info("VehicleService -> findAllVehicles");
        return vehicleRepository.findAll();
    }

    public String deleteParkedVehicle(Integer id) {
        log.info("VehicleService -> deleteParkedVehicle");
        final Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No vehicle with id " + id));
        vehicleRepository.delete(vehicle);
        return "Vehicle has been deleted";
    }
}
