package christmas;

import Event.ChristmasEvent;
import View.OrderOutputView;
import View.ReceiptOutputView;
import java.time.LocalDate;

public class Application {


    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        LocalDate visitingDay = restaurant.expectVisitngDay();
        ChristmasEvent christmasEvent = new ChristmasEvent();
        Order order = restaurant.orderMenu(visitingDay);

        Receipt receipt = christmasEvent.applyAllEvent(order);

        OrderOutputView.showOrderHistory(order);
        ReceiptOutputView.showReceiptHistory(receipt,order);
    }

}

