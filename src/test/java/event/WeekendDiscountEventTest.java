package event;

import customer.Reservation;
import customer.VisitingDay;
import eventhistory.EventHistory;
import food.Food;
import order.Order;
import order.Orders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WeekendDiscountEventTest {

    PreCalculateEvent event = new WeekendDiscountEvent();
    Orders orders = new Orders();
    VisitingDay day = new VisitingDay(2);

    @Test
    @DisplayName("주말에 메인 메뉴 주문시 할인 성공")
    void weekendDiscountSuccess() {
        orders.add(new Order(Food.SEAFOOD_PASTA, 2));
        orders.add(new Order(Food.CHOCOLATE_CAKE, 3));
        EventHistory history = event.apply(new Reservation(day, orders));
        assertThat(history.getBenefit()).isEqualTo(2023*2);
    }

    @Test
    @DisplayName("주말에 메인 메뉴 제외 주문시 할인 실패")
    void weekendDiscountFail() {
        day = new VisitingDay(9);
        orders.add(new Order(Food.CAESAR_SALAD, 4));
        EventHistory history = event.apply(new Reservation(day, orders));
        assertThat(history.getBenefit()).isEqualTo(0);
    }

    @Test
    @DisplayName("평일에 메인 메뉴 주문시 할인 실패")
    void weekdayDiscountFail() {
        day = new VisitingDay(4);
        orders.add(new Order(Food.SEAFOOD_PASTA, 4));
        EventHistory history = event.apply(new Reservation(day, orders));
        assertThat(history.getBenefit()).isEqualTo(0);
    }

}