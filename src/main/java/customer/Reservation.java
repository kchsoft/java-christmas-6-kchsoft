package customer;

import order.Orders;

public class Reservation {
    private final VisitingDay day;
    private final Orders orders;

    public Reservation(VisitingDay day, Orders orders) {
        this.day = day;
        this.orders = orders;
    }

}