package eventhistory;

import christmas.Badge;

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
    public Integer getBenefitValue() {
        return badge.getBaseCost();
    }

}