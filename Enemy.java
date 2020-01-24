/** 
 * Whenever an "encounter" starts, the game will choose a random enemy that battles you.
 * The enemy that is chosen will be created here.
 */

public class Enemy{
    private String enemyType;
    private int health;
    private int strength;
    private int speed;
    private int xpValue;

    /**
     * this sets all enemy variables
     * @param enemyStats required to set all enemy variables.
     */
    public Enemy(EnemyStats enemyStats){
        this.health = enemyStats.getHealth();
        this.strength = enemyStats.getStrength();
        this.speed = enemyStats.getSpeed();
        this.enemyType = enemyStats.getName(0);
        this.xpValue = enemyStats.getXPValue();
    }

    /**
     * returns the enemy type
     * @return returns a string
     */
    public String getType(){
        return enemyType;
    }

    /**
     * returns the enemy strength value
     * @return returns an int
     */
    public int getStrength(){
        return strength;
    }
    
    /**
     * sets the enemy health
     * @param damage this is how much damage the player dealth
     */
    public void setEnemyDamage(int damage){
        health -= damage;
    }

    /**
     * returns the enemy health value
     * @return returns an int
     */
    public int getEnemyHealth(){
        return health;
    }

    /**
     * returns enemy XP value
     * @return returns an int
     */
    public int getXPValue(){
        return xpValue;
    }
}