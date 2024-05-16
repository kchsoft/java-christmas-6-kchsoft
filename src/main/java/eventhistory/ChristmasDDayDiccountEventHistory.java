package eventhistory;

public class ChristmasDDayDiccountEventHistory implements EventHistory{
    private final Integer discountCost;

    public ChristmasDDayDiccountEventHistory(Integer discountCost) {
        this.discountCost = discountCost;
    }

    @Override
    public String getName() {
        return "크리스마스 디데이 할인";
    }

    @Override
    public Integer getBenefit() {
        return discountCost;
    }

    @Override
    public Integer getBenefitValue() {
        return discountCost;
    }

}
