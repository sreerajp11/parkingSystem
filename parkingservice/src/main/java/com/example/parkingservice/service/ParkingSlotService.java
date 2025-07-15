package com.example.parkingservice.service;

import com.example.parkingservice.entity.ParkingSlot;

import java.util.List;

public interface ParkingSlotService {
    List<ParkingSlot> getAllSlots();

    ParkingSlot addSlot(ParkingSlot slot);

    ParkingSlot getSlotById(Long id);

    ParkingSlot updateSlot(Long id, ParkingSlot slot);

    List<ParkingSlot> getAvailableSlots();

    void deleteSlot(Long id);

    ParkingSlot occupySlot(Long id, String vehicleNumber);

    ParkingSlot vacateSlot(Long id);
}
