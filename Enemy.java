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

    public Enemy(EnemyStats enemyStats){
        this.health = enemyStats.getHealth();
        this.strength = enemyStats.getStrength();
        this.speed = enemyStats.getSpeed();
        this.enemyType = enemyStats.getName(0);
        this.xpValue = enemyStats.getXPValue();
    }

    public String getType(){
        return enemyType;
    }

    public int getStrength(){
        return strength;
    }
    
    public void setEnemyDamage(int damage){
        health -= damage;
    }

    public int getEnemyHealth(){
        return health;
    }

    public int getXPValue(){
        return xpValue;
    }
}