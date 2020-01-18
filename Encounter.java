import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

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
            System.out.println(Dialogue.response[Game.gameLanguage][22] + enemyStats.getName(0) + "!");
        } else if(randomEnemy >= 40 && randomEnemy < 70){
            enemyStats = EnemyStats.KOBOLD;
            enemy = new Enemy(enemyStats);
            System.out.println(Dialogue.response[Game.gameLanguage][22] + enemyStats.getName(0) + "!");
        } else if(randomEnemy >= 70 && randomEnemy < 90){
            enemyStats = EnemyStats.GNOLL;
            enemy = new Enemy(enemyStats);
            System.out.println(Dialogue.response[Game.gameLanguage][22] + enemyStats.getName(0) + "!");
        } else if(randomEnemy >= 90){
            enemyStats = EnemyStats.OGRE;
            enemy = new Enemy(enemyStats);
            System.out.println(Dialogue.response[Game.gameLanguage][23] + enemyStats.getName(0) + "!");
        }
        scanner.nextLine();
        System.out.println(Dialogue.response[Game.gameLanguage][24] + player.getPlayerHealth());
        System.out.println(Dialogue.response[Game.gameLanguage][25] + enemy.getEnemyHealth() + "\n");
        encounterStart();
    }

    public boolean hasWonFight = false;    
    public boolean encounterStart(){
        while(hasWonFight == false){
            if(hasWonFight == false){
                playerChoice();
                if(enemy.getEnemyHealth() <= 0){
                    System.out.println(Dialogue.combat[Game.gameLanguage][0] + enemy.getType());
                    hasWonFight = true;
                }
                scanner.nextLine();
            }
            if(hasWonFight == false){   
                enemyChoice();
                System.out.println(Dialogue.response[Game.gameLanguage][24] + player.getPlayerHealth());
                if(player.getPlayerHealth() <= 0){
                    System.out.println(Dialogue.response[Game.gameLanguage][26]);
                    scanner.nextLine();
                    System.exit(0);
                    return false;
                }
                scanner.nextLine();
            }
        }

        System.out.println("You gain 20xp!");
        scanner.nextLine();
        return true;
    }

    public void playerChoice(){
        System.out.println(Dialogue.combat[Game.gameLanguage][1]);
        System.out.println("-----------------");
        System.out.println(Dialogue.combat[Game.gameLanguage][2]);
        System.out.println(Dialogue.combat[Game.gameLanguage][3]);
        System.out.print("> ");
        int choice = scanner.nextInt();
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
                scanner.nextLine();
                break;
            default:
                System.out.println(Dialogue.response[Game.gameLanguage][18]);
                playerChoice();
        }
    }

    private void enemyChoice(){
        int damage = enemy.getStrength() + rand.nextInt(10);
        System.out.println(Dialogue.combat[Game.gameLanguage][7] + enemy.getType() + Dialogue.combat[Game.gameLanguage][8]);
        System.out.println(Dialogue.combat[Game.gameLanguage][9] + damage + Dialogue.combat[Game.gameLanguage][10]);
        player.setPlayerDamage(damage);
        scanner.nextLine();
    }

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