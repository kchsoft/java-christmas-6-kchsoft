package restaurant;

import money.Cost;
import money.UnmodifiedMoney;

public enum Badge {
    STAR(new Cost(5000),"별"),
    TREE(new Cost(10000),"트리"),
    SANTA(new Cost(20000),"산타");

    private final UnmodifiedMoney badgeBaseCost;
    private final String name;

    Badge(UnmodifiedMoney badgeBaseCost, String name) {
        this.badgeBaseCost = badgeBaseCost;
        this.name = name;
    }

    public UnmodifiedMoney getBaseCost() {
        return badgeBaseCost;
    }

    public String getName() {
        return name;
    }

    public Integer getIntValue() {
        return badgeBaseCost.getIntValue();
    }

}