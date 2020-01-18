import java.util.Scanner;

public class Player{
    private Stats playerStats;
    private String playerName;
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
    }

    private boolean checkPlayerName(String tempName){
        System.out.println(Dialogue.response[gameLanguage][14] + tempName + "?");
        for(String answer : Dialogue.answer[gameLanguage]){
            System.out.println("* " + answer);
        }
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

        return false;
    }
}