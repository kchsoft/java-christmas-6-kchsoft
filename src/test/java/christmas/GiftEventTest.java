package christmas;

import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_YEAR;
import static Event.Constant.EventNameConstant.GIFT_EVENT;
import static org.assertj.core.api.Assertions.assertThat;

import Event.Gift.GiftEvent;
import Event.Gift.GiftEventHistory;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiftEventTest {

    private LocalDate visitingDay;
    private Order order;

    @BeforeEach
    void setVisitingDay() {
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 14); // Random day
    }

    @BeforeEach
    void setOrder() {
        order = new Order(visitingDay);
    }

    @DisplayName("증정 이벤트가 적용되는지 확인")
    @Test
    void applyGiftEvent() {
        GiftEvent event = new GiftEvent();
        Order order = new Order(visitingDay);
        order.addMenu(Menu.T_BONE_STEAK, 2);
        order.addMenu(Menu.CHOCOLATE_CAKE, 2); // over 12,000원

        Receipt receipt = new Receipt();
        GiftEventHistory history = (GiftEventHistory) event.apply(order);

        assertThat(history.explainName()).isEqualTo(GIFT_EVENT);
        assertThat(history.getBenefit()).isEqualTo(Menu.CHAMPAGNE);
        assertThat(history.getBenefit().getPriceValue()).isEqualTo(Menu.CHAMPAGNE.getPriceValue());

    }


}