import java.util.Scanner;

/** 
 * This class creates the Boss which is encoutered.
 */
public class BossFight{
    /**
     * BossFight constructor, this initiates an encounter with a boss.
     * @param player player object. Required to get all player stats.
     * @param enemyStats this decides which boss the player will encounter.
     */
    public BossFight(Player player, EnemyStats enemyStats){
        Enemy boss = new Enemy(enemyStats);
        Encounter bossFight = new Encounter(player, boss);
        if(enemyStats == enemyStats.KING){
            System.out.println("You defeated the final boss!");
            System.out.println("Do you want to play again?");
            checkAnswer();
        }
        if(enemyStats == enemyStats.WARRIOR){
            KeyItem key = new KeyItem(KeyItems.KEY);
            player.playerAddKeyItem(key);
        }
    }

    /**
     * Check the player answer
     */
    private void checkAnswer(){
        for(String answer : Dialogue.answer[Game.gameLanguage]){
            System.out.println("* " + answer);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String answer = scanner.nextLine();
        switch(answer.toLowerCase()){
            case "yes":
                Game newGame = new Game();
                newGame.play();
                break;
            case "no":
                System.out.println("Thank you for playing!");
                scanner.nextLine();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid answer");
                checkAnswer();
                break;
        }
    }
}