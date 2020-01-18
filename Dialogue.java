public class Dialogue{
    public static String[][] response = {
        {"Welcome to the World of Zuul!", "World of Zuul is a new, incredibly boring adventure game.", "Type 'help' if you need help.", "I don't know what you mean...", "You are lost. You are alone. You wander", "around at the university.", "Your command words are:", "   go quit help", "Go where?", "There is no door!", "You are ", "Exits: ", "Thank you for playing. Good bye!", "What is your name Hero?", "So your name is ", "That's a good name!", "Pardon?", "What is your profession ", "That's not a valid answer...", "Your inventory contains: ", "Your inventory is empty!", "You used the ", "You encounter a ", "You encounter an ", "Your health is: ", "Their health is: ", "You die. Too bad.", "Use what?", "Try the number of the item you're trying to use."},
         //0                               1                                                            2                                3                                4                                          5                            6                          7                  8            9                   10          11          12                                  13                         14                  15                     16         17                          18                              19                           20                          21               22                  23                   24                  25                   26                   27           28
        {"Welkom bij de World of Zuul!", "World of Zuul is een nieuw, ontzettend saai avonturenspel.", "Typ 'hulp' als je hulp nodig hebt.", "Ik weet niet wat je bedoelt...", "Je bent verdwaalt. Je bent alleen. Je wandelt", "rond de Universiteit.", "Je commando's zijn:", "   ga stop hulp", "Waarheen?", "Er is geen deur!", "Je bent ", "Uitgangen: ", "Bedankt voor het spelen. Fijne dag!", "Wat is je naam Held?", "Dus, je naam is ", "Dat is een goede naam!", "Excuses?", "Wat is je beroep ", "Dat is een ongeldig antwoord...", "Je inventaris bevat: ", "Je inventaris is leeg!", "Je gebruikte het ", "Er staat een ", "Er staat een ", "Je gezondheid is: ", "Hun gezondheid is: ", "Je sterft. Jammer.", "Wat gebruiken?", "Probeer het nummer van het object dat je wilt gebruiken."}
    };

    public static String[][] direction = {
        {"north", "east", "south", "west"},
        //0        1       2        3
        {"noord", "oost", "zuid", "west"}
    };

    public static String[][] description = {
        {"outside the main entrance of the castle", "inside the castle", "in the castle garden", "on the high wall of the castle", "in the castle dungeon"},
        //0                                              1                       2                    3                     4                               
        {"buiten de hoofdingang van het kasteel", "in het kasteel", "in de kasteeltuin", "op de hoge muur van het kasteel", "in de kasteelkerker"}
    };

    public static String[][] answer = {
        {"yes", "no"},
        //0      1
        {"ja", "nee"}
    };

    public static String[][] enemy = {
        {"Goblin", "Kobold", "Ogre", "Gnoll"},
        {"Aardman", "Kabouter", "Ogre", "Gnoll"}
    };

    public static String[][] item = {
        {"Health Potion", "Stronger Potion of Healing", "Ultra Potion of Healing", "Strength Potion", "Stronger Potion of Strength", "Ultra Potion of Strength"},
        {"Gezondheidsdrankje", "Sterker Gezondheidsdrankje", "Ultra Gezondheidsdrankje", "Krachtdrankje", "Sterker Krachtdrankje", "Ultra Krachtdrankje"}
    };

    public static String[][] player = {
        {"Knight", "Assassin", "Mage"},
        {"Ridder", "Sluipmoordenaar", "Magier"}
    };

    public static String[][] command = {
        {"go", "quit", "help", "inventory", "use"}, //English
        {"ga", "stop", "hulp", "inventaris", "gebruik"} //Dutch
    };

    public static String[][] combat = {
        {"You kill the ", "What will you do?", "1. Attack", "2. Run", "You hit the ", " for ", " damage!", "The ", " strikes!", "They hit for ", " damage!", "You try to run...", "Success!", "Your attempt to flee has failed!"},
        //0                1                    2            3         4               5        6           7        8           9                10          11                   12          13       
        {"Je doodt de ", "Wat doe je?", "1. Aanvallen", "2. Rennen", "Je raakt de ", " en deelt ", " schade uit!", "De ", " slaat toe!", "Deze deelt ", " schade uit!", "Je probeert te weg te rennen...", "Succes!", "Je poging te ontsnappen is gefaald!"}
    };
}