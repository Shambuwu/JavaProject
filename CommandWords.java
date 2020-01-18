import java.util.Scanner;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class CommandWords
{
    public static int gameLanguage;

    public static String[] validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        setLanguage();
    }

    public void setLanguage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a language");
        System.out.print("> ");
        String tempLanguage = scanner.nextLine();
        switch(tempLanguage.toLowerCase()){
            case "dutch":
                System.out.println("Taal is vastgesteld!");
                gameLanguage = Languages.DUTCH.getLanguage();
                validCommands = Dialogue.command[gameLanguage];   
                break;
            case "english":
                System.out.println("Language has been set!");
                gameLanguage = Languages.ENGLISH.getLanguage();
                validCommands = Dialogue.command[gameLanguage];   
                break;
            default:
                System.out.println("Invalid language!");
                setLanguage();
                break;
        }
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
}
