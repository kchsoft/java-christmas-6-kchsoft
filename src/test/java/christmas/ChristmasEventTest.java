package christmas;

import static Event.EventNameConstant.CHRISTMAS_D_DAY_DISCOUNT_EVENT;
import static Event.EventConstant.EVENT_MONTH;
import static Event.EventConstant.EVENT_YEAR;
import static Event.EventNameConstant.SPECIAL_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import Event.DateDiscountEvent;
import Event.DateDiscountEventHistory;
import Event.SpecialDiscountEvent;
import Event.SpecialDiscountEventHistory;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChristmasEventTest {

    private LocalDate visitingDay;

    @BeforeEach
    void setVisitingDay() {
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 14); // Random day
    }

    @DisplayName("입력한 요일과 날짜를 올바르게 반환하는지 확인")
    @Test
    void checkReturnDayAndDate() {
        assertThat(visitingDay.getYear()).isEqualTo(EVENT_YEAR);
        assertThat(visitingDay.getMonth()).isEqualTo(Month.DECEMBER);
        assertThat(visitingDay.getDayOfMonth()).isEqualTo(14);
        assertThat(visitingDay.getDayOfWeek()).isEqualTo(DayOfWeek.THURSDAY);
    }

    @DisplayName("주문이 올바르게 입력되었는지 확인")
    @Test
    void checkOrderMenu() {
        Order order = new Order(visitingDay);
        order.addFood(FoodMenu.BBQ_RIB, 1);
        order.addFood(FoodMenu.MUSHROOM_SOUP, 3);
        order.addFood(FoodMenu.ICE_CREAM, 2);

        assertThat(order.getNumberOfMenu(FoodMenu.BBQ_RIB)).isEqualTo(1);
        assertThat(order.getNumberOfMenu(FoodMenu.BBQ_RIB)).isNotEqualTo(0);
        assertThat(order.getNumberOfMenu(FoodMenu.BBQ_RIB)).isNotEqualTo(2);

        assertThat(order.getNumberOfMenu(FoodMenu.MUSHROOM_SOUP)).isEqualTo(3);
        assertThat(order.getNumberOfMenu(FoodMenu.ICE_CREAM)).isEqualTo(2);
        assertThat(order.getNumberOfMenu(FoodMenu.RED_WINE)).isEqualTo(0);
    }

    @DisplayName("d-day 할인이 적용 되는지 확인")
    @Test
    void applyD_DayDiscountEvent(){
        DateDiscountEvent event = new DateDiscountEvent();
        Order order = new Order(visitingDay);
        Receipt receipt = new Receipt(order);
        DateDiscountEventHistory history = (DateDiscountEventHistory)event.apply(order);

        assertThat(history.explainName()).isEqualTo(CHRISTMAS_D_DAY_DISCOUNT_EVENT);
        assertThat(history.getDiscountAmount()).isEqualTo(2300); // day is 14

    }

    @DisplayName("특별 할인이 적용 되는지 확인")
    @Test
    void applySpecialDiscountEvent(){
        SpecialDiscountEvent event = new SpecialDiscountEvent();
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 3);
        Order order = new Order(visitingDay);
        Receipt receipt = new Receipt(order);
        SpecialDiscountEventHistory history = (SpecialDiscountEventHistory) event.apply(order);

        assertThat(history.explainName()).isEqualTo(SPECIAL_DISCOUNT);
        assertThat(history.getDiscountAmount()).isEqualTo(1000);
    }

}