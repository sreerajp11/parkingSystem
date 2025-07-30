package com.example.bookingservice.service;

import com.example.bookingservice.client.ParkingSlotClient;
import com.example.bookingservice.client.UserClient;
import com.example.bookingservice.dto.ParkingSlotDTO;
import com.example.bookingservice.dto.UserDTO;
import com.example.bookingservice.exceptions.ResourceNotFoundException;
import com.example.bookingservice.model.Booking;
import com.example.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserClient userClient;

    @Autowired
    private ParkingSlotClient slotClient;


    @Override
    public Booking createBooking(Booking booking) {
        UserDTO user = userClient.getUserById(booking.getUserId());
        if (user == null) {
            throw new ResourceNotFoundException("User not found with id: " + booking.getUserId());
        }
        ParkingSlotDTO slot = slotClient.getParkingSlotById(booking.getSlotId());
        if (slot == null) {
            throw new ResourceNotFoundException("Parking slot not found with id: " + booking.getSlotId());
        }
        if (slot.isOccupied()) {
            throw new ResourceNotFoundException("Parking slot is already occupied");
        }

        return bookingRepository.save(booking);
    }

    @Cacheable(value = "bookings", key = "#id")
    @Override
    public Booking getBookingById(Long id) {
        System.out.println("Fetching booking from DB");
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}
