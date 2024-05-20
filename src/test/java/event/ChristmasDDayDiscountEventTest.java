package event;

import customer.Reservation;
import customer.VisitingDay;
import event.christmas.ChristmasDDayDiscountEvent;
import eventhistory.EventHistory;
import food.Food;
import money.Cost;
import order.Order;
import order.Orders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChristmasDDayDiscountEventTest {

    ChristmasDDayDiscountEvent event = new ChristmasDDayDiscountEvent();
    Orders orders = new Orders();
    VisitingDay day = new VisitingDay(1);

    @Test
    @DisplayName("1~25일에 음식 주문시 할인 성공")
    void discountSuccess() {
        orders.add(new Order(Food.SEAFOOD_PASTA, 5));
        EventHistory history = event.apply(new Reservation(day, orders));
        assertThat(history.getBenefitValue()).isEqualTo(new Cost(1000));
    }

    @Test
    @DisplayName("26일 이후에 음식 주문시 할인 적용 불가")
    void discountFail() {
        day = new VisitingDay(27);
        orders.add(new Order(Food.SEAFOOD_PASTA, 5));
        EventHistory history = event.apply(new Reservation(day, orders));
        assertThat(history.getBenefitValue()).isEqualTo(new Cost(0));
    }

}