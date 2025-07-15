package com.example.parkingservice.controller;

import com.example.parkingservice.entity.ParkingSlot;
import com.example.parkingservice.service.ParkingSlotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Parking Slot Controller", description = "Controller for managing parking slots")
@RequestMapping("/parking-slots")
@RestController
public class ParkingSlotController {

    @Autowired
    private ParkingSlotService parkingSlotService;

    @Operation(summary = "Get all parking slots", description = "Retrieve a list of all parking slots")
    @GetMapping()
    public ResponseEntity<List<ParkingSlot>> getAllSlots() {
        return new ResponseEntity<>(parkingSlotService.getAllSlots(), HttpStatus.OK);
    }


    @Operation(summary = "Add a new parking slot")
    @PostMapping()
    public ResponseEntity<ParkingSlot> addSlot(@Valid @RequestBody ParkingSlot slot) {
        ParkingSlot savedSlot = parkingSlotService.addSlot(slot);
        return new ResponseEntity<>(savedSlot, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get slot by ID")
    public ResponseEntity<ParkingSlot> getSlotById(@PathVariable Long id) {
        ParkingSlot slot = parkingSlotService.getSlotById(id);
        return new ResponseEntity<>(slot, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a slot")
    public ResponseEntity<ParkingSlot> updateSlot(@PathVariable Long id) {
        ParkingSlot slot = parkingSlotService.getSlotById(id);
        return new ResponseEntity<>(parkingSlotService.updateSlot(id, slot), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a slot by ID")
    public ResponseEntity<ParkingSlot> deleteSlot(@PathVariable Long id) {
        parkingSlotService.deleteSlot(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/available")
    @Operation(summary = "Get all available slots")
    public ResponseEntity<List<ParkingSlot>> getAvailableSlots() {
        return new ResponseEntity<>(parkingSlotService.getAvailableSlots(), HttpStatus.OK);
    }

    @PutMapping("/{id}/occupy")
    @Operation(summary = "Mark slot as occupied with vehicle number")
    public ResponseEntity<ParkingSlot> occupySlot(@PathVariable Long id, @RequestParam String vehicleNumber) {
        return new ResponseEntity<>(parkingSlotService.occupySlot(id, vehicleNumber), HttpStatus.OK);
    }

    @PutMapping("/{id}/vacate")
    @Operation(summary = "Vacate a slot (mark as not occupied)")
    public ResponseEntity<ParkingSlot> vacateSlot(@PathVariable Long id) {
        return new ResponseEntity<>(parkingSlotService.vacateSlot(id), HttpStatus.OK);
    }

}
