package event;

import customer.Reservation;
import customer.VisitingDay;
import eventhistory.EventHistory;
import food.Food;
import money.Cost;
import order.Order;
import order.Orders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpecialDiscountEventTest {

    PreCalculateEvent event = new SpecialDiscountEvent();
    Orders orders = new Orders();
    VisitingDay day;

    @Test
    @DisplayName("특별한 날에 음식 주문시 할인 성공")
    void specialDayDiscountSuccess() {
        day = new VisitingDay(3);
        orders.add(new Order(Food.SEAFOOD_PASTA, 2));
        EventHistory history = event.apply(new Reservation(day, orders));
        assertThat(history.getBenefit()).isEqualTo(new Cost(1000));
    }

    @Test
    @DisplayName("일반적인 날에 음식 주문시 할인 실패")
    void specialDayDiscountFail() {
        day = new VisitingDay(5);
        orders.add(new Order(Food.SEAFOOD_PASTA, 2));
        EventHistory history = event.apply(new Reservation(day, orders));
        assertThat(history.getBenefit()).isEqualTo(new Cost(0));
    }

}