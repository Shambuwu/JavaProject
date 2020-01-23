/**
 * The stats for all enemies are written here.
 * Every enemy has 3 stats. from left to right they are:
 * Health, Strength, speed
 */

public enum EnemyStats{
    GOBLIN(15, 2, 5, Dialogue.enemy[Game.gameLanguage][0], 20),
    KOBOLD(20, 3, 4, Dialogue.enemy[Game.gameLanguage][1], 30),
    OGRE(50, 13, 1, Dialogue.enemy[Game.gameLanguage][2], 100),
    GNOLL(40, 7, 9, Dialogue.enemy[Game.gameLanguage][3], 60),
    WARRIOR(100, 15, 8, Dialogue.boss[Game.gameLanguage][0], 300),
    KING(130, 9, 4, Dialogue.boss[Game.gameLanguage][1], 300),
    DEMON(50, 30, 10, Dialogue.boss[Game.gameLanguage][2], 300);

    private int health;
    private int strength;
    private int speed;
    private String name;
    private int xpValue;

    EnemyStats(int health, int strength, int speed, String name, int xp){
        this.health = (int) (health * Game.gameDifficulty.getDifficulty());
        this.strength = (int) (strength * Game.gameDifficulty.getDifficulty());
        this.speed = (int) (speed * Game.gameDifficulty.getDifficulty());
        this.name = name;
        this.xpValue = (int) (xp * Game.gameDifficulty.getDifficulty());
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
    
    public int getXPValue(){
        return xpValue;
    }
}