package com.example.bookingservice.dto;

public class ParkingSlotDTO {
    private Long id;
    private String slotNo;
    private boolean isOccupied;


    public Long getId() {
        return id;
    }

    //These fields must match fields of ParkingSlot fields. If PakringService returns a different one,
    // use for eg @JsonProperty("slotNumber")
    public String getSlotNo() {
        return slotNo;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
