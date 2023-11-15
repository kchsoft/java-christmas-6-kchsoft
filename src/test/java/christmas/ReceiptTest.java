package christmas;

import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_YEAR;
import static org.assertj.core.api.Assertions.assertThat;

import Event.ChristmasEvent;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ReceiptTest {

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

    @DisplayName("할인 금액을 올바르게 구하는지 확인")
    @CsvSource({"1000,1000,0","500,123,377","14520,4020,10500"})
    @ParameterizedTest
    void checkDiscountAmount() {
        order.addMenu(Menu.ICE_CREAM, 3);
        ChristmasEvent event = new ChristmasEvent();

        Receipt receipt = event.applyAllEvent(order);

        Money discountAmount = receipt.getDiscountAmount();
        assertThat(discountAmount.getAmount()).isEqualTo(3400 + 2023 * 3 + 1000);

    }

}