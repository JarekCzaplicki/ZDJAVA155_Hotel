package com.hotel.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;
    @Column(name = "room_id")
    private Long roomId;
    @Column(name = "guest_id")
    private Long guestId;
    @Column(name = "reservation_date")
    private Date reservationDate;

}
