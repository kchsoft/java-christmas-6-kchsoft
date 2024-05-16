package eventhistory;

import food.Food;

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
    public Integer getBenefitValue() {
        if(gift == null) return 0;
        return gift.getCost();
    }
}
