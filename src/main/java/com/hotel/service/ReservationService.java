package com.hotel.service;

import com.hotel.entity.Guest;
import com.hotel.repositories.GuestRepository;
import com.hotel.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuest() {
        return guestRepository.findAll();

    }

    public Guest addGuest(Guest guest) {
        return guestRepository.save(guest);
    }
}
