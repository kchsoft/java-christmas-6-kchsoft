package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.EventConstant.EVENT_MONTH;
import static christmas.EventConstant.EVENT_YEAR;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Calendar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChristmasEventTest {

    @DisplayName("입력한 요일과 날짜를 올바르게 반환하는지 확인")
    @Test
    void checkReturnDayAndDate(){
        Calendar visitingDay = Calendar.getInstance();
        visitingDay.set(Calendar.YEAR, EVENT_YEAR);
        visitingDay.set(Calendar.MONTH, EVENT_MONTH-1); // 0 is january
        visitingDay.set(Calendar.DAY_OF_MONTH, 14); // Random Date

        assertThat(visitingDay.get(Calendar.YEAR)).isEqualTo(EVENT_YEAR);
        assertThat(visitingDay.get(Calendar.MONTH)).isEqualTo(Calendar.DECEMBER);
        assertThat(visitingDay.get(Calendar.DAY_OF_MONTH)).isEqualTo(14);
        assertThat(visitingDay.get(Calendar.DAY_OF_WEEK)).isEqualTo(Calendar.THURSDAY);
    }

}