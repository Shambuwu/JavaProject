public enum EnemyStats{
    GOBLIN(30, 4, 5, new String[] {"Goblin", "Aardmannetje"}),
    KOBOLD(40, 6, 4, new String[] {"Kobold", "Kabouter"}),
    OGRE(80, 7, 1, new String[] {"Ogre", "Oger"}),
    GNOLL(40, 5, 9, new String[] {"Gnoll", "Gnoll"});

    private int health;
    private int strength;
    private int speed;
    private String[] name;

    EnemyStats(int health, int strength, int speed, String[] name){
        this.health = health;
        this.strength = strength;
        this.speed = speed;
        this.name = name;
    }

    public int getHealth(){
        return health;
    }

    public int getStrength(){
        return strength;
    }

    public int getSpeed(){
        return speed;
    }

    public String getName(int gameLanguage){
        return name[gameLanguage];
    }    
}