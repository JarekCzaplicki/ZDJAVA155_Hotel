package com.hotel.controller;

import com.hotel.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guests")
public class GuestControllerWeb {
    private final ReservationService reservationService;

    public GuestControllerWeb(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String guests(Model model) {
        model.addAttribute("guests",
                this.reservationService.getHotelGuests());
        return "hotel-guests";
    }
}
