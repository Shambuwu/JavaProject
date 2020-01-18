import java.util.Scanner;

public class Player{
    private Stats playerStats;
    private String playerName;
    private Inventory playerInventory = new Inventory();
    private int playerHealth;
    private int playerStrength;
    private int playerSpeed;
    private int gameLanguage = CommandWords.gameLanguage;
    Scanner scanner = new Scanner(System.in);

    public Player(){
        createPlayer();
    }

    public void createPlayer(){
        System.out.println(Dialogue.response[gameLanguage][13]);
        System.out.print("> ");
        String tempName = scanner.nextLine();
        if(tempName == "") createPlayer();
        if(checkPlayerName(tempName) == false) createPlayer();
        playerName = tempName;
        setPlayerStats();
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
    }

    public Stats getPlayerStats(){
        return playerStats;
    }

    public void setPlayerHeal(int heal){
        playerHealth += heal;
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

    public Inventory getInventory(){
        return playerInventory;
    }
}