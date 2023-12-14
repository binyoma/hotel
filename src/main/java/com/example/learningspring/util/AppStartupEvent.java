package com.example.learningspring.util;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.learningspring.business.ReservationService;
import com.example.learningspring.business.RoomReservation;
import com.example.learningspring.data.Guest;
import com.example.learningspring.data.GuestRepository;
import com.example.learningspring.data.Reservation;
import com.example.learningspring.data.ReservationRepository;
import com.example.learningspring.data.Room;
import com.example.learningspring.data.RoomRepository;

@Component
public class AppStartupEvent implements  ApplicationListener<ApplicationReadyEvent>{


 private final ReservationService reservationService;
 
 private final  DateUtils dateUtils;


   public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
      this.reservationService = reservationService;
      this.dateUtils = dateUtils;
   }




    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
       Date date = this.dateUtils.createDateFromDateString("2022-01-01");
       List<RoomReservation> reservations = this.reservationService.getRoomReservationForDate(date);
       reservations.forEach(System.out::println);
       
    }

}
