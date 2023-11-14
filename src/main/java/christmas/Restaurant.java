package christmas;

import static christmas.EventConstant.EVENT_MONTH;
import static christmas.EventConstant.EVENT_YEAR;

import camp.nextstep.edu.missionutils.Console;
import java.util.Calendar;

public class Restaurant {

    public void expectVisitngDay(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n"
                + "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        Integer date = Integer.valueOf(Console.readLine());
        Calendar visitingDay = setVisitingDay(date);
    }

    private Calendar setVisitingDay(Integer date){
        Calendar day = Calendar.getInstance();
        day.set(Calendar.YEAR, EVENT_YEAR);
        day.set(Calendar.MONTH, EVENT_MONTH-1); // 0 is january
        day.set(Calendar.DAY_OF_MONTH, date);
        return day;
    }

}
