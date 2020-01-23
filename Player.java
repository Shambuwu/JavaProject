import java.util.Scanner;

public class Player{
    private Stats playerStats;
    private String playerName;
    private Inventory playerInventory = new Inventory();
    private int playerHealth;
    private int playerStrength;
    private int playerMaxHealth;
    private int playerSpeed;
    private int gameLanguage = CommandWords.gameLanguage;
    private int playerXP;
    private int playerLevel;
    Scanner scanner = new Scanner(System.in);

    public Player(){
        createPlayer();
    }
 /** 
  * The "choose your name" part.
  */
    public void createPlayer(){
        System.out.println(Dialogue.response[gameLanguage][13]);
        System.out.print("> ");
        String tempName = scanner.nextLine();
        if(tempName == "") createPlayer();
        if(checkPlayerName(tempName) == false) createPlayer();
        playerName = tempName;
        setPlayerStats();
        playerXP = 0;
        playerLevel = 1;
    }

    private boolean checkPlayerName(String tempName){
        System.out.println(Dialogue.response[gameLanguage][14] + tempName + "?");
        for(String answer : Dialogue.answer[gameLanguage]){
            System.out.println("* " + answer);
        }
        System.out.print("> ");
        String answer = scanner.nextLine();
        if(answer.toLowerCase().equals(Dialogue.answer[gameLanguage][0])){
            System.out.println(Dialogue.response[gameLanguage][15]);
            return true;
        } else if(answer.toLowerCase().equals(Dialogue.answer[gameLanguage][1])){
            return false;
        } else {
            System.out.println(Dialogue.response[gameLanguage][16]);
            scanner.nextLine();
            checkPlayerName(tempName);
        }

        return true;
    }
/** 
 * Choose your class part.
 */
    public void setPlayerStats(){
        System.out.println(Dialogue.response[gameLanguage][17] + playerName + "?");
        int i = 1;
        for(Stats name : Stats.values()){
            System.out.println(""+ i + ". " + name.getName(gameLanguage));
            i++;
        }
        System.out.print("> ");

        int answer = scanner.nextInt();
        switch (answer){
            case 1: 
                playerStats = Stats.KNIGHT;
                break;
            case 2:
                playerStats = Stats.ASSASSIN;
                break;
            case 3:
                playerStats = Stats.MAGE;
                break;
            default:
                System.out.println(Dialogue.response[gameLanguage][18]);
                setPlayerStats();
        }
        
        playerHealth = playerStats.getHealth();
        playerStrength = playerStats.getStrength();
        playerSpeed = playerStats.getSpeed();
        playerMaxHealth = playerStats.getHealth();
    }

    public Stats getPlayerStats(){
        return playerStats;
    }
/** 
 * checks if the players health is not above the max health for the class.
 * if it is it will cap it at the maximum health the class has.
 */
    public void setPlayerHeal(int heal){
        if((playerHealth + heal) > playerMaxHealth){
            playerHealth = playerMaxHealth;
        } else playerHealth += heal;
    }

    public int getPlayerHealth(){
        return playerHealth;
    }

    public void setPlayerDamage(int damage){
        playerHealth -= damage;
    }

    public String getPlayerName(){
        return playerName;
    }

    public int getPlayerStrength(){
        return playerStrength;
    }

    public void getPlayerInventory(){
        playerInventory.getInventory();
    }

    public void addInventoryItem(Item item){
        playerInventory.addItem(item);
    }

    public Inventory getInventory(){
        return playerInventory;
    }

    public void playerLevelUp(){
        playerLevel += 1;
        playerStrength += (int) (playerLevel * 0.5);
        System.out.println("You leveled up!");
        playerMaxHealth += 10;
        playerHealth = playerMaxHealth;
    }

    public int getPlayerLevel(){
        return playerLevel;
    }

    public int getPlayerMaxHealth(){
        return playerMaxHealth;
    }

    public int getPlayerXP(){
        return playerXP;
    }
    
    public void setPlayerXP(int xp){
        playerXP += xp;
        while(!checkPlayerLevel()) checkPlayerLevel();
    }

    private Boolean checkPlayerLevel(){
        if(playerXP > 100){
            playerLevelUp();
            playerXP = playerXP - 100;
            if(playerXP > 100){
                return false;
            }
        }
        return true;
    }
}