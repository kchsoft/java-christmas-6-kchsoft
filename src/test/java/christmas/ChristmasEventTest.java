package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.EventConstant.EVENT_MONTH;
import static christmas.EventConstant.EVENT_YEAR;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void checkOrderMenu(){
        Order order = new Order(visitingDay);
        order.addFood(FoodMenu.BBQ_RIB,1);
        order.addFood(FoodMenu.MUSHROOM_SOUP,3);
        order.addFood(FoodMenu.ICE_CREAM,2);

        assertThat(order.getNumberOfMenu(FoodMenu.BBQ_RIB)).isEqualTo(1);
        assertThat(order.getNumberOfMenu(FoodMenu.BBQ_RIB)).isNotEqualTo(0);
        assertThat(order.getNumberOfMenu(FoodMenu.BBQ_RIB)).isNotEqualTo(2);

        assertThat(order.getNumberOfMenu(FoodMenu.MUSHROOM_SOUP)).isEqualTo(3);
        assertThat(order.getNumberOfMenu(FoodMenu.ICE_CREAM)).isEqualTo(2);
        assertThat(order.getNumberOfMenu(FoodMenu.RED_WINE)).isEqualTo(0);
    }

}