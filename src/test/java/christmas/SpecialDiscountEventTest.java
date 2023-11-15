package christmas;

import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_YEAR;
import static Event.Constant.EventNameConstant.SPECIAL_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import Event.Special.SpecialDiscountEvent;
import Event.Special.SpecialDiscountEventHistory;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialDiscountEventTest {

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

    @DisplayName("특별 할인이 적용 되는지 확인")
    @Test
    void applySpecialDiscountEvent() {
        SpecialDiscountEvent event = new SpecialDiscountEvent();
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 3);
        Order order = new Order(visitingDay);
        Receipt receipt = new Receipt();
        SpecialDiscountEventHistory history = (SpecialDiscountEventHistory) event.apply(order);

        assertThat(history.explainName()).isEqualTo(SPECIAL_DISCOUNT);
        assertThat(history.getBenefitValue()).isEqualTo(1000);
    }


}