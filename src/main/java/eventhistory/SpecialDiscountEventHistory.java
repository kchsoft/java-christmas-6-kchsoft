package eventhistory;

public class SpecialDiscountEventHistory implements EventHistory {
    private final Integer discount;

    public SpecialDiscountEventHistory(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String getName() {
        return "특별 할인";
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
