package christmas;

import Event.EventHistory;
import Event.Gift.GiftEventHistory;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private Order order;
    private List<EventHistory> history;

    public Receipt(Order order){
        this.order = order;
        history = new ArrayList<>();
    }

    public void addHistory(EventHistory eventHistory){
        history.add(eventHistory);
    }

    public Money getDiscountAmount(){
        Money discountAmount = new Money();

        for (EventHistory oneHistory : history) {
            if( oneHistory == null || oneHistory instanceof GiftEventHistory){
                continue;
            }
            discountAmount.add((Money)oneHistory.getBenefit());
        }
        return discountAmount;
    }

    public Money getGiftAmount(){
        Money giftAmount = new Money();

        for (EventHistory oneHistory : history) {
            if( oneHistory == null ){
                continue;
            }
            if (oneHistory instanceof GiftEventHistory) {
                Menu giftMenu = (Menu)oneHistory.getBenefit();
                return new Money(giftMenu.getPriceValue());
            }
        }
        return new Money();
    }

}
