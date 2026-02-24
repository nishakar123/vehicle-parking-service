package com.nishakar.mapper;

import com.nishakar.entity.ParkingLot;
import com.nishakar.records.ParkingLotResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ParkingLotMapper {

    ParkingLotResponse toParkingLotResponse(ParkingLot parkingLot);

    List<ParkingLotResponse>  toParkingLotListResponse(List<ParkingLot> vehicles);
}
