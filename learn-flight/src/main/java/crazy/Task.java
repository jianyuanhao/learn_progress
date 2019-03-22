package crazy;


public enum Task {
    FIND_BUG(0.5, "查个小问题!"),
    BUG_FIXING(0.5, "修个小问题!"),
    SMALL_PRODUCT(1, "做个小需求!"),
    BIG_PRODUCT(50, "做个大需求!"),
    TECH_REQUIREMENT(50, "技术大需求");
    double level;
    String desc;

    Task(double level, String desc) {
        this.level = level;
        this.desc = desc;
    }

    public double getLevel() {
        return level;
    }

    public String getDesc() {
        return desc;
    }
}
