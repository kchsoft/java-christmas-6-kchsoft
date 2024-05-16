package christmas;

public enum Badge {
    STAR(5000,"별"),
    TREE(10000,"트리"),
    SANTA(20000,"산타");

    private final Integer badgeBaseCost;
    private final String name;

    Badge(Integer badgeBaseCost, String name) {
        this.badgeBaseCost = badgeBaseCost;
        this.name = name;
    }

    public Integer getBaseCost() {
        return badgeBaseCost;
    }

    public String getName() {
        return name;
    }

}