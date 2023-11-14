package Event;

public interface EventHistory<T> {

    String explainName();
    String explainBenefit();
    T getBenefit();

}
