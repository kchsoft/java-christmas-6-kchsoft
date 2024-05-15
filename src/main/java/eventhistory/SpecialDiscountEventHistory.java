package eventhistory;

public class SpecialDiscountEventHistory implements EventHistory {
    private final Integer discountCost;

    public SpecialDiscountEventHistory(Integer discount) {
        this.discountCost = discount;
    }

    @Override
    public String getName() {
        return "특별 할인";
    }

    @Override
    public Integer getBenefit() {
        return discountCost;
    }
}
