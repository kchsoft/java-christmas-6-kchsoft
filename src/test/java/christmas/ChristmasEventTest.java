package christmas;

import static Event.Constant.EventConstant.SANTA;
import static Event.Constant.EventConstant.STAR;
import static Event.Constant.EventConstant.TREE;
import static Event.Constant.EventNameConstant.CHRISTMAS_D_DAY_DISCOUNT_EVENT;
import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_YEAR;
import static Event.Constant.EventNameConstant.DECEMBER_EVENT_BADGE;
import static Event.Constant.EventNameConstant.GIFT_EVENT;
import static Event.Constant.EventNameConstant.SPECIAL_DISCOUNT;
import static Event.Constant.EventNameConstant.WEEKDAY_DISCOUNT;
import static Event.Constant.EventNameConstant.WEEKEND_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import Event.Badge.BadgeEvent;
import Event.Badge.BadgeEventHistory;
import Event.DateDiscount.DateDiscountEvent;
import Event.DateDiscount.DateDiscountEventHistory;
import Event.DayDiscount.DayDiscountEvent;
import Event.DayDiscount.DayDiscountEventHistory;
import Event.Event;
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
        assertThat(history.getBenefitValue()).isEqualTo(1000);
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
    void sumOriginalPrice() {
        GiftEvent event = new GiftEvent();
        Order order = new Order(visitingDay);
        order.addMenu(Menu.MUSHROOM_SOUP, 2);

        Money originalPrice = order.sumPrice();
        assertThat(originalPrice.getAmount()).isEqualTo(12000);

    }

    @DisplayName("증정 이벤트가 적용되는지 확인")
    @Test
    void applyGiftEvent() {
        GiftEvent event = new GiftEvent();
        Order order = new Order(visitingDay);
        order.addMenu(Menu.T_BONE_STEAK, 2);
        order.addMenu(Menu.CHOCOLATE_CAKE, 2); // over 12,000원

        Receipt receipt = new Receipt(order);
        GiftEventHistory history = (GiftEventHistory) event.apply(order);

        assertThat(history.explainName()).isEqualTo(GIFT_EVENT);
        assertThat(history.getBenefit()).isEqualTo(Menu.CHAMPAGNE);
        assertThat(history.getBenefit().getPriceValue()).isEqualTo(Menu.CHAMPAGNE.getPriceValue());

    }

    @DisplayName("할인 금액을 올바르게 구하는지 확인")
    @Test
    void checkDiscountAmount() {
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 25);
        Order order = new Order(visitingDay);
        order.addMenu(Menu.ICE_CREAM, 3);
        Receipt receipt = new Receipt(order);

        Event event = new DateDiscountEvent();
        receipt.addHistory(event.apply(order));

        event = new DayDiscountEvent();
        receipt.addHistory(event.apply(order));

        event = new SpecialDiscountEvent();
        receipt.addHistory(event.apply(order));

        Money discountAmount = receipt.getDiscountAmount();
        assertThat(discountAmount.getAmount()).isEqualTo(3400 + 2023 * 3 + 1000);

    }

    @DisplayName("배지 이벤트가 SANTA가 적용되는지 확인")
    @Test
    void applyBadgeEvent_SANTA() {
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 25);
        Event event;
        Order order = new Order(visitingDay);
        order.addMenu(Menu.ICE_CREAM, 10);
        order.addMenu(Menu.T_BONE_STEAK, 2); // over benefit 20,000

        Receipt receipt = new Receipt(order);

        event = new DateDiscountEvent();
        receipt.addHistory(event.apply(order));

        event = new DayDiscountEvent();
        receipt.addHistory(event.apply(order));

        event = new SpecialDiscountEvent();
        receipt.addHistory(event.apply(order));

        event = new BadgeEvent();
        BadgeEventHistory history = (BadgeEventHistory) event.apply(receipt);

        assertThat(history.explainName()).isEqualTo(DECEMBER_EVENT_BADGE);
        assertThat(history.getBenefit()).isEqualTo(SANTA);

    }

    @DisplayName("배지 이벤트가 TREE가 적용되는지 확인")
    @Test
    void applyBadgeEvent_TREE() {
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 25);
        Event event;
        Order order = new Order(visitingDay);
        order.addMenu(Menu.ICE_CREAM, 5);
        order.addMenu(Menu.T_BONE_STEAK, 2); // benefit 10,000 ~ 19,999

        Receipt receipt = new Receipt(order);

        event = new DateDiscountEvent();
        receipt.addHistory(event.apply(order));

        event = new DayDiscountEvent();
        receipt.addHistory(event.apply(order));

        event = new SpecialDiscountEvent();
        receipt.addHistory(event.apply(order));

        event = new BadgeEvent();
        BadgeEventHistory history = (BadgeEventHistory) event.apply(receipt);

        assertThat(history.explainName()).isEqualTo(DECEMBER_EVENT_BADGE);
        assertThat(history.getBenefit()).isEqualTo(TREE);

    }

    @DisplayName("배지 이벤트가 STAR가 적용되는지 확인")
    @Test
    void applyBadgeEvent_STAR() {
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 25);
        Event event;
        Order order = new Order(visitingDay);
        order.addMenu(Menu.ICE_CREAM, 2); // benefit 5,000 ~ 9,999

        Receipt receipt = new Receipt(order);

        event = new DateDiscountEvent();
        receipt.addHistory(event.apply(order));

        event = new DayDiscountEvent();
        receipt.addHistory(event.apply(order));

        event = new SpecialDiscountEvent();
        receipt.addHistory(event.apply(order));

        event = new BadgeEvent();
        BadgeEventHistory history = (BadgeEventHistory) event.apply(receipt);

        assertThat(history.explainName()).isEqualTo(DECEMBER_EVENT_BADGE);
        assertThat(history.getBenefit()).isEqualTo(STAR);

    }

    @DisplayName("Money가 String으로 변환되는지 확인")
    @Test
    void checkMoenyToString(){
        Money money = new Money(500);
        assertThat(money.toString()).isEqualTo("500");

        money = new Money(1700);
        assertThat(money.toString()).isEqualTo("1,700");

        money = new Money(12000);
        assertThat(money.toString()).isEqualTo("12,000");

    }
}