package christmas;

import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_YEAR;
import static Event.Constant.EventNameConstant.WEEKDAY_DISCOUNT;
import static Event.Constant.EventNameConstant.WEEKEND_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import Event.ChristmasEvent;
import Event.DayDiscount.DayDiscountEvent;
import Event.DayDiscount.DayDiscountEventHistory;
import Event.EventHistory;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DayDiscountEventTest {

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

    @DisplayName("평일 할인이 적용 되는지 확인")
    @Test
    void applyWeekdayDessertDiscount() {
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 5); // TUESDAY - WEEKDAY
        Order order = new Order(visitingDay);
        order.addMenu(Menu.ICE_CREAM, 3);

        Receipt receipt = event.applyAllEvent(order);
        EventHistory history = receipt.getHistory(WEEKDAY_DISCOUNT);

        assertThat(history.explainName()).isEqualTo(WEEKDAY_DISCOUNT);
        assertThat(((Money)history.getBenefit()).getAmount()).isEqualTo(2023 * 3);
    }

    @DisplayName("주말 할인이 적용 되는지 확인")
    @Test
    void applyWeekendDessertDiscount() {
        DayDiscountEvent event = new DayDiscountEvent();
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 2); // SATURDAY - WEEKEND
        Order order = new Order(visitingDay);
        order.addMenu(Menu.BBQ_RIB, 6);

        Receipt receipt = new Receipt();
        DayDiscountEventHistory history = (DayDiscountEventHistory) event.apply(order);

        assertThat(history.explainName()).isEqualTo(WEEKEND_DISCOUNT);
        assertThat(history.getBenefitValue()).isEqualTo(2023 * 6);
    }


}