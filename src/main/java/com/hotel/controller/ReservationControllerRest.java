package com.hotel.controller;

import com.hotel.entity.Guest;
import com.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationControllerRest {
    @Autowired
    private ReservationService reservationService;

//    @RequestMapping(method = RequestMethod.GET, name = "/guests")
//    public List<Guest> getAllGuest(){
//        return this.reservationService.getAllGuest();
//    }

    @GetMapping( "/guests")
    public List<Guest> getAllGuest(){
        return this.reservationService.getAllGuest();
    }
}
