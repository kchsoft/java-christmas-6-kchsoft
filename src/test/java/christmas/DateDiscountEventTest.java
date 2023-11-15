package christmas;

import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_YEAR;
import static Event.Constant.EventNameConstant.CHRISTMAS_D_DAY_DISCOUNT_EVENT;
import static org.assertj.core.api.Assertions.assertThat;

import Event.DateDiscount.DateDiscountEvent;
import Event.DateDiscount.DateDiscountEventHistory;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateDiscountEventTest {

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

    @DisplayName("d-day 할인이 적용 되는지 확인")
    @Test
    void applyD_DayDiscountEvent() {
        DateDiscountEvent event = new DateDiscountEvent();
        Order order = new Order(visitingDay);
        Receipt receipt = new Receipt();
        DateDiscountEventHistory history = (DateDiscountEventHistory) event.apply(order);

        assertThat(history.explainName()).isEqualTo(CHRISTMAS_D_DAY_DISCOUNT_EVENT);
        assertThat(history.getBenefitValue()).isEqualTo(2300); // day is 14

    }

}