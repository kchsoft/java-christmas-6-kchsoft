package christmas;

import static christmas.Constant.MsgConstantPiece.EMPTY_STRING;

import Event.EventHistory;
import Event.Gift.GiftEventHistory;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<EventHistory> history;

    public Receipt(){
        history = new ArrayList<>();
    }

    public void addHistory(EventHistory eventHistory){
        history.add(eventHistory);
    }

    public Money getDiscountAmount(){
        Money discountAmount = new Money();

        for (EventHistory oneHistory : history) {
            if( oneHistory == null || !(oneHistory.getBenefit() instanceof Money)){
                continue;
            }
            discountAmount.add((Money)oneHistory.getBenefit());
        }
        return discountAmount;
    }

    public Money getGiftAmount(){
        Money giftAmount = new Money();
        Menu giftMenu = findGiftMenu();
        if (giftMenu == null) {
            return new Money();
        }
        return new Money(giftMenu.getPriceValue());
    }

    public String getGiftName(){
        Money giftAmount = new Money();
        Menu giftMenu = findGiftMenu();
        if (giftMenu == null) {
            return null;
        }
        return giftMenu.getName();
    }

    private Menu findGiftMenu(){
        for (EventHistory oneHistory : history) {
            if( oneHistory == null ){
                continue;
            }
            if (oneHistory instanceof GiftEventHistory) {
                return (Menu) oneHistory.getBenefit();
            }
        }
        return null;
    }

    public List<EventHistory> getHistory(){
        return new ArrayList<>(history);
    }

    public EventHistory getHistory(String eventName){
        for (EventHistory oneHistory : history) {
            if (oneHistory == null) {
                continue;
            }
            if (oneHistory.explainName().equals(eventName)) {
                return oneHistory;
            }
        }
        return null;
    }

}
