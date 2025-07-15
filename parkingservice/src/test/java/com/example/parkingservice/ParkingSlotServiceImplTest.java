package com.example.parkingservice;

import com.example.parkingservice.entity.ParkingSlot;
import com.example.parkingservice.repository.ParkingSlotServiceRepository;
import com.example.parkingservice.service.ParkingSlotServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParkingSlotServiceImplTest {
    private final ParkingSlotServiceImpl parkingSlotService = new ParkingSlotServiceImpl();
    private ParkingSlotServiceRepository repo = mock(ParkingSlotServiceRepository.class);

    @Test
    void testGetAllSlots() {

        ParkingSlot slot1 = new ParkingSlot();
        ParkingSlot slot2 = new ParkingSlot();
        slot1.setOccupied(false);
        slot1.setSlotNo("A1");
        slot1.setOccupied(true);
        slot1.setSlotNo("B1");
        List<ParkingSlot> slots = List.of(slot1, slot2);
        MockitoAnnotations.openMocks(this);
        when(repo.findAll()).thenReturn(slots);
//        when(parkingSlotService.getAllSlots()).thenCallRealMethod();
        List<ParkingSlot> expected = parkingSlotService.getAllSlots();
        assertEquals(2, slots.size());
    }
}