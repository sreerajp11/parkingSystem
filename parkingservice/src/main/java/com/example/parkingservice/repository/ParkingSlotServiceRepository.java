package com.example.parkingservice.repository;

import com.example.parkingservice.entity.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSlotServiceRepository extends JpaRepository<ParkingSlot, Long> {
List<ParkingSlot> findByIsOccupiedFalse();
}
