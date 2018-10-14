/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import hotel.booking.BookingCTL;
import hotel.checkin.CheckinCTL;
import hotel.checkout.CheckoutCTL;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import hotel.entities.RoomType;
import hotel.entities.ServiceCharge;
import hotel.entities.ServiceType;
import hotel.service.RecordServiceCTL;
import hotel.service.RecordServiceUI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Rehman
 */
public class TestBug2 {
    
        
     @Test
      public void testBug2() { 
         
         

         BookingCTL booking = new BookingCTL(hotel);
         Hotel hotel = new Hotel();
          Guest guest ;
           Room room;
           CreditCard card;

         String name = "Rehman";
         String address = "Noble Park, Melbourne";
         int phoneNum = 0406047174;
         RoomType roomType = RoomType.SINGLE;
         int roomID = 101;
         double cost = 156.0;
         int stayLength = 2;
         int occuptantNum = 1;
         Date arrivalDate = new Date();
         CreditCardType creditType = CreditCardType.MASTERCARD;
         
          guest = new Guest(name, address, phoneNum);
          room = new Room(roomID, RoomType.SINGLE);
          card = new CreditCard(CreditCardType.MASTERCARD, 1, 1);
         
         booking.phoneNumberEntered(phoneNum);
         booking.guestDetailsEntered(name, address);
         booking.roomTypeAndOccupantsEntered(roomType, occuptantNum);
         booking.bookingTimesEntered(arrivalDate, stayLength);
         booking.creditDetailsEntered(creditType, 1, 1);
         

         long confimationNum = hotel.book(room, guest, arrivalDate, stayLength, occuptantNum, card);
         
         
         CheckinCTL checkIn = new CheckinCTL(hotel);
         checkIn.confirmationNumberEntered(confimationNum);
         checkIn.checkInConfirmed(true);
         
         
         CheckoutCTL checkOut = new CheckoutCTL(hotel);
         checkOut.roomIdEntered(roomID);
         checkOut.chargesAccepted(true);
         checkOut.creditDetailsEntered(creditType, 1, 1);
                 
         RecordServiceCTL recordService = new RecordServiceCTL(hotel);
         recordService.roomNumberEntered(roomID);
         recordService.serviceDetailsEntered(ServiceType.BAR_FRIDGE, cost);
         Booking expected = null; 
         Booking book = hotel.findActiveBookingByRoomId(roomID);
         assertEquals(expected, book); 
                           
        
          }
      }
      
   
     

