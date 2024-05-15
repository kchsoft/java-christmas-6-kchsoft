package customer;

import food.Food;
import order.Orders;

import java.util.List;

public class Reservation {
    private final VisitingDay day;
    private final Orders orders;

    public Reservation(VisitingDay day, Orders orders) {
        this.day = day;
        this.orders = orders;
    }

    public Integer getTotalCost() {
        return orders.getTotalCost();
    }

    public List<Food> getFoods() {
        return orders.getFoods();
    }

    public Integer getTotalAmount() {
        return orders.getTotalAmount();
    }

    public VisitingDay getVisitingDay() {
        return day;
    }
}