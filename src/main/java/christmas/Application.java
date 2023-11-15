package christmas;

import Event.ChristmasEvent;
import View.OrderOutputView;
import View.ReceiptOutputView;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.startBusiness();
    }

}

