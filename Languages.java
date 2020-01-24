/**
 * Creates Languages. 
 */

public enum Languages{
    ENGLISH(0),
    DUTCH(1);

    private int language;
    
    /**
     * this sets the language
     * @param language sets the language variable to the given language value
     */
    Languages(int language) {
        this.language = language;
    }

    /**
     * returns the language value
     * @return returns an int
     */
    public int getLanguage(){
        return language;
    }
}