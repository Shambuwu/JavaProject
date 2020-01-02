import java.util.Scanner; //Import Scanner class

public class Scenario{
    String difficulty;
    Scanner scanner = new Scanner(System.in);

    Character player;

    Class knight;
    Class berserker;
    Class assassin;

    public Scenario(){
        start();
    }

    private void start(){
        System.out.println("Welcome to the dungeon.\nPlease select your difficulty: (1-3)");
        String tempDifficulty = scanner.nextLine();
        if(tempDifficulty.equals("1") || tempDifficulty.equals("2") || tempDifficulty.equals("3")){
            System.out.println("Difficulty has been set!");
            scanner.nextLine();
            difficulty = tempDifficulty;
            createCharacter();
        } else {
            System.out.println("That's not a valid difficulty setting!\n");
            scanner.nextLine();
            start();
        }
    }

    private void createCharacter(){
        System.out.println("We will now start creating your character.");
        boolean i = false;
        while(i == false){
            System.out.println("Please enter your character's name: ");
            String tempName = scanner.nextLine();
            if(!tempName.equals("")){
                Character player = new Character(tempName);
                scanner.nextLine();
                i = true;
            } else {
                System.out.println("Invalid name, please try again!");
                scanner.nextLine();
            }
        }
        selectClass();
    }

    private void selectClass(){
        System.out.println("Please select a class: (Knight, Assassin, Berserker)(1-3)");
        String tempClass = scanner.nextLine();
        switch(tempClass){
            case "1":
                System.out.println("Class set!");
                break;

            case "2":
                System.out.println("Class set!");
                break;

            case "3":
            System.out.println("Class set!");
            player.setClass(berserker.getClass());
            break;

            default:
                selectClass();
                break;
        }
    }

    public static void main(String[] args){
        Class knight = new Class(7, 8, 4, "knight");
        Class assassin = new Class(4, 9, 8, "assassin");
        Class berserker = new Class (5, 6, 6, "berserker");
        Scenario test = new Scenario();
    }
}