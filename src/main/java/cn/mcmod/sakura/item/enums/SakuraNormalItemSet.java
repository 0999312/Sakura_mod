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
    RICE("rice"),
    SALT("salt"),
    FLOUR("flour"),
    FLOUR_BUCKWHEAT("flour_buckwheat"),
    FLOUR_RICE("flour_rice"),
    DOUGH("dough"),
    DOUGH_BUCKWHEAT("dough_buckwheat"),
    DOUGH_RICE("dough_rice"),
    SOYSAUCE("soysauce"),
    MISO("miso"),
    TEMPURA_BATTER("tempura_batter");
    private final String name;
    private SakuraNormalItemSet(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
