package com.example.bookingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingEventPublisher {

    private static final String TOPIC = "booking-topic";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendBookingEvent(String message) {
        kafkaTemplate.send(TOPIC, message);
    }

}
