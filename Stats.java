/**
 * This class creates all ingame classess.
 * The stats from left to right are:
 * Health, Strength, Speed.
 */

public enum Stats{
    KNIGHT(70, 6, 4, Dialogue.player[Game.gameLanguage][0]),
    ASSASSIN(40, 9, 7, Dialogue.player[Game.gameLanguage][1]),
    MAGE(35, 13, 4, Dialogue.player[Game.gameLanguage][2]);

    private int health;
    private int strength;
    private int speed;
    private String name;

    Stats(int health, int strength, int speed, String name) {
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
        return name;
    }
}