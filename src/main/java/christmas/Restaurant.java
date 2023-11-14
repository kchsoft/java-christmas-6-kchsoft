package christmas;

import static christmas.EventConstant.EVENT_MONTH;
import static christmas.EventConstant.EVENT_YEAR;

import camp.nextstep.edu.missionutils.Console;
import java.time.LocalDate;

public class Restaurant {

    public LocalDate expectVisitngDay(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n"
                + "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        Integer date = Integer.valueOf(Console.readLine());
        return setVisitingDay(date);
    }

    private LocalDate setVisitingDay(Integer date){
        return LocalDate.of(EVENT_YEAR,EVENT_MONTH,date);
    }

}
