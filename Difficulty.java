/**
 * This setting changes the health and strength to the desired difficulty.
 * In enemystats the stats for every enemy is written. 
 * If played on easy the health will be multiplied by 0.8.
 */
public enum Difficulty{
    EASY(0.8, Dialogue.difficulty[Game.gameLanguage][0]),
    MEDIUM(1.0, Dialogue.difficulty[Game.gameLanguage][1]),
    HARD(1.3, Dialogue.difficulty[Game.gameLanguage][2]);

    private double difficulty;
    private String name;

    /**
     * This sets all difficulty values
     * @param difficulty difficulty multiplier.
     * @param name difficulty name.
     */
    Difficulty(double difficulty, String name){
        this.difficulty = difficulty;
        this.name = name;
    }

    /**
     * this returns the difficulty multiplier
     * @return returns a double
     */
    public double getDifficulty(){
        return difficulty;
    }

    /**
     * this returns the difficulty name
     * @return returns a string
     */
    public String getDifficultyName(){
        return name;
    }
}