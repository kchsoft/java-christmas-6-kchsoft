package eventhistory;

public class WeekDayDiscountEventHistory implements EventHistory {

    private final Integer discountCost;

    public WeekDayDiscountEventHistory(Integer discountCost) {
        this.discountCost = discountCost;
    }

    @Override
    public String getName() {
        return "평일 할인";
    }

    @Override
    public Integer getBenefit() {
        return discountCost;
    }
}