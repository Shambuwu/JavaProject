/**
 * creates all potions
 */


public enum Potions{
    HEALTH_POT(10, Dialogue.item[Game.gameLanguage][0], 0),
    HEALTH_POT_STRONG(15, Dialogue.item[Game.gameLanguage][1], 0),
    HEALTH_POT_ULTRA(20, Dialogue.item[Game.gameLanguage][2], 0),
    STRENGTH_POT(3 ,Dialogue.item[Game.gameLanguage][3], 1),
    STRENGTH_POT_STRONG(5, Dialogue.item[Game.gameLanguage][4], 1),
    STRENGTH_POT_ULTRA(7, Dialogue.item[Game.gameLanguage][5], 1);

    private int value;
    private String name;
    private int type;

    /**
     * this sets all Potions values
     * @param value the potion value
     * @param name the potion name
     * @param type the potion type
     */
    Potions(int value, String name, int type){
        this.value = value;
        this.name = name;
        this.type = type;
    }

    /**
     * returns the potion value
     * @return returns an int
     */
    public int getPotionValue(){
        return value;
    }

    /**
     * returns the potion name
     * @return returns a string
     */
    public String getPotionName(){
        return name;
    }

    /**
     * returns the potion type
     * @return returns an int
     */
    public int getType(){
        return type;
    }
}