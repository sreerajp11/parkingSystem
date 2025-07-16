package com.example.bookingservice.client;

import com.example.bookingservice.dto.ParkingSlotDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "parking-service")
public interface ParkingSlotClient {

    @GetMapping("/parking-slots/{id}")
    ParkingSlotDTO getParkingSlotById(@PathVariable Long slotId);
}
