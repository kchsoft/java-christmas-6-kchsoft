package eventhistory;

public class WeekendDiscountEventHistory implements EventHistory{

    private final Integer discountCost;

    public WeekendDiscountEventHistory(Integer discount) {
        this.discountCost = discount;
    }

    @Override
    public String getName() {
        return "주말 할인";
    }

    @Override
    public Integer getBenefit() {
        return discountCost;
    }
}