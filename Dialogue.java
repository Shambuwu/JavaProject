/**
 * This whole class is used in connection to the Player. 
 * If the player needs to know something, text will be displayed.
 * in command there are all commands that are in the "help" command.
 */

public class Dialogue{
    public static String[][] response = {
        {"Welcome to the World of Zuul!", "World of Zuul is a new, incredibly boring adventure game.", "Type 'help' if you need help.", "I don't know what you mean...", "You are lost. You are alone. You wander", "around at the university.", "Your command words are:", "   go quit help", "Go where?", "There is no door!", "You are ", "Exits: ", "Thank you for playing. Good bye!", "What is your name Hero?", "So your name is ", "That's a good name!", "Pardon?", "What is your profession ", "That's not a valid answer...", "Your inventory contains: ", "Your inventory is empty!", "You used the ", "You encounter a ", "You encounter an ", "Your health is: ", "Their health is: ", "You die. Too bad.", "Use what?", "Try the number of the item you're trying to use.", "On what difficulty would you like to play?", "Difficulty has been set!", "You obtained a ", "Your inventory is too full!", "Check what?", "You are starting to feel sick. It might be something in the atmosphere. You convince yourself that you should hurry before the castle consumes your soul", "Everything seems to start looking the same, you can't find the way, you don't feel great at all. You decide to take a rest on the ground. After that you never woke up.",               "YOU DIED due to illness"   },
         //0                               1                                                            2                                3                                4                                          5                            6                          7                  8            9                   10          11          12                                  13                         14                  15                     16         17                          18                              19                           20                          21               22                  23                   24                  25                   26                   27           28                                                  29                                            30                          31                 32                             33                          34                                                                                                                                                              35                                                                                                                                                                              36
        {"Welkom bij de World of Zuul!", "World of Zuul is een nieuw, ontzettend saai avonturenspel.", "Typ 'hulp' als je hulp nodig hebt.", "Ik weet niet wat je bedoelt...", "Je bent verdwaalt. Je bent alleen. Je wandelt", "rond de Universiteit.", "Je commando's zijn:", "   ga stop hulp", "Waarheen?", "Er is geen deur!", "Je bent ", "Uitgangen: ", "Bedankt voor het spelen. Fijne dag!", "Wat is je naam Held?", "Dus, je naam is ", "Dat is een goede naam!", "Excuses?", "Wat is je beroep ", "Dat is een ongeldig antwoord...", "Je inventaris bevat: ", "Je inventaris is leeg!", "Je gebruikte het ", "Er staat een ", "Er staat een ", "Je gezondheid is: ", "Hun gezondheid is: ", "Je sterft. Jammer.", "Wat gebruiken?", "Probeer het nummer van het object dat je wilt gebruiken.", "Op welke moeilijkheid wil je spelen?", "Moeilijkheid is vastgesteld!", "Je krijgt een ", "Je inventaris is te vol!", "wat bekijken?", "je begint je ziek te voelen. Het kan aan iets in de ruimte liggen. je overtuigd jezelf dat je moet beginnen met haasten voordat het kasteel je ziel opeet.", "alles begint op elkaar te lijken, je kan de juiste route niet meer vinden, je voelt je helemaal niet goed. Je besluit om op de grond te gaan rusten. Je bent nooit meer wakker geworden.:", "Je bent gestorven door een ziekte" }
    };

    public static String[][] direction = {
        {"north", "east", "south", "west"},
        //0        1       2        3
        {"noord", "oost", "zuid", "west"}
    };
public static String[][] secondWord = {
{"room", "stats"},
{"kamer", "statistieken"},
};
    public static String[][] description = {
        {"at the Main Plaza", "inside the Castle Hall", "in the Graveyard", "on the Holy Bridge", "in the Empty Treasure Room", " in the Meadow", " on the Abandoned Road", " in the Abandoned Settlement", "on the Eastern Road", "at the Abandoned House", "at the Castle Entrance", "on the Eastern Corridor", " in the Mysterious Room", "in the Treasure Room", "in the Northern Corridor", " in the Throneroom"  },
        //0                                          1                     2                      3                                 4                          5                 6                          7                               8                    9                          10                      11                           12                         13                     14                           15                 
        {"buiten de hoofdingang van het kasteel", "in het kasteel", "in de kasteeltuin",    "op de muur van het kasteel",       "in de kasteelkerker",  " in het Weiland"," op het Verlaten Pad",   "in het Verlaten Dorp",         "op het Oosterse Pad",      "bij het Verlaten Huis", "bij de kasteel's ingang", "in de oosterse gang","in de mysterieuze kamer",    "in de schatkamer",     "in de Noordelijke gang",   "in de troonkamer"}
    };

    public static String[][] answer = {
        {"yes", "no"},
        //0      1
        {"ja", "nee"}
    };

    public static String[][] enemy = {
        {"Goblin", "Kobold", "Ogre", "Gnoll"},
        {"Aardman", "Kabouter", "Oger", "Gnol"}
    };

    public static String[][] boss = {
        {"Warrior of the Old Gods", "Forgotten King", "Stray Demon"},
        {"Krijger van de Oude Goden", "Vergeten Koning", "Zwervende Demoon"}
    };

    public static String[][] item = {
        {"Health Potion (+10)", "Stronger Potion of Healing (+15)", "Ultra Potion of Healing (+20)", "Strength Potion", "Stronger Potion of Strength", "Ultra Potion of Strength"},
        {"Gezondheidsdrankje (+10)", "Sterker Gezondheidsdrankje (+15)", "Ultra Gezondheidsdrankje (+20)", "Krachtdrankje", "Sterker Krachtdrankje", "Ultra Krachtdrankje"}
    };

    public static String[][] player = {
        {"Knight", "Assassin", "Mage"},
        {"Ridder", "Sluipmoordenaar", "Magier"}
    };

    public static String[][] command = {
        {"go" , "back", "help", "inventory", "use", "look","quit", "check" }, //English
        {"ga", "terug", "hulp", "inventaris", "gebruik", "kijk","stop", "bekijk" } //Dutch
    };

    public static String[][] combat = {
        {"You kill the ", "What will you do?", "1. Attack", "2. Run", "You hit the ", " for ", " damage!", "The ", " strikes!", "They hit for ", " damage!", "You try to run...", "Success!", "Your attempt to flee has failed!"},
        //0                1                    2            3         4               5        6           7        8           9                10          11                   12          13       
        {"Je doodt de ", "Wat doe je?", "1. Aanvallen", "2. Rennen", "Je raakt de ", " en richt ", " schade aan!", "De ", " slaat toe!", "Deze richt ", " schade aan!", "Je probeert te weg te rennen...", "Succes!", "Je poging te ontsnappen is gefaald!"}
    };

    public static String[][] difficulty = {
        {"Easy", "Normal", "Hard"},
        {"Makkelijk", "Normaal", "Moeilijk"}
    };

    public static String[][][] view = 
    {
        {{"There is a dead body by the entrance.", "A big open door invites you to travel beyond.", "You hear a cry echo in the distance."},
         {"There is an empty throne in front of you. 'I wonder who once sat there.'", "There's a piercing smell present.", "It doesn't seem like there's anyone around."},
         {"Dead flora is all over this garden.", "You spot a dog's corpse. 'Yuck!'", "You wonder if this garden has ever flourished."},
         {"You're on the high wall of this kingdom.", "You see an empty settlement in the distance.", "Ivy has taken over a great part of  the wall."},
         {"You see a bloody set of chains laying on the ground.", "You're almost unable to see through the darkness.", "'I wonder how many people have been imprisoned in this accursed dungeon.'"}},

        {{"Er ligt een lijk bij de ingang.", "Een grote open deur nodigt je uit om verder te reizen.", "Je hoort een schreeuw in de verte."},
         {"Er staat een lege troon voor je. 'Ik vraag me af wie daar ooit heeft gezeten.'", "Er is een doordringende geur aanwezig.", "Het lijkt er niet op dat er nog iemand is."},
         {"Er ligt overal dode flora.", "Je ziet een dode hond. 'Jakkes!'", "Je vraagt je af of deze tuin ooit heeft gebloeid."},
         {"Je staat op de hoge muur van dit koninkrijk.", "Je ziet een lege nederzetting in de verte.", "Klimop heeft een groot deel van de muur overgenomen."},
         {"Je ziet het skelet van een mens hangend aan een wandkettingen set.", "Je kan bijna niet door de duisternis heen zien.", "'Ik vraag me af hoeveel mensen hier gevangen zijn geweest.'"}}
    };

}