public enum EnemyStats{
    GOBLIN(15, 2, 5, Dialogue.enemy[Game.gameLanguage][0]),
    KOBOLD(20, 3, 4, Dialogue.enemy[Game.gameLanguage][1]),
    OGRE(50, 13, 1, Dialogue.enemy[Game.gameLanguage][2]),
    GNOLL(40, 7, 9, Dialogue.enemy[Game.gameLanguage][3]);

    private int health;
    private int strength;
    private int speed;
    private String name;

    EnemyStats(int health, int strength, int speed, String name){
        this.health = (int) (health * Game.gameDifficulty.getDifficulty());
        this.strength = (int) (strength * Game.gameDifficulty.getDifficulty());
        this.speed = (int) (speed * Game.gameDifficulty.getDifficulty());
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
        return name;
    }    
}