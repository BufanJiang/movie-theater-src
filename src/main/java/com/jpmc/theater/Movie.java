package com.jpmc.theater;

import java.time.Duration;
import java.util.HashMap;
import java.util.Objects;

public class Movie {
    //add final key word to make these as constants
    private static final int MOVIE_CODE_SPECIAL = 1;
    private static final int DISCOUNT_START_TIME = 11;
    private static final int DISCOUNT_END_TIME = 16;
    private static final int DISCOUNT_DAY_IN_MONTH = 7;

    //<Key, Value> -> <sequenceOfTheDay, discountValue>
    HashMap<Integer, Double> sequenceDiscountMap = new HashMap<Integer, Double>(){
        {
            put(1,3d);
            put(2,2d);
        }
    };

    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    //add description in the constructor as well
    public Movie(String title, String description, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.description = description;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double calculateTicketPrice(Showing showing) {
        return ticketPrice - getDiscount(showing);
    }


    //change the input parameter to be Showing object
    //add more discount rules here and we only consider the biggest discount value
    private double getDiscount(Showing showing) {
        double result = 0;
        if (MOVIE_CODE_SPECIAL == specialCode) {
            result = Math.max(ticketPrice * 0.2, result);  // 20% discount for special movie
        }

        // sequence discount
        if (sequenceDiscountMap.get(showing.getSequenceOfTheDay()) != null) {
            Double discount = sequenceDiscountMap.get(showing.getSequenceOfTheDay());
            result = Math.max(result, discount);
        }

        // showStartTime discount
        if (DISCOUNT_START_TIME <= showing.getStartTime().getHour()
                && showing.getStartTime().getHour() <= DISCOUNT_END_TIME) {
            result = Math.max(result, ticketPrice * 0.25);
        }

        // date discount
        if (showing.getStartTime().getDayOfMonth() == DISCOUNT_DAY_IN_MONTH) {
            result = Math.max(result, 1);
        }
        // biggest discount wins
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}