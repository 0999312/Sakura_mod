package cn.mcmod.sakura.item.enums;

public enum SakuraNormalItemSet {
    BAMBOO("bamboo"),
    BAMBOO_SUNBURNT("bamboo_sunburnt"),
    BAMBOO_CHARCOAL("bamboo_charcoal"),
    LUMBER_BAMBOO("lumber_bamboo"),
    LUMBER_SAKURA("lumber_sakura"),
    LUMBER_MAPLE("lumber_maple"),
    STRAW("straw"),
    CHARCOAL_POWDER("charcoal_powder"),
    SALT("salt"),
    ALKALINE("alkaline"),
    IMOGARA("imogara"),
    BROWN_RICE("brown_rice"),
    RICE("rice"),
    FLOUR("flour"),
    FLOUR_BUCKWHEAT("flour_buckwheat"),
    FLOUR_RICE("flour_rice"),
    DOUGH("dough"),
    DOUGH_BUCKWHEAT("dough_buckwheat"),
    DOUGH_RICE("dough_rice"),
    KOUJI("kouji"),
    SOYSAUCE("soysauce"),
    DASHI("dashi"),
    MISO("miso"),
    MIRIN("mirin"),
    SAKE_KASU("sake_kasu"),
    TEMPURA_BATTER("tempura_batter"),
    MOLASSES("molasses"),
    YEAST("yeast"),
    KAESHI("kaeshi"),
    NOODLE_SOUP("noodle_soup"),;
    private final String name;
    private SakuraNormalItemSet(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
