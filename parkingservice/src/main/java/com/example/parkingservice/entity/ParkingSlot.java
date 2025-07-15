package com.example.parkingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String slotNo;
    boolean isOccupied;

    String vehicleNumber;

    public Long getId() {
        return id;
    }

    public String getSlotNo() {
        return slotNo;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setSlotNo(String slotNo) {
        this.slotNo = slotNo;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

}
