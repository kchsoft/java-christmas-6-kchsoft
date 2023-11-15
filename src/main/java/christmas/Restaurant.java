package christmas;

import static Event.Constant.EventConstant.EVENT_BASE_AMOUNT;
import static christmas.Constant.MsgConstantPiece.DASH;

import Event.ChristmasEvent;
import View.InputView;
import View.OrderOutputView;
import View.ReceiptOutputView;
import christmas.Converter.Converter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Restaurant {

    public void startBusiness(){
        LocalDate visitingDay = setVisitngDay();
        Order order = orderMenu(visitingDay);
        Receipt receipt = applyChristmasEvent(order);
        showEventHistory(receipt,order);
    }

    private LocalDate setVisitngDay(){
        return InputView.askVisitingDay();
    }

    private Order orderMenu(LocalDate visitingDay){
        List<String> orderMenus = InputView.askMenu();
        Order order = new Order(visitingDay);

        for (String orderMenu : orderMenus) {
            List<String> nameAndNumber = Arrays.asList(orderMenu.split(DASH));
            Menu menu = Menu.findMenu(nameAndNumber.get(0));
            Integer number = Converter.convertStringToInt(nameAndNumber.get(1));
            order.addMenu(menu,number);
        }
        return order;
    }

    private Receipt applyChristmasEvent(Order order){
        Money originalPirce = order.sumPrice();
        if( originalPirce.getAmount() >= EVENT_BASE_AMOUNT){
            ChristmasEvent event = new ChristmasEvent();
            return event.applyAllEvent(order);
        }
        return new Receipt();
    }

    private void showEventHistory(Receipt receipt,Order order){
        OrderOutputView.showOrderHistory(order);
        ReceiptOutputView.showReceiptHistory(receipt,order);
    }

}
