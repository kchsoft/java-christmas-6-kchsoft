package christmas;

import static Event.Constant.EventConstant.EVENT_BASE_AMOUNT;

import Event.ChristmasEvent;
import View.InputView;
import View.OrderOutputView;
import View.ReceiptOutputView;
import christmas.Validator.OrderValidator;
import java.time.LocalDate;
import java.util.List;

public class Restaurant {

    public void startBusiness(){
        LocalDate visitingDay = setVisitngDay();
        Order order = orderMenu(visitingDay);
        Receipt receipt = applyChristmasEvent(order);
        showEventHistory(receipt,order);
    }

    private LocalDate setVisitngDay(){
        LocalDate date = null;
        while (date == null) {
            try {
                date = InputView.askVisitingDay();
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                date = null;
            }
        }
        return date;
    }

    private Order orderMenu(LocalDate visitingDay){
        List<String> orderMenus = null;
        Order order = new Order(visitingDay);
        while (orderMenus == null) {
            try {
                orderMenus = InputView.askMenu();
                order.addMenus(orderMenus);
                OrderValidator.checkOrderInfo(order);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                orderMenus = null;
            }
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
