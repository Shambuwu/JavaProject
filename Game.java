import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room lastRoom = currentRoom;
    private Room tempRoom;
    public static int gameLanguage;
    public static Difficulty gameDifficulty;
    private Player player;
    public HashMap<Room, Integer> map;
    private Enemy enemy;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        //Window window = new Window();
        parser = new Parser();
        gameLanguage = CommandWords.gameLanguage;
        createRooms();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, castle, garden, wall, dungeon;
        map = new HashMap<>();
      
        // create the rooms
        outside = new Room(Dialogue.description[gameLanguage][0]);
        castle = new Room(Dialogue.description[gameLanguage][1]);
        garden = new Room(Dialogue.description[gameLanguage][2]);
        wall = new Room(Dialogue.description[gameLanguage][3]);
        dungeon = new Room(Dialogue.description[gameLanguage][4]);

        //set the rooms in the hashmap
        map.put(outside, 0);
        map.put(castle, 1);
        map.put(garden, 2);
        map.put(wall, 3);
        map.put(dungeon, 4);
        
        // initialise room exits
        outside.setExits(null, castle, garden, wall);
        castle.setExits(null, null, null, outside);
        wall.setExits(null, outside, null, null);
        garden.setExits(outside, dungeon, null, null);
        dungeon.setExits(null, null, null, garden);

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {
        
        player = new Player();
        setDifficulty();
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println(Dialogue.response[gameLanguage][12]);
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println(Dialogue.response[gameLanguage][0]);
        System.out.println(Dialogue.response[gameLanguage][1]);
        System.out.println(Dialogue.response[gameLanguage][2]);
        System.out.println();
        checkRoom();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        String[] commands = CommandWords.validCommands;
        
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println(Dialogue.response[gameLanguage][3]);
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals(commands[2])) {
            printHelp();
        }
        else if (commandWord.equals(commands[0])) {
            lastRoom = currentRoom;
            goRoom(command);
        }
        else if (commandWord.equals(commands[1])){
            if (lastRoom != null){
            
               tempRoom    = currentRoom;
               currentRoom = lastRoom;
               lastRoom    = tempRoom;
               checkRoom();
            }    
        } else if (commandWord.equals(commands[3])) {
            player.getPlayerInventory();
        } else if (commandWord.equals(commands[4])) {
            useItem(command);
        } else if (commandWord.equals(commands[5])){
            lookAround();
        } else if (commandWord.equals(commands[6])){
            wantToQuit = quit(command);
        }   else if (commandWord.equals(commands[7])){
            check(command);
            
        } //else if(command.this.secondWord.equals(room)){
        
       
        
       
            
        return wantToQuit;
       
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println(Dialogue.response[gameLanguage][4]);
        System.out.println(Dialogue.response[gameLanguage][5]);
        System.out.println();
        System.out.println(Dialogue.response[gameLanguage][6]);
        for(int i = 0; i < CommandWords.validCommands.length; i++) {
            System.out.println("   " + (i + 1) + ". " +CommandWords.validCommands[i]);
        }
        System.out.println();
    }

    /**
     * Look around
     */
    public void lookAround(){
        Random rand = new Random();
        System.out.println(Dialogue.view[gameLanguage][map.get(currentRoom)][rand.nextInt(2)]);
    }

    /**
     * Set game difficulty
     */
    public void setDifficulty(){
        Scanner scanner = new Scanner(System.in);
        int y = 1;
        System.out.println(Dialogue.response[gameLanguage][29]);
        for(String i : Dialogue.difficulty[gameLanguage]){
            System.out.println("" + y + ". " + i);
            y++;
        }
        System.out.print("> ");

        int input = scanner.nextInt();
        String outputx = Dialogue.response[Game.gameLanguage][30];
        switch(input){
            case 1:
                gameDifficulty = Difficulty.EASY;
                break;
            case 2:
                gameDifficulty = Difficulty.MEDIUM;
                break;
            case 3:
                gameDifficulty = Difficulty.HARD;
                break;
            default:
                outputx = Dialogue.response[Game.gameLanguage][18]; 
                setDifficulty();
                break;
        }
        System.out.println(outputx);
        
    }

    /**
     * Use item in inventory
     */
    private void useItem(Command command){
        if(!command.hasSecondWord()){
            System.out.println(Dialogue.response[Game.gameLanguage][27]);
            return;
        }

        String use = command.getSecondWord();
        try {
            int item = Integer.parseInt(use);
            player.setPlayerHeal(player.getInventory().useItem(item));
            System.out.println(Dialogue.response[Game.gameLanguage][24] + player.getPlayerHealth() + "/" + player.getPlayerStats().getHealth());
         }
         catch (NumberFormatException e)
         {
            System.out.println(Dialogue.response[Game.gameLanguage][27]);
         }
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    int steps = 1;
    private void goRoom(Command command) 
    {
        Random rand = new Random();
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println(Dialogue.response[gameLanguage][8]);
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        if(direction.equals(Dialogue.direction[gameLanguage][0])) {
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals(Dialogue.direction[gameLanguage][1])) {
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals(Dialogue.direction[gameLanguage][2])) {
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals(Dialogue.direction[gameLanguage][3])) {
            nextRoom = currentRoom.westExit;
        }

        if (nextRoom == null) {
            System.out.println(Dialogue.response[gameLanguage][9]);
        }
        else {
            currentRoom = nextRoom;
            int randomEnemy = rand.nextInt(100);
            if(randomEnemy < 40){
                enemy = new Enemy(EnemyStats.GOBLIN);
                //System.out.println(Dialogue.response[Game.gameLanguage][22] + enemyStats.getName(0) + "!");
            } else if(randomEnemy >= 40 && randomEnemy < 70){
                enemy = new Enemy(EnemyStats.KOBOLD);
                //System.out.println(Dialogue.response[Game.gameLanguage][22] + enemyStats.getName(0) + "!");
            } else if(randomEnemy >= 70 && randomEnemy < 90){
                enemy = new Enemy(EnemyStats.GNOLL);
                //System.out.println(Dialogue.response[Game.gameLanguage][22] + enemyStats.getName(0) + "!");
            } else if(randomEnemy >= 90){
                enemy = new Enemy(EnemyStats.OGRE);
                //System.out.println(Dialogue.response[Game.gameLanguage][23] + enemyStats.getName(0) + "!");
            }
            if(rand.nextInt(10) > 7){
                Encounter fight = new Encounter(player, enemy);
            } else if(steps == 5){
                BossFight fight = new BossFight(player, EnemyStats.DEMON);
                steps = 0;
            }
            steps++;
            System.out.println(Dialogue.response[gameLanguage][10] + currentRoom.getDescription());
            System.out.print(Dialogue.response[gameLanguage][11]);
            if(currentRoom.northExit != null) {
                System.out.print(Dialogue.direction[gameLanguage][0] + " ");
            }
            if(currentRoom.eastExit != null) {
                System.out.print(Dialogue.direction[gameLanguage][1] + " ");
            }
            if(currentRoom.southExit != null) {
                System.out.print(Dialogue.direction[gameLanguage][2] + " ");
            }
            if(currentRoom.westExit != null) {
                System.out.print(Dialogue.direction[gameLanguage][3] + " ");
            }
            System.out.println();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    /**
     * "check" was entered. checks if there is a 2nd word.
     * if there is a 2nd word, brings it to the correct check.
     */
    private void check(Command command) {
        String[] commands = CommandWords.validCommands;
        String commandWord = command.getSecondWord();
        
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what to check...
            System.out.println(Dialogue.response[gameLanguage][33]);
            return;
        }
        if(commandWord.equals(Dialogue.secondWord[gameLanguage][0]))    {
         checkRoom();
        }
        else { System.out.println(Dialogue.response[gameLanguage][3]); 
        }
    }
    /**
     * if check finds room as 2nd word, checks the room and displays the exits.
     */
    private void checkRoom(){  
       
       
     System.out.println(Dialogue.response[gameLanguage][10] + currentRoom.getDescription());
            System.out.print(Dialogue.response[gameLanguage][11]);
            if(currentRoom.northExit != null) {
            System.out.print(Dialogue.direction[gameLanguage][0] + " ");
        }
        if(currentRoom.eastExit != null) {
            System.out.print(Dialogue.direction[gameLanguage][1] + " ");
        }
        if(currentRoom.southExit != null) {
            System.out.print(Dialogue.direction[gameLanguage][2] + " ");
        }
        if(currentRoom.westExit != null) {
            System.out.print(Dialogue.direction[gameLanguage][3] + " ");
        }
        System.out.println();
    
    
    }
    
}

