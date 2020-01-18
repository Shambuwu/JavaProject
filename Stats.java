public enum Stats{
    KNIGHT(7, 8, 4),
    ASSASSIN(5, 9, 7),
    BERSERKER(6, 6, 6);

    private int health;
    private int strength;
    private int speed;

    Stats(int health, int strength, int speed) {
        this.health = health;
        this.strength = strength;
        this.speed = speed;
    }

    public int getHealth(){
        return health;
    }

    public int getStrength(){
        return strength;
    }

    public int getSpeed(){
        return speed;
    }
}