package com.hotel.service;

import com.hotel.entity.Guest;
import com.hotel.entity.Reservation;
import com.hotel.entity.Room;
import com.hotel.model.RoomReservation;
import com.hotel.repositories.GuestRepository;
import com.hotel.repositories.ReservationRepository;
import com.hotel.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {
//    @Autowired
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(GuestRepository guestRepository, RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<Guest> getAllGuest() {
        return guestRepository.findAll();

    }

    public Guest addGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }

    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();
//        this.roomRepository.findAll().forEach(rooms::add);
        for(Room room : roomRepository.findAll()) {
            rooms.add(room);
        }
        return rooms;
    }

    public List<RoomReservation> getReservationForDate(Date date) {
        List<RoomReservation> roomReservations = new ArrayList<>();
        Iterable<Room> rooms = this.roomRepository.findAll();
        for(Room room : rooms) {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservation.setRoomName(room.getName());

            Iterable<Reservation> reservations = this.reservationRepository
                    .findReservationByRoomIdAndReservationDate(room.getRoomId(), new java.sql.Date(date.getTime()));

        }
        return roomReservations;
    }
}
