package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {

    //change the test method name to 20Percent, the original method name(50Percent) shows wrong information
    //also we need to change the logic here(cannot use LocalDate.now()) to avoid triggering other discount rules
    @Test
    void testSpecialMovieWith20PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", "discription", Duration.ofMinutes(90), 12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.of(2022, 6, 3), LocalTime.of(18, 30)));
        assertEquals(10, spiderMan.calculateTicketPrice(showing));

        System.out.println(Duration.ofMinutes(90));
    }

//------------------------Add more test cases here-------------------------------------------------
    @Test
    void test11AMTo4PMWith25PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", "discription", Duration.ofMinutes(90), 12.5, 2);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.of(2022, 6, 3), LocalTime.of(12, 30)));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void testSeventhDayWithOneDollarDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", "discription", Duration.ofMinutes(90), 12.5, 2);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.of(2022, 6, 7), LocalTime.of(18, 30)));
        assertEquals(11.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void testFirstMovieWithThreeDollarDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", "discription", Duration.ofMinutes(90), 12.5, 2);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.of(2022, 6, 3), LocalTime.of(18, 30)));
        assertEquals(9.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void testSecondMovieWithTwoDollarDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", "discription", Duration.ofMinutes(90), 12.5, 2);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.of(2022, 6, 3), LocalTime.of(18, 30)));
        assertEquals(10.5, spiderMan.calculateTicketPrice(showing));
    }

//-------------------------all the above are single rule test cases----------------------------------------
//-------------------------below are test cases which satisfy multiple discount rules----------------------
    @Test
    void testSpecialCodeHappyHourFirstMovieOnSeventhDay() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", "discription", Duration.ofMinutes(90), 12.5, 1);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.of(2022, 6, 7), LocalTime.of(12, 30)));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void testSpecialCodeHappyHourSecondMovie() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", "discription", Duration.ofMinutes(90), 12.5, 1);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.of(2022, 6, 6), LocalTime.of(12, 30)));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void testFirstMovieOnSeventhDay() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", "discription", Duration.ofMinutes(90), 12.5, 2);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.of(2022, 6, 7), LocalTime.of(20, 30)));
        assertEquals(9.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void testHappyHourOnSeventhDay() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", "discription", Duration.ofMinutes(90), 12.5, 2);
        Showing showing = new Showing(spiderMan, 4, LocalDateTime.of(LocalDate.of(2022, 6, 7), LocalTime.of(12, 30)));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
    }
}
