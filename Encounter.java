import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
/**
 * This is where the combat takes place
 */
public class Encounter{
    private Player player;
    private EnemyStats enemyStats;
    private Enemy enemy;
    private Stats playerStats;
    Scanner scanner = new Scanner(System.in);

    Random rand = new Random();

    /**
     * Initiate an encounter with an enemy.
     * @param player this is required to get all player stats.
     * @param enemy this decides which enemy the player will encounter
     */
    public Encounter(Player player, Enemy enemy){
        this.player = player;
        this.playerStats = player.getPlayerStats();
        this.enemy = enemy;
        System.out.println(Dialogue.response[Game.gameLanguage][22] + enemy.getType() + "!");
        scanner.nextLine();
        System.out.println(Dialogue.response[Game.gameLanguage][24] + player.getPlayerHealth() + "/" + player.getPlayerMaxHealth());
        System.out.println(Dialogue.response[Game.gameLanguage][25] + enemy.getEnemyHealth() + "\n");
        encounterStart();
    }

    public boolean hasWonFight = false;
    /**
     * This starts the turnbased encounter with the given player and enemy.
     * @return returns a boolean.
     */    
    public boolean encounterStart(){
        while(hasWonFight == false){
            if(hasWonFight == false){
                playerChoice();
                if(enemy.getEnemyHealth() <= 0){
                    System.out.println(Dialogue.combat[Game.gameLanguage][0] + enemy.getType());
                    System.out.println("You gain " + enemy.getXPValue() + "xp!");
                    player.setPlayerXP(enemy.getXPValue());
                    hasWonFight = true;
                }
                scanner.nextLine();
            }
            if(hasWonFight == false){   
                enemyChoice();
                System.out.println(Dialogue.response[Game.gameLanguage][24] + player.getPlayerHealth() + "/" + player.getPlayerMaxHealth());
                if(player.getPlayerHealth() <= 0){
                    System.out.println(Dialogue.response[Game.gameLanguage][26]);
                    scanner.nextLine();
                    System.exit(0);
                    return false;
                }
                scanner.nextLine();
            }
        }

        if(rand.nextInt(100) > 49){
            Item item = new Item(Potions.HEALTH_POT);
            System.out.println(Dialogue.response[Game.gameLanguage][31] + item.getItemName() + "!");
            player.addInventoryItem(item);
        }
        scanner.nextLine();
        return true;
    }

    /**
     * This contains the choice the player makes. Attack or Run.
     */
    public void playerChoice(){
        int choice = 0;
        System.out.println(Dialogue.combat[Game.gameLanguage][1]);
        System.out.println("-----------------");
        System.out.println(Dialogue.combat[Game.gameLanguage][2]);
        System.out.println(Dialogue.combat[Game.gameLanguage][3]);
        System.out.print("> ");
        try {
            choice = scanner.nextInt();
         }
         catch (NumberFormatException e)
         {
            System.out.println(Dialogue.response[Game.gameLanguage][27]);
            playerChoice();
         }
        switch(choice){
            case 1:
                int damage = player.getPlayerStrength() + rand.nextInt(10);
                enemy.setEnemyDamage(damage);
                System.out.println(Dialogue.combat[Game.gameLanguage][4] + enemy.getType() + Dialogue.combat[Game.gameLanguage][5] + damage + Dialogue.combat[Game.gameLanguage][6]);
                System.out.println(Dialogue.response[Game.gameLanguage][25] + enemy.getEnemyHealth());
                scanner.nextLine();
                break;
            case 2:
                if(run() == true) hasWonFight = true;
                System.out.println("You gain " + 5 + "xp!");
                player.setPlayerXP(5);
                scanner.nextLine();
                break;
            default:
                System.out.println(Dialogue.response[Game.gameLanguage][18]);
                playerChoice();
        }
    }

    /**
     * This decides how much damage the enemy attack does.
     */
    private void enemyChoice(){
        int damage = enemy.getStrength() + rand.nextInt(10);
        System.out.println(Dialogue.combat[Game.gameLanguage][7] + enemy.getType() + Dialogue.combat[Game.gameLanguage][8]);
        System.out.println(Dialogue.combat[Game.gameLanguage][9] + damage + Dialogue.combat[Game.gameLanguage][10]);
        player.setPlayerDamage(damage);
        scanner.nextLine();
    }

    /**
     * This decides if the player may escape combat or not.
     */
    private boolean run(){
        System.out.println(Dialogue.combat[Game.gameLanguage][11]);
        scanner.nextLine();
        if(rand.nextInt(10) > 6){
            System.out.println(Dialogue.combat[Game.gameLanguage][12]);
            return true;
        } else {
            System.out.println(Dialogue.combat[Game.gameLanguage][13]);
            return false;
        }
    }
}