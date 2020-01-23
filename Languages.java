/**
 * Creates Languages. 
 */

public enum Languages{
    ENGLISH(0),
    DUTCH(1);

    private int language;
    
    Languages(int language) {
        this.language = language;
    }

    public int getLanguage(){
        return language;
    }
}