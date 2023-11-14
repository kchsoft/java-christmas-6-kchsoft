package Event.Gift;

import static Event.Constant.EventNameConstant.GIFT_EVENT;

import Event.Event;
import Event.EventHistory;
import christmas.Menu;
import christmas.Money;
import christmas.Order;

public class GiftEvent implements Event<Order> {

    private final Integer BASE_AMOUNT_OF_GIFT = 120000;
    private Menu gift;

    public GiftEvent(){
        gift = Menu.CHAMPAGNE;
    }

    @Override
    public EventHistory apply(Order order) {
        Money originalMoney = order.sumPrice();
        if (originalMoney.getAmount() >= BASE_AMOUNT_OF_GIFT) {
            return new GiftEventHistory(GIFT_EVENT, gift);
        }
        return null;
    }

}
