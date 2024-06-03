package com.hotel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;
    private String name;
    @Column(name = "room_number")
    private String roomNumber;
    @Column(name = "bed_info")
    private String bedInfo;

}
