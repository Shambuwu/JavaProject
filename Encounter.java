import java.util.Random;
import java.util.Scanner;

public class Encounter{
    private Player player;
    private EnemyStats enemyStats;
    private Enemy enemy;
    private Stats playerStats;
    Scanner scanner = new Scanner(System.in);

    Random rand = new Random();

    public Encounter(Player player){
        this.player = player;
        this.playerStats = player.getPlayerStats();
        int randomEnemy = rand.nextInt(100);
        if(randomEnemy < 40){
            enemyStats = EnemyStats.GOBLIN;
            enemy = new Enemy(enemyStats);
            System.out.println("You encounter a " + enemyStats.getName(0));
        } else if(randomEnemy >= 40 && randomEnemy < 70){
            enemyStats = EnemyStats.KOBOLD;
            enemy = new Enemy(enemyStats);
            System.out.println("You encounter a " + enemyStats.getName(0));
        } else if(randomEnemy >= 70 && randomEnemy < 90){
            enemyStats = EnemyStats.GNOLL;
            enemy = new Enemy(enemyStats);
            System.out.println("You encounter a " + enemyStats.getName(0));
        } else if(randomEnemy >= 90){
            enemyStats = EnemyStats.OGRE;
            enemy = new Enemy(enemyStats);
            System.out.println("You encounter an " + enemyStats.getName(0));
        }
        System.out.println("Your health is: " + player.getPlayerHealth());
        System.out.println("Their health is: " + enemy.getEnemyHealth());
        encounterStart();
    }

    public boolean encounterStart(){
        boolean hasWonFight = false;

        while(hasWonFight == false){
            playerChoice();
            System.out.println("Their health is: " + enemy.getEnemyHealth());
            if(enemy.getEnemyHealth() <= 0){
                System.out.println("You kill the " + enemy.getType());
                hasWonFight = true;
            }    
            enemyChoice();
            System.out.println("Your health is: " + player.getPlayerHealth()); 
        }

        System.out.println("You gain 20xp!");
        scanner.nextLine();
        return true;
    }

    public void playerChoice(){
        System.out.println("What will you do?");
        System.out.println("1. Attack");
        System.out.println("2. Run");
        System.out.print("> ");
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                enemy.setEnemyDamage(player.getPlayerStrength());
                System.out.println("You hit the " + enemy.getType() + " for " + player.getPlayerStrength() + " damage!");
                scanner.nextLine();
                break;
            default:
                System.out.println("Invalid answer!");
                playerChoice();
        }
    }

    public void enemyChoice(){
        System.out.println("The " + enemy.getType() + " strikes!");
        player.setPlayerDamage(enemy.getStrength());
        scanner.nextLine();
    }
}