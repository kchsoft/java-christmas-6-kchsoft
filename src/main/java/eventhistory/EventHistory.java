package eventhistory;

import money.UnmodifiedMoney;

public interface EventHistory {
    public String getName();

    public Object getBenefit();

    public UnmodifiedMoney getBenefitValue();
}
