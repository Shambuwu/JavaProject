/**
 * This class creates all ingame classess.
 * The stats from left to right are:
 * Health, Strength, Speed.
 */

public enum Stats{
    KNIGHT(40, 7, 4, Dialogue.player[Game.gameLanguage][0]),
    ASSASSIN(30, 11, 7, Dialogue.player[Game.gameLanguage][1]),
    MAGE(25, 13, 4, Dialogue.player[Game.gameLanguage][2]);

    private int health;
    private int strength;
    private int speed;
    private String name;

    /**
     * sets all stats variables
     * @param health sets the health stats
     * @param strength sets the strength stats
     * @param speed sets the speed stats
     * @param name sets the name stats
     */
    Stats(int health, int strength, int speed, String name) {
        this.health = health;
        this.strength = strength;
        this.speed = speed;
        this.name = name;
    }

    /**
     * returns health stats
     * @return returns an int
     */
    public int getHealth(){
        return health;
    }

    /**
     * returns strength stats
     * @return returns an int
     */
    public int getStrength(){
        return strength;
    }

    /**
     * returns speed stats
     * @return returns an int
     */
    public int getSpeed(){
        return speed;
    }

    /**
     * returns the stats names
     * @param gameLanguage which language the stats name should be in
     */
    public String getName(int gameLanguage){
        return name;
    }
}