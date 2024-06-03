package com.hotel.controller;

import com.hotel.entity.Guest;
import com.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationControllerRest {
    // przykład wstrzykiwania przez konstruktor
    private final ReservationService reservationService;

    public ReservationControllerRest(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

//    @RequestMapping(method = RequestMethod.GET, name = "/guests")
//    public List<Guest> getAllGuest(){
//        return this.reservationService.getAllGuest();
//    }

    @GetMapping( "/guests")
    public List<Guest> getAllGuest(){
        return this.reservationService.getAllGuest();
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public Guest addGuest(@RequestBody Guest guest){
        return reservationService.addGuest(guest);
    }
}
