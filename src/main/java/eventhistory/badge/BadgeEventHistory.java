package eventhistory.badge;

import eventhistory.EventHistory;
import restaurant.Badge;
import money.UnmodifiedMoney;

public class BadgeEventHistory implements EventHistory {
    private final Badge badge;
    public BadgeEventHistory(Badge badge) {
        this.badge = badge;
    }

    @Override
    public String getName() {
        return badge.getName();
    }

    @Override
    public Badge getBenefit() {
        return badge;
    }

    @Override
    public UnmodifiedMoney getBenefitValue() {
        return badge.getBaseCost();
    }

}