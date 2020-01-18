public enum Potions{
    HEALTH_POT(10, "Health Potion", 0),
    HEALTH_POT_STRONG(15, "Stronger Health Potion", 0),
    HEALTH_POT_ULTRA(20, "Ultra Health Potion", 0),
    STRENGTH_POT(3 ,"Potion of Strength", 1),
    STRENGTH_POT_STRONG(5, "Stronger Potion of Health", 1),
    STRENGTH_POT_ULTRA(7, "Ultra Potion of Strength", 1);

    private int value;
    private String name;
    private int type;
    Potions(int value, String name, int type){
        this.value = value;
        this.name = name;
        this.type = type;
    }

    public int getPotionValue(){
        return value;
    }

    public String getPotionName(){
        return name;
    }

    public int getType(){
        return type;
    }
}