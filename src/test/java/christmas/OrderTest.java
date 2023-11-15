package christmas;

import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_YEAR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import Event.Gift.GiftEvent;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OrderTest {

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

    @DisplayName("주문 하나가 올바르게 입력되는지 확인")
    @CsvSource({"MUSHROOM_SOUP,3","BBQ_RIB,1","ICE_CREAM,2"})
    @ParameterizedTest
    void checkAddOneMenu(Menu menu, Integer menuCount) {
        order.addMenu(menu, menuCount);
        assertThat(order.countNumberOf(menu)).isEqualTo(menuCount);

        assertThat(order.countNumberOf(Menu.RED_WINE)).isEqualTo(0);
    }

    @DisplayName("주문 여러개가 올바르게 입력되는지 확인")
    @CsvSource({"양송이수프-3,해산물파스타-5,아이스크림-1,3,5,1"})
    @ParameterizedTest
    void checkAddMenus(String orderFormat1,String orderFormat2,String orderFormat3
            ,Integer count1, Integer count2, Integer count3) {
        List<String> orderMenu = List.of(orderFormat1, orderFormat2, orderFormat3);
        order.addMenus(orderMenu);

        Integer index = 0;
        Integer[] countArr = new Integer[3];
        for (Menu menu : order.getMenus()) {
            countArr[index++] = order.countNumberOf(menu);
        }
        assertThat(countArr[0]).isEqualTo(count1);
        assertThat(countArr[1]).isEqualTo(count2);
        assertThat(countArr[2]).isEqualTo(count3);
    }

    @DisplayName("할인 전 총 금액 정상 작동 확인")
    @CsvSource({"레드와인-1,바비큐립-2,아이스크림-4,188000","타파스-2,시저샐러드-1,초코케이크-2,49000"})
    @ParameterizedTest
    void sumOriginalPrice(String orderFormat1,String orderFormat2,String orderFormat3,Integer sumPrice) {
        List<String> orderMenu = List.of(orderFormat1, orderFormat2, orderFormat3);
        order.addMenus(orderMenu);

        Money originalPrice = order.sumPrice();
        assertThat(originalPrice.getAmount()).isEqualTo(sumPrice);

    }

}