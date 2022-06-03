package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationTests {

    //Here we should change the LocalDateTime.now() to an actual date time for testing purpose
    @Test
    void testTotalFee() {
        //change var to actual class object for project code consistence
        Customer customer = new Customer("John Doe", "unused-id");
        Showing showing = new Showing(
                new Movie("Spider-Man: No Way Home", "discription", Duration.ofMinutes(90), 12.5, 1),
                5,
                LocalDateTime.of(LocalDate.of(2022, 6, 3), LocalTime.of(18, 30))
        );
        //change the logic here to calculate the actual fee after discount instead of the original ticket price
        //change assertTrue to assertEquals because it gives the unit test framework more information
        assertEquals(new Reservation(customer, showing, 3).totalFee(), 30);
    }
}
