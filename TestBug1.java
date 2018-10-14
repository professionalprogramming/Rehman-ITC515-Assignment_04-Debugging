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
public class Bug1 {
        
      @Test
      public void testServiceCharge() {       
         
          double cost = 54.0; 
          Booking booking = new Booking(new Guest("Rehman", "Noble Park", 0406047174), new Room(101, RoomType.SINGLE),
                             new Date(), 22, 03, new CreditCard(CreditCardType.MASTERCARD, 1, 1)); 
         
          booking.addServiceCharge(ServiceType.BAR_FRIDGE, cost); 
          List<ServiceCharge> charges = booking.getCharges(); 
          for(ServiceCharge sc: charges) {
              assertEquals(cost, sc.getCost(), 120); 
          }
      }
      
}
