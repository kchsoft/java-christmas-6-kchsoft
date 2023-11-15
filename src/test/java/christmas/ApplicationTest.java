package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.Constant.ErrorMsgConstant.ERROR_EXCEED_MAX_ORDER_NUMBER;
import static christmas.Constant.ErrorMsgConstant.ERROR_NOT_VALID_DAY;
import static christmas.Constant.ErrorMsgConstant.ERROR_NOT_VALID_ORDER;
import static christmas.Constant.ErrorMsgConstant.ERROR_ONLY_BEVERAGE_ORDER_NOT_ALLOW;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("음료만 주문하면 예외 발생")
    @Test
    public void createOnlyBeverageOrder(){
        assertSimpleTest(() -> {
            runException("3", "제로콜라-3,레드와인-4");
            assertThat(output()).contains(ERROR_ONLY_BEVERAGE_ORDER_NOT_ALLOW);
        });
    }

    @DisplayName("주문 개수가 20개가 넘어가면 예외 발생")
    @Test
    public void createOverOrder(){
        assertSimpleTest(() -> {
            runException("3", "제로콜라-30,해산물파스타-20");
            assertThat(output()).contains(ERROR_EXCEED_MAX_ORDER_NUMBER);
        });
    }

    @DisplayName("공백 입력시 예외 발생")
    @Test
    public void createEmptyInput(){
        assertSimpleTest(() -> {
            runException("", "제로콜라-3,초코케이크-20");
            assertThat(output()).contains(ERROR_NOT_VALID_DAY);
        });
    }

    @DisplayName("날짜 입력 범위를 벗어나면 예외 발생")
    @Test
    public void createOverRangeDay(){
        assertSimpleTest(() -> {
            runException("32", "초코케이크-5,레드와인-2");
            assertThat(output()).contains(ERROR_NOT_VALID_DAY);
        });
    }

    @DisplayName("메뉴 입력 형식이 벗어나면 예외 발생")
    @Test
    public void createIllegalMenuFormat(){
        assertSimpleTest(() -> {
            runException("13", "초코케이크-5 레드와인-2");
            assertThat(output()).contains(ERROR_NOT_VALID_ORDER);
        });
    }

    @DisplayName("중복 메뉴 입력시 예외 발생")
    @Test
    public void createDuplicatedMenu(){
        assertSimpleTest(() -> {
            runException("3", "제로콜라-1,제로콜라-4");
            assertThat(output()).contains(ERROR_NOT_VALID_ORDER);
        });
    }
    
    @DisplayName("없는 메뉴 주문시 예외 발생")
    @Test
    public void createNotExistMenu(){
        assertSimpleTest(() -> {
            runException("3", "김밥-3");
            assertThat(output()).contains(ERROR_NOT_VALID_ORDER);
        });
    }

    @DisplayName("메뉴 개수가 1 미만이면 예외 발생")
    @Test
    public void createUnderMinOrder(){
        assertSimpleTest(() -> {
            runException("3", "아이스크림-0");
            assertThat(output()).contains(ERROR_NOT_VALID_ORDER);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
