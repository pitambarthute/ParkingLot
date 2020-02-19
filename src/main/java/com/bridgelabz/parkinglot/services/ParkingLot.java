package com.bridgelabz.parkinglot.services;

import com.bridgelabz.parkinglot.notifier.ParkingLotOwner;
import com.bridgelabz.parkinglot.notifier.ParkingLotStatus;

import java.util.Map;

public class ParkingLot {

    private ParkingSystem parkingLotRepository;
    private ParkingLotStatus parkingLotStatus;
    public static Integer totalSize, noOfLots;

    public ParkingLot(Integer totalSize, Integer noOfLots) {
        this.totalSize = totalSize;
        this.noOfLots = noOfLots;
        parkingLotRepository = new ParkingSystem(totalSize, noOfLots);
        parkingLotStatus = new ParkingLotStatus(parkingLotRepository.parkedCars);
    }

    public boolean getVehicleParked(ParkingVehicle parkedVehicle) {
        boolean parkingStatus = parkingLotRepository.getVehicleParked(parkedVehicle);
        parkingLotStatus.parkingLotStatus();
        return parkingStatus;
    }

    public boolean getVehicleUnparked(ParkingVehicle unparkVehicle) {
        this.getParkedTime(unparkVehicle);
        boolean unparkingStatus = parkingLotRepository.getVehicleUnparked(unparkVehicle);
        parkingLotStatus.parkingLotStatus();
        return unparkingStatus;
    }

    public Integer findVehicle(ParkingVehicle parkedVehicle) {
        return parkingLotRepository.isCarParked(parkedVehicle);
    }

    private void getParkedTime(ParkingVehicle unparkedVehicle) {
        String parkingTime = parkingLotRepository.getParkingTime(unparkedVehicle);
        new ParkingLotOwner().setVehicleParkingTime(parkingTime);
    }

    public Map<Integer, ParkingVehicle> findVehicleByAttribute(String... attribute) {
        return parkingLotRepository.findVehicle(attribute);
    }
}