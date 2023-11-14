package christmas;

import static Event.Constant.EventNameConstant.CHRISTMAS_D_DAY_DISCOUNT_EVENT;
import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_YEAR;
import static Event.Constant.EventNameConstant.GIFT_EVENT;
import static Event.Constant.EventNameConstant.SPECIAL_DISCOUNT;
import static Event.Constant.EventNameConstant.WEEKDAY_DISCOUNT;
import static Event.Constant.EventNameConstant.WEEKEND_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import Event.DateDiscount.DateDiscountEvent;
import Event.DateDiscount.DateDiscountEventHistory;
import Event.DayDiscount.DayDiscountEvent;
import Event.DayDiscount.DayDiscountEventHistory;
import Event.Gift.GiftEvent;
import Event.Gift.GiftEventHistory;
import Event.Special.SpecialDiscountEvent;
import Event.Special.SpecialDiscountEventHistory;
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
        order.addMenu(Menu.BBQ_RIB, 1);
        order.addMenu(Menu.MUSHROOM_SOUP, 3);
        order.addMenu(Menu.ICE_CREAM, 2);

        assertThat(order.countNumberOf(Menu.BBQ_RIB)).isEqualTo(1);
        assertThat(order.countNumberOf(Menu.BBQ_RIB)).isNotEqualTo(0);
        assertThat(order.countNumberOf(Menu.BBQ_RIB)).isNotEqualTo(2);

        assertThat(order.countNumberOf(Menu.MUSHROOM_SOUP)).isEqualTo(3);
        assertThat(order.countNumberOf(Menu.ICE_CREAM)).isEqualTo(2);
        assertThat(order.countNumberOf(Menu.RED_WINE)).isEqualTo(0);
    }

    @DisplayName("d-day 할인이 적용 되는지 확인")
    @Test
    void applyD_DayDiscountEvent() {
        DateDiscountEvent event = new DateDiscountEvent();
        Order order = new Order(visitingDay);
        Receipt receipt = new Receipt(order);
        DateDiscountEventHistory history = (DateDiscountEventHistory) event.apply(order);

        assertThat(history.explainName()).isEqualTo(CHRISTMAS_D_DAY_DISCOUNT_EVENT);
        assertThat(history.getBenefitValue()).isEqualTo(2300); // day is 14

    }

    @DisplayName("특별 할인이 적용 되는지 확인")
    @Test
    void applySpecialDiscountEvent() {
        SpecialDiscountEvent event = new SpecialDiscountEvent();
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 3);
        Order order = new Order(visitingDay);
        Receipt receipt = new Receipt(order);
        SpecialDiscountEventHistory history = (SpecialDiscountEventHistory) event.apply(order);

        assertThat(history.explainName()).isEqualTo(SPECIAL_DISCOUNT);
        assertThat(history.getDiscountAmount()).isEqualTo(1000);
    }

    @DisplayName("평일 할인이 적용 되는지 확인")
    @Test
    void applyWeekdayDessertDiscount() {
        DayDiscountEvent event = new DayDiscountEvent();
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 5); // TUESDAY - WEEKDAY
        Order order = new Order(visitingDay);
        order.addMenu(Menu.ICE_CREAM, 3);

        Receipt receipt = new Receipt(order);
        DayDiscountEventHistory history = (DayDiscountEventHistory) event.apply(order);

        assertThat(history.explainName()).isEqualTo(WEEKDAY_DISCOUNT);
        assertThat(history.getBenefitValue()).isEqualTo(2023 * 3);
    }

    @DisplayName("주말 할인이 적용 되는지 확인")
    @Test
    void applyWeekendDessertDiscount() {
        DayDiscountEvent event = new DayDiscountEvent();
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 2); // SATURDAY - WEEKEND
        Order order = new Order(visitingDay);
        order.addMenu(Menu.BBQ_RIB, 6);

        Receipt receipt = new Receipt(order);
        DayDiscountEventHistory history = (DayDiscountEventHistory) event.apply(order);

        assertThat(history.explainName()).isEqualTo(WEEKEND_DISCOUNT);
        assertThat(history.getBenefitValue()).isEqualTo(2023 * 6);
    }

    @DisplayName("할인 전 총 금액 종합 확인")
    @Test
    void sumOriginalPrice(){
        GiftEvent event = new GiftEvent();
        Order order = new Order(visitingDay);
        order.addMenu(Menu.MUSHROOM_SOUP,2);

        Money originalPrice = order.sumPrice();
        assertThat(originalPrice.getAmount()).isEqualTo(12000);

    }

    @DisplayName("증정 이벤트가 적용되는지 확인")
    @Test
    void applyGiftEvent(){
        GiftEvent event = new GiftEvent();
        Order order = new Order(visitingDay);
        order.addMenu(Menu.T_BONE_STEAK,2);
        order.addMenu(Menu.CHOCOLATE_CAKE,2); // over 12,000원

        Receipt receipt = new Receipt(order);
        GiftEventHistory history = (GiftEventHistory) event.apply(order);

        assertThat(history.explainName()).isEqualTo(GIFT_EVENT);
        assertThat(history.getBenefit()).isEqualTo(Menu.CHAMPAGNE);
        assertThat(history.getBenefit().getPrice()).isEqualTo(Menu.CHAMPAGNE.getPrice());

    }

}