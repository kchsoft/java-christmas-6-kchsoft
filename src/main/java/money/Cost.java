package money;

import java.util.Objects;

public class Cost implements UnmodifiedMoney {

    private final Integer cost;

    public Cost(Integer cost) {
        this.cost = cost;
    }

    public Integer getIntValue() {
        return cost;
    }

    @Override
    public String toString() {
        Integer balance = cost;
        String annotation = "원";
        while (balance >= 1000) {
            annotation = calToString(balance, annotation);
            balance /= 1000;
        }
        return balance + annotation;
    }

    private String calToString(Integer balance, String annotation) {
        Integer rear;
        for (Integer index = 0; index < 3; index++) {
            rear = balance % 10;
            balance = balance / 10;
            annotation = rear + annotation;
        }
        return "," + annotation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost1 = (Cost) o;
        return Objects.equals(cost, cost1.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost);
    }
}