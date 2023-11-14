package christmas;

import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_YEAR;

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

    public Order orderMenu(LocalDate visitingDay){
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1");
        String orderMenu = Console.readLine();
        String[] orderMenus = orderMenu.split(",");
        Order order = new Order(visitingDay);

        for (String oneMenu : orderMenus) {
            String[] orderFormat = oneMenu.split("-");
            Menu menu = findMenu(orderFormat);
            order.addMenu(menu,Integer.valueOf(orderFormat[1]));
        }
        return order;
    }

    private Menu findMenu(String[] orderFormat){
        for(Menu menu : Menu.values()){
            if(menu.getName().equals(orderFormat[0])) {
                return menu;
            }
        }
        return null;
    }

}
