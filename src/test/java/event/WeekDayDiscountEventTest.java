package event;

import customer.Reservation;
import customer.VisitingDay;
import event.weekday.WeekDayDiscountEvent;
import eventhistory.EventHistory;
import food.Food;
import money.Cost;
import order.Order;
import order.Orders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WeekDayDiscountEventTest {

    PreCalculateEvent event = new WeekDayDiscountEvent();
    Orders orders = new Orders();
    VisitingDay day = new VisitingDay(4);

    @Test
    @DisplayName("평일에 디저트 주문시 할인 성공")
    void weekdayDiscountSuccess() {
        orders.add(new Order(Food.SEAFOOD_PASTA, 2));
        orders.add(new Order(Food.CHOCOLATE_CAKE, 3));
        EventHistory history = event.apply(new Reservation(day, orders));
        assertThat(history.getBenefit()).isEqualTo(new Cost(2023*3));
    }

    @Test
    @DisplayName("평일에 디저트 제외 주문시 할인 실패")
    void weekdayDiscountFail() {
        day = new VisitingDay(4);
        orders.add(new Order(Food.SEAFOOD_PASTA, 4));
        EventHistory history = event.apply(new Reservation(day, orders));
        assertThat(history.getBenefit()).isEqualTo(new Cost(0));
    }

    @Test
    @DisplayName("주말에 디저트 주문시 할인 실패")
    void weekendDiscountFail() {
        day = new VisitingDay(1);
        orders.add(new Order(Food.SEAFOOD_PASTA, 4));
        orders.add(new Order(Food.CHOCOLATE_CAKE, 3));
        EventHistory history = event.apply(new Reservation(day, orders));
        assertThat(history.getBenefit()).isEqualTo(new Cost(0));
    }

}