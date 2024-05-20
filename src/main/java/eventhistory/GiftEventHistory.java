package eventhistory;

import food.Food;
import money.Cost;
import money.UnmodifiedMoney;

public class GiftEventHistory implements EventHistory {

    private final Food gift;

    public GiftEventHistory() {
        gift = null;
    }

    public GiftEventHistory(Food gift) {
        this.gift = gift;
    }

    @Override
    public String getName() {
        return "증정 이벤트";
    }

    @Override
    public Food getBenefit() {
        return gift;
    }

    @Override
    public UnmodifiedMoney getBenefitValue() {
        if(gift == null) return new Cost(0);
        return gift.getCost();
    }
}
