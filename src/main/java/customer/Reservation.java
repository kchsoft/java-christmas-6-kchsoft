package customer;

import food.Food;
import money.UnmodifiedMoney;
import order.Orders;

import java.time.DayOfWeek;
import java.util.List;

public class Reservation {
    private final VisitingDay day;
    private final Orders orders;

    public Reservation(VisitingDay day, Orders orders) {
        this.day = day;
        this.orders = orders;
    }

    public UnmodifiedMoney getTotalCost() {
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

    public DayOfWeek getDay() {
        return day.getDayOfWeek();
    }

    public Integer getAmount(Food food) {
       return orders.getAmount(food);
    }

}