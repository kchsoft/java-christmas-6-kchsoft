package christmas;

import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_YEAR;
import static Event.Constant.EventNameConstant.CHRISTMAS_D_DAY_DISCOUNT_EVENT;
import static org.assertj.core.api.Assertions.assertThat;

import Event.ChristmasEvent;
import Event.EventHistory;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateDiscountEventTest {

    private LocalDate visitingDay;
    private Order order;
    private ChristmasEvent event;

    @BeforeEach
    void setVisitingDay() {
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 14);
    }

    @BeforeEach
    void setOrder() {
        order = new Order(visitingDay);
    }

    @BeforeEach
    void setEvent(){
        event = new ChristmasEvent();
    }

    @DisplayName("d-day 할인이 적용 되는지 확인")
    @Test
    void applyD_DayDiscountEvent() {
        Receipt receipt = event.applyAllEvent(order);
        EventHistory history = receipt.getHistory(CHRISTMAS_D_DAY_DISCOUNT_EVENT);

        assertThat(history.explainName()).isEqualTo(CHRISTMAS_D_DAY_DISCOUNT_EVENT);
        assertThat(((Money)history.getBenefit()).getAmount()).isEqualTo(2300); // day is 14

    }

}