package christmas;

import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_YEAR;
import static Event.Constant.EventConstant.SANTA;
import static Event.Constant.EventConstant.STAR;
import static Event.Constant.EventConstant.TREE;
import static Event.Constant.EventNameConstant.DECEMBER_EVENT_BADGE;
import static org.assertj.core.api.Assertions.assertThat;

import Event.EventHistory;
import Event.ChristmasEvent;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeEventTest {


    private LocalDate visitingDay;
    private Order order;
    private ChristmasEvent event;

    @BeforeEach
    void setVisitingDay() {
        visitingDay = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 25);
    }

    @BeforeEach
    void setOrder() {
        order = new Order(visitingDay);
    }

    @BeforeEach
    void setEvent(){
        event = new ChristmasEvent();
    }

    @DisplayName("배지 이벤트가 SANTA가 적용되는지 확인")
    @Test
    void applyBadgeEvent_SANTA() {
        order.addMenu(Menu.ICE_CREAM, 10);
        order.addMenu(Menu.T_BONE_STEAK, 2); // over benefit 20,000

        Receipt receipt = event.applyAllEvent(order);

        EventHistory history = receipt.getHistory(DECEMBER_EVENT_BADGE);
        assertThat(history.explainName()).isEqualTo(DECEMBER_EVENT_BADGE);
        assertThat(history.getBenefit()).isEqualTo(SANTA);

    }

    @DisplayName("배지 이벤트가 TREE가 적용되는지 확인")
    @Test
    void applyBadgeEvent_TREE() {
        order.addMenu(Menu.ICE_CREAM, 3);
        order.addMenu(Menu.T_BONE_STEAK, 1); // benefit 10,000 ~ 19,999

        Receipt receipt = event.applyAllEvent(order);

        EventHistory history = receipt.getHistory(DECEMBER_EVENT_BADGE);
        assertThat(history.explainName()).isEqualTo(DECEMBER_EVENT_BADGE);
        assertThat(history.getBenefit()).isEqualTo(TREE);

    }

    @DisplayName("배지 이벤트가 STAR가 적용되는지 확인")
    @Test
    void applyBadgeEvent_STAR() {
        order.addMenu(Menu.ICE_CREAM, 2); // benefit 5,000 ~ 9,999

        Receipt receipt = event.applyAllEvent(order);

        EventHistory history = receipt.getHistory(DECEMBER_EVENT_BADGE);

        assertThat(history.explainName()).isEqualTo(DECEMBER_EVENT_BADGE);
        assertThat(history.getBenefit()).isEqualTo(STAR);

    }

}