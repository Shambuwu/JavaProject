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
        scanner.nextLine();
        System.out.println("Your health is: " + player.getPlayerHealth());
        System.out.println("Their health is: " + enemy.getEnemyHealth());
        if(encounterStart() == false){
            System.out.println("You die. Too bad.");
        }
    }

    public boolean hasWonFight = false;    
    public boolean encounterStart(){

        while(hasWonFight == false){
            if(hasWonFight == false){
                playerChoice();
                if(enemy.getEnemyHealth() <= 0){
                    System.out.println("You kill the " + enemy.getType());
                    hasWonFight = true;
                }
            }
            if(hasWonFight == false){   
                enemyChoice();
                System.out.println("Your health is: " + player.getPlayerHealth());
                if(player.getPlayerHealth() <= 0){
                    return false;
                }
            }
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
                System.out.println("Their health is: " + enemy.getEnemyHealth());
                scanner.nextLine();
                break;
            case 2:
                if(run() == true) hasWonFight = true;
                scanner.nextLine();
                break;
            default:
                System.out.println("Invalid answer!");
                playerChoice();
        }
    }

    private void enemyChoice(){
        System.out.println("The " + enemy.getType() + " strikes!");
        player.setPlayerDamage(enemy.getStrength());
        scanner.nextLine();
    }

    private boolean run(){
        System.out.println("You try to run...");
        scanner.nextLine();
        if(rand.nextInt(10) > 7){
            System.out.println("Success!");
            return true;
        } else {
            System.out.println("Your attempt to escape has failed!");
            return false;
        }
    }
}