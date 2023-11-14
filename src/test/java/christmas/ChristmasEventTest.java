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
    void setVisitingDay(){
        visitingDay = LocalDate.of(EVENT_YEAR,EVENT_MONTH,14); // Random day
    }

    @DisplayName("입력한 요일과 날짜를 올바르게 반환하는지 확인")
    @Test
    void checkReturnDayAndDate() {
        assertThat(visitingDay.getYear()).isEqualTo(EVENT_YEAR);
        assertThat(visitingDay.getMonth()).isEqualTo(Month.DECEMBER);
        assertThat(visitingDay.getDayOfMonth()).isEqualTo(14);
        assertThat(visitingDay.getDayOfWeek()).isEqualTo(DayOfWeek.THURSDAY);
    }

}