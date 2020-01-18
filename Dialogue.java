public class Dialogue{
    public static String[][] response = {
        {"Welcome to the World of Zuul!", "World of Zuul is a new, incredibly boring adventure game.", "Type 'help' if you need help.", "I don't know what you mean...", "You are lost. You are alone. You wander", "around at the university.", "Your command words are:", "   go quit help", "Go where?", "There is no door!", "You are ", "Exits: ", "Thank you for playing. Good bye!", "What is your name Hero?", "So your name is ", "That's a good name!", "Pardon?"},
         //0                               1                                                            2                                3                                4                                          5                            6                          7                  8            9                   10          11          12                                  13                         14                  15                     16
        {"Welkom bij de World of Zuul!", "World of Zuul is een nieuw, ontzettend saai avonturenspel.", "Typ 'hulp' als je hulp nodig hebt.", "Ik weet niet wat je bedoelt...", "Je bent verdwaalt. Je bent alleen. Je wandelt", "rond de Universiteit.", "Je commando's zijn:", "   ga stop hulp", "Waarheen?", "Er is geen deur!", "Je bent ", "Uitgangen: ", "Bedankt voor het spelen. Fijne dag!", "Wat is je naam Held?", "Dus, je naam is ", "Dat is een goede naam!", "Excuses?"}
    };

    public static String[][] direction = {
        {"north", "east", "south", "west"},
        //0        1       2        3
        {"noord", "oost", "zuid", "west"}
    };

    public static String[][] description = {
        {"outside the main entrance of the university", "in a lecture theater", "in the campus pub", "in a computing lab", "in the computing admin office"},
        //0                                              1                       2                    3                     4                               
        {"buiten de hoofdingang van de Universiteit", "in een auditorium", "in de campus kroeg", "in een computerlab", "in het computer hoofdkantoor"}
    };

    public static String[][] answer = {
        {"yes", "no"},
        {"ja", "nee"}
    };
}