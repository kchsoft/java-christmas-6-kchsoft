package eventhistory;

public class WeekendDiscountEventHistory implements EventHistory{

    private final Integer discount;

    public WeekendDiscountEventHistory(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String getName() {
        return "주말 할인";
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