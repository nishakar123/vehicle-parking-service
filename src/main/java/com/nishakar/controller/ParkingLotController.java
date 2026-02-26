package com.nishakar.controller;

import com.nishakar.mapper.ParkingLotMapper;
import com.nishakar.records.ParkingLotRequests;
import com.nishakar.records.ParkingLotResponse;
import com.nishakar.service.ParkingLotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vehicle-parking-service")
public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    private final ParkingLotMapper parkingLotMapper;

    @PostMapping("/parking-lot/create")
    public ParkingLotResponse createParkingLot(ParkingLotRequests parkingLotRequests){
        log.info("ParkingLotService - createParkingLot !");
        return parkingLotMapper.toParkingLotResponse(parkingLotService.createParkingLot(parkingLotRequests));
    }

    @GetMapping("/parking-lot/find-all")
    public List<ParkingLotResponse> getParkingLots(){
        log.info("ParkingLotService - getParkingLots !");
        return parkingLotMapper.toParkingLotListResponse(parkingLotService.getParkingLots());
    }

    @GetMapping("/parking-lot/find-by-id/{lotId}")
    public ParkingLotResponse getParkingLotById(@PathVariable Integer lotId){
        log.info("ParkingLotService - getParkingLotById !");
        return parkingLotMapper.toParkingLotResponse(parkingLotService.getParkingLotById(lotId));
    }

    @DeleteMapping("/parking-lot/delete/{id}")
    public Integer deleteParkingLot(@PathVariable Integer id){
        log.info("ParkingLotService - deleteParkingLot !");
        return parkingLotService.deleteParkingLot(id);
    }
}
