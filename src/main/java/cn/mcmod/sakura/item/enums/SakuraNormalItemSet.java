package cn.mcmod.sakura.item.enums;

public enum SakuraNormalItemSet {
    BAMBOO("bamboo"),
    BAMBOO_SUNBURNT("bamboo_sunburnt"),
    BAMBOO_CHARCOAL("bamboo_charcoal"),
    LUMBER_BAMBOO("lumber_bamboo"),
    LUMBER_SAKURA("lumber_sakura"),
    LUMBER_MAPLE("lumber_maple"),
    STRAW("straw"),
    IMOGARA("imogara"),
    BROWN_RICE("brown_rice"),
    RICE("rice");
    private final String name;
    private SakuraNormalItemSet(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
