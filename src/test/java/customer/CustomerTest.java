package customer;

import converter.Converter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
class CustomerTest {

    Customer customer = new Customer();

    @ParameterizedTest
    @DisplayName("1~31 숫자 입력시 날짜 입력 성공")
    @ValueSource(strings = {"1","2","31","16"})
    void dayInputSuccess(String value) {
        Integer dayInfo = Converter.stringToInt(value);
        VisitingDay day = new VisitingDay(dayInfo);
        Assertions.assertThat(day).isEqualTo(new VisitingDay(Integer.parseInt(value)));
    }

    @ParameterizedTest
    @DisplayName("1~31 이외에 숫자 입력시 날짜 입력 실패")
    @ValueSource(strings = {"-1","0","32","35"})
    void dayInputFail(String value) {
        Integer dayInfo = Converter.stringToInt(value);
        assertThrows(IllegalArgumentException.class,
                () -> new VisitingDay(dayInfo));
    }

}