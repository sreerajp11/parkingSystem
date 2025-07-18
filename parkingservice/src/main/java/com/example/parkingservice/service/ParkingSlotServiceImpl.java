package com.example.parkingservice.service;

import com.example.parkingservice.client.UserClient;
import com.example.parkingservice.dto.UserDTO;
import com.example.parkingservice.entity.ParkingSlot;
import com.example.parkingservice.repository.ParkingSlotServiceRepository;
import com.example.parkingservice.service.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

    @Autowired
    private ParkingSlotServiceRepository repo;

    @Autowired
    private UserClient client;

    @Override
    public List<ParkingSlot> getAllSlots() {
        return repo.findAll();
    }

    @Override
    public ParkingSlot addSlot(ParkingSlot slot) {
        return repo.save(slot);
    }

    @Override
    public ParkingSlot getSlotById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Slot not found with id: " + id));
    }

    @Override
    public ParkingSlot updateSlot(Long id, ParkingSlot slot) {
        ParkingSlot existingSlots = getSlotById(id);
        existingSlots.setSlotNo(slot.getSlotNo());
        existingSlots.setOccupied(slot.isOccupied());
        existingSlots.setVehicleNumber(slot.getVehicleNumber());
        return existingSlots;
    }

    @Override
    public List<ParkingSlot> getAvailableSlots() {
        return null;
    }

    @Override
    public void deleteSlot(Long id) {
        repo.deleteById(id);
    }

    @Override
    public ParkingSlot occupySlot(Long id, String vehicleNumber) {
        ParkingSlot slot = getSlotById(id);
        UserDTO user = client.getUserById(id);
        Logger logger = Logger.getLogger(getClass().getName());
        logger.info("Slot occupied by: "+ user.getName()+ "with vehicle number: " + vehicleNumber);

        slot.setOccupied(true);
        slot.setVehicleNumber(vehicleNumber);
        return repo.save(slot);
    }

    @Override
    public ParkingSlot vacateSlot(Long id) {
        ParkingSlot slot = getSlotById(id);
        slot.setOccupied(false);
        slot.setVehicleNumber(null);
        return repo.save(slot);
    }
}
