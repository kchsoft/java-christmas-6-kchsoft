package order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderFormatPatternTest {

    String regex = "[가-힣]+-[1-9]([\\d]*)(,[가-힣]{1,}-[1-9][0-9]{0,})*";
    Pattern pattern = Pattern.compile(regex);

    @ParameterizedTest
    @DisplayName("정규식 표현 패턴 확인용도-성공")
    @ValueSource(strings = {"아이스크림-1","제로콜라-3,타파스-2"})
    void checkRegexPatternSuccess(String value) {
        assertThat(pattern.matcher(value).matches()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("정규식 표현 패턴 확인용도-실패")
    @ValueSource(strings = {"아이스크림-0","제로콜라-3,,타파스-2","제로콜라-3,","제로콜라-3-,타파스-2",
            "타파스- 2"})
    void checkRegexPatternFail(String value) {
        assertThat(pattern.matcher(value).matches()).isFalse();
    }

    @ParameterizedTest
    @DisplayName("주문 형식 패턴 성공")
    @ValueSource(strings = {
            "아이스크림-4",
            "아이스크림-3,제로콜라-3",
            "테스트-5","아이스크림-5,제로콜라-4",
            "양송이수프-3",
            "제로콜라-3,양송이수프-1,타파스-5,레드와인-1"
    })
    void patternSuccess(String value) {
        assertDoesNotThrow(() -> OrderFormatPattern.matches(value));
    }

    @ParameterizedTest
    @DisplayName("주문 형식 패턴 실패")
    @ValueSource(strings = {
            "",
            "아이스크림-4,제로콜라-2,",
            "타파스-4,",
            "아이스크림-4,,,양송이수프-3",
            "제로콜라3",
            "-양송이수프-3",
            "타파스-5-",
            "레드와인5-",
            "234-42",
            "레드4-2",
            "메뉴-24개수",
            ",타파스-3",
            "제로콜라-3,,타파스-1",
            "메뉴 -2",
            "메뉴- 3",
            "메뉴 - 3",
            "메뉴 - 3,",
            "메뉴"
    })
    void patternFail(String value) {
        assertThrows(IllegalArgumentException.class,
                () -> OrderFormatPattern.matches(value));
    }


}