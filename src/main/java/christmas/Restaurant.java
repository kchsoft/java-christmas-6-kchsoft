package christmas;

import static Event.Constant.EventConstant.EVENT_MONTH;
import static Event.Constant.EventConstant.EVENT_YEAR;
import static christmas.Constant.MsgConstantPiece.COMMA;
import static christmas.Constant.MsgConstantPiece.DASH;

import View.InputView;
import camp.nextstep.edu.missionutils.Console;
import java.time.LocalDate;

public class Restaurant {

    public LocalDate expectVisitngDay(){

        Integer date = InputView.readVisitingDay();
        return setVisitingDay(date);
    }

    private LocalDate setVisitingDay(Integer date){
        return LocalDate.of(EVENT_YEAR,EVENT_MONTH,date);
    }

    public Order orderMenu(LocalDate visitingDay){
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1");
        String orderMenu = Console.readLine();
        String[] orderMenus = orderMenu.split(COMMA);
        Order order = new Order(visitingDay);

        for (String oneMenu : orderMenus) {
            String[] orderFormat = oneMenu.split(DASH);
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
