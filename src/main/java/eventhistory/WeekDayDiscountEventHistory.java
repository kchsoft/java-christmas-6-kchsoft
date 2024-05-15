package eventhistory;

public class WeekDayDiscountEventHistory implements EventHistory {

    private final Integer discontCost;

    public WeekDayDiscountEventHistory(Integer discountCost) {
        this.discontCost = discountCost;
    }

    @Override
    public String getName() {
        return "평일 할인";
    }

    @Override
    public Integer getBenefit() {
        return discontCost;
    }
}