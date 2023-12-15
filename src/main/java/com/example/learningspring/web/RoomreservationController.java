package com.example.learningspring.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.learningspring.business.ReservationService;
import com.example.learningspring.business.RoomReservation;
import com.example.learningspring.util.DateUtils;

@Controller
@RequestMapping("/reservations")
public class RoomreservationController {

    private final DateUtils dateUtils;
    private final ReservationService reservationService;


    public RoomreservationController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String getReservations (@RequestParam(value = "date", required = false) String dateString, Model model){
            Date date = this.dateUtils.createDateFromDateString(dateString);
            List<RoomReservation> RoomReservations= this.reservationService.getRoomReservationForDate(date);
            model.addAttribute("roomReservations", RoomReservations);
            return "roomres";
    }


}
