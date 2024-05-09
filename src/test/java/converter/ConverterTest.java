package converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validator.InputValidator;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @ParameterizedTest
    @DisplayName("문자열 to Integer 변환 성공")
    @ValueSource(strings = {"-33","-234897","0","1","12321","2463"})
    void convertSuccess(String value) {
        assertDoesNotThrow(()-> InputValidator.checkStringToInt(value));
    }

    @ParameterizedTest
    @DisplayName("문자열 to Integer 변환 실패")
    @ValueSource(strings = {"a","ㄱ","한글","english",""})
    void convertFail(String value) {
        assertThrows(IllegalArgumentException.class,
                ()->InputValidator.checkStringToInt(value));
    }

}