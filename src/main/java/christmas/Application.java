package christmas;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        LocalDate visitingDay = restaurant.expectVisitngDay();
    }

}

