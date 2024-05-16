package eventhistory;

public class WeekDayDiscountEventHistory implements EventHistory {

    private final Integer discount;

    public WeekDayDiscountEventHistory(Integer discountCost) {
        this.discount = discountCost;
    }

    @Override
    public String getName() {
        return "평일 할인";
    }

    @Override
    public Integer getBenefit() {
        return discount;
    }

    @Override
    public Integer getBenefitValue() {
        return discount;
    }
}