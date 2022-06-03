package com.jpmc.theater;

import java.time.LocalDate;

public class LocalDateProvider {
    private static LocalDateProvider instance = null;

    //add private constructor to create Singleton class
    private LocalDateProvider() {}

    /**
     * @return make sure to return singleton instance
     */
    //add synchronized key word to make sure it is thread safe
    public static synchronized LocalDateProvider singleton() {
        if (instance == null) {
            instance = new LocalDateProvider();
        }
        return instance;
    }

    public LocalDate currentDate() {
        return LocalDate.now();
    }
}
