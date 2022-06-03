package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalDateProviderTests {

    //add this test case to check if LocalDateProvider only has one single instance
    @Test
    void testSingleton() {
        assertEquals(LocalDateProvider.singleton(), LocalDateProvider.singleton());
    }


    //change to use assertEquals to test the current time
    @Test
    void testCurrentTime() {
        LocalDate now = LocalDate.now();
        assertEquals(LocalDateProvider.singleton().currentDate(), now);
        System.out.println("current time is - " + LocalDateProvider.singleton().currentDate());
    }
}
