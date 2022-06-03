package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TheaterTests {

    //change the test method from totalFeeForCustomer to testReserve, we should leave testTotalFee()
    //in the ReservationTests class because it is not a method in Theater class.
    @Test
    void testReserve() {
        //test if reserve() method returns correct Reservation object
        Theater theater = new Theater(LocalDateProvider.singleton());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 2, 4);
//        System.out.println("You have to pay " + reservation.getTotalFee());

        Showing showing = new Showing(new Movie("Spider-Man: No Way Home", "discription", Duration.ofMinutes(90), 12.5, 1), 2, LocalDateTime.of(theater.provider.currentDate(), LocalTime.of(11, 0)));
        Reservation anotherReservation = new Reservation(john, showing, 4);
        //test if reservation and anotherReservation contain same information
        assertTrue(reservation.getCustomer().equals(anotherReservation.getCustomer()));
        assertTrue(reservation.getShowing().equals(anotherReservation.getShowing()));
        assertTrue(reservation.getAudienceCount() == anotherReservation.getAudienceCount());
    }

    @Test
    void testPrintSchedule() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }

    @Test
    void testPrintScheduleSimpleAndJson() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printScheduleSimpleAndJson();
    }
}
