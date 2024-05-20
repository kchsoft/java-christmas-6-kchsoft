package event;

import customer.Reservation;
import customer.VisitingDay;
import event.gift.GiftEvent;
import eventhistory.EventHistory;
import food.Food;
import order.Order;
import order.Orders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GiftEventTest {

    PreCalculateEvent event = new GiftEvent();
    Orders orders = new Orders();
    VisitingDay day = new VisitingDay(4);

    @Test
    @DisplayName("12,000원 이상 구매하여 선물 증정 성공")
    void getGiftSuccess() {
        orders.add(new Order(Food.SEAFOOD_PASTA, 3));
        orders.add(new Order(Food.CHOCOLATE_CAKE, 2));
        orders.add(new Order(Food.T_BONE_STEAK, 1));
        EventHistory history = event.apply(new Reservation(day, orders));
        assertThat(history.getBenefit()).isEqualTo(Food.CHAMPAGNE);
    }

    @Test
    @DisplayName("12,000원 이상 구매하여 선물 증정 성공")
    void getGiftFail() {
        orders.add(new Order(Food.T_BONE_STEAK, 2));
        EventHistory history = event.apply(new Reservation(day, orders));
        assertThat(history.getBenefit()).isEqualTo(null);
    }

}