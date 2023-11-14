package Event.Badge;

import Event.EventHistory;

public class BadgeEventHistory implements EventHistory<String> {

    private final String eventName;
    private final String badge;

    public BadgeEventHistory(String eventName,String badge){
        this.eventName = eventName;
        this.badge = badge;
    }

    @Override
    public String explainName() {
        return eventName;
    }

    @Override
    public String explainBenefit() {
        return badge;
    }

    @Override
    public String getBenefit() {
        return badge;
    }

}
