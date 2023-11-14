package Event.Badge;

import static Event.Constant.EventConstant.SANTA;
import static Event.Constant.EventConstant.STAR;
import static Event.Constant.EventConstant.TREE;
import static Event.Constant.EventNameConstant.DECEMBER_EVENT_BADGE;

import Event.Event;
import Event.EventHistory;
import christmas.Money;
import christmas.Receipt;

public class BadgeEvent implements Event<Receipt> {

    private final Integer SANTA_AMOUNT = 20000;
    private final Integer TREE_AMOUNT = 10000;
    private final Integer STAR_AMOUNT = 5000;


    public BadgeEvent(){
    }

    @Override
    public EventHistory apply(Receipt receipt) {
        Money benefitAmount = new Money();

        benefitAmount.add(receipt.getDiscountAmount());
        benefitAmount.add(receipt.getGiftAmount());
        String badge = setBadge(benefitAmount);

        if(badge == null){
            return null;
        }

        return new BadgeEventHistory(DECEMBER_EVENT_BADGE, badge);
    }

    private String setBadge(Money benefitAmount){
        if (benefitAmount.getAmount() >= SANTA_AMOUNT) {
            return SANTA;
        }
        if (benefitAmount.getAmount() >= TREE_AMOUNT) {
            return TREE;
        }
        if (benefitAmount.getAmount() >= STAR_AMOUNT) {
            return STAR;
        }
        return null;
    }

}
