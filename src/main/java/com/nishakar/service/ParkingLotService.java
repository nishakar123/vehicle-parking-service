package com.nishakar.service;

import com.nishakar.entity.ParkingLot;
import com.nishakar.records.ParkingLotRequests;
import com.nishakar.repository.ParkingLotRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;

    public ParkingLot createParkingLot(ParkingLotRequests parkingLotRequests){
        log.info("ParkingLotService -> createParkingLot !");
        ParkingLot parkingLot = ParkingLot.builder()
                .parkingLotName(parkingLotRequests.parkingLotName())
                .parkingLotDescription(parkingLotRequests.parkingLotDescription())
                .build();
        return parkingLotRepository.save(parkingLot);
    }

    public List<ParkingLot> getParkingLots(){
        log.info("ParkingLotService -> getParkingLots !");
        return (List<ParkingLot>) parkingLotRepository.findAll();
    }

    public ParkingLot getParkingLotById(Integer id){
        log.info("ParkingLotService -> getParkingLotById !");
        return parkingLotRepository.findById(id).orElseThrow(() -> new NotFoundException("Parking Lot not found with id : " + id));
    }

    public Integer deleteParkingLot(Integer parkingLotId){
        log.info("ParkingLotService -> deleteParkingLot !");
        final Optional<ParkingLot> byId = parkingLotRepository.findById(parkingLotId);
        byId.ifPresentOrElse(parkingLotRepository::delete,
                () -> {throw new IllegalArgumentException("Parking Lot Id is invalid!");});
        return parkingLotId;
    }
}
