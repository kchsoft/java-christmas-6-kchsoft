package christmas;

import Event.DateDiscountEvent;
import java.time.LocalDate;

public class Application {


    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        LocalDate visitingDay = restaurant.expectVisitngDay();
        Order order = restaurant.orderMenu(visitingDay);
        Receipt receipt = new Receipt(order);
        DateDiscountEvent dateDiscountEvent = new DateDiscountEvent();
        receipt.addHistory(dateDiscountEvent.apply(order));
    }

}

