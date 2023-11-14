package Event;

import static Event.EventNameConstant.GIFT_EVENT;

import christmas.Menu;
import christmas.Money;
import christmas.Order;
import java.util.ArrayList;
import java.util.List;

public class GiftEvent implements Event<Order>{

    private final Integer BASE_AMOUNT_OF_GIFT = 120000;
    private Menu gift;

    public GiftEvent(){
        gift = Menu.CHAMPAGNE;
    }

    @Override
    public EventHistory apply(Order order) {
        Money originalMoney = order.sumOrderPrice();
        if (originalMoney.getAmount() >= BASE_AMOUNT_OF_GIFT) {
            return new GiftEventHistory(GIFT_EVENT, gift);
        }
        return null;
    }

}
