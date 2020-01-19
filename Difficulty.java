public enum Difficulty{
    EASY(0.8, Dialogue.difficulty[Game.gameLanguage][0]),
    MEDIUM(1.0, Dialogue.difficulty[Game.gameLanguage][1]),
    HARD(1.3, Dialogue.difficulty[Game.gameLanguage][2]);

    private double difficulty;
    private String name;
    Difficulty(double difficulty, String name){
        this.difficulty = difficulty;
        this.name = name;
    }

    public double getDifficulty(){
        return difficulty;
    }

    public String getDifficultyName(){
        return name;
    }
}