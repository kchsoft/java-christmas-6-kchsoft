package converter;

import order.OrderInfos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConverterTest {

    @ParameterizedTest
    @DisplayName("String -> Integer 변환 성공")
    @ValueSource(strings = {"-33","-234897","0","1","12321","2463"})
    void stringToIntSuccess(String value) {
        assertDoesNotThrow(()-> Converter.stringToInt(value));
    }

    @ParameterizedTest
    @DisplayName("String -> Integer 변환 실패")
    @ValueSource(strings = {"a","ㄱ","한글","english",""})
    void stringToIntFail(String value) {
        assertThrows(IllegalArgumentException.class,
                ()->Converter.stringToInt(value));
    }

    @ParameterizedTest
    @DisplayName("String -> OrderInfos 변환 성공")
    @ValueSource(strings = {"0","0,0","아이스크림-5,제로콜라-4","양소이수프-3"})
    void stringToOrderInfosSuccess(String value) {
        assertDoesNotThrow(()-> Converter.stringToOrderInfos(value));
    }

    @ParameterizedTest
    @DisplayName("String -> OrderInfos 변환 실패")
    @ValueSource(strings = {"","아이스크림-4,제로콜라-2,","타파스-4,","아이스크림-4,,,양송이수프-3"})
    void stringToOrderInfosFail(String value) {
        assertThrows(IllegalArgumentException.class,
                ()->Converter.stringToOrderInfos(value));
    }

    @ParameterizedTest
    @DisplayName("OrderInfos -> OrderFormats 변환 성공")
    @ValueSource(strings = {"아이스크림-4","제로콜라-3","양송이수프-1","타파스-1"})
    void orderInfosToOrderFormatsSuccess(String value) {
        OrderInfos infos = new OrderInfos();
        infos.add(value);
        assertDoesNotThrow(()-> Converter.orderInfosToOrderFormats(infos));
    }

    @ParameterizedTest
    @DisplayName("OrderInfos -> OrderFormats 변환 실패")
    @ValueSource(strings = {"","제로콜라3","-양송이수프-3","타파스-5-","레드와인5-"})
    void orderInfosToOrderFormatsFail(String value) {
        OrderInfos infos = new OrderInfos();
        infos.add(value);
        assertThrows(IllegalArgumentException.class,
                ()->Converter.orderInfosToOrderFormats(infos));
    }

    @ParameterizedTest
    @DisplayName("String -> OrderFormats 변환 성공")
    @ValueSource(strings = {"아이스크림-4,제로콜라-2","제로콜라-3","양송이수프-1,타파스-5,레드와인-1"})
    void stringToOrderFormatsSuccess(String value) {
        assertDoesNotThrow(()-> Converter.stringToOrderFormats(value));
    }

    @ParameterizedTest
    @DisplayName("String -> OrderFormats 변환 실패")
    @ValueSource(strings = {
            "",
            "제로콜라3",
            "-양송이수프-3",
            "타파스-5-",
            "레드와인5-",
            ",타파스-3",
            "타파스-3,",
            "제로콜라-3,,타파스-1"})
    void stringToOrderFormatsFail(String value) {
        assertThrows(IllegalArgumentException.class,
                ()->Converter.stringToOrderFormats(value));
    }

    
}