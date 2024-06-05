package com.hotel.controller;

import com.hotel.entity.Guest;
import com.hotel.entity.Room;
import com.hotel.model.RoomReservation;
import com.hotel.service.ReservationService;
import com.hotel.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationControllerRest {
    // przykład wstrzykiwania przez konstruktor
    private final ReservationService reservationService;
    private final DateUtil dateUtil;

    public ReservationControllerRest(ReservationService reservationService
            , DateUtil dateUtil) {
        this.reservationService = reservationService;
        this.dateUtil = dateUtil;
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

    @DeleteMapping("/guests/{identifier}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGuest(@PathVariable(name = "identifier") Long id){
        this.reservationService.deleteGuest(id);
    }

    @GetMapping("/rooms")
    public List<Room> getRooms(){
        return this.reservationService.getRooms();
    }
    @GetMapping("/reservations")
    public List<RoomReservation> getReservation(@RequestParam(value = "date", required = false) String stringDate){
//        DateUtil dateUtil = new DateUtil();
        Date date = dateUtil.createDateFromString(stringDate);
        return this.reservationService.getReservationForDate(date);
    }
}
