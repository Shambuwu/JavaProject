public class Class{
    int health;
    int strength;
    int agility;
    static String className;

    public Class(int health, int strength, int agility, String name) {
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.className = name;

        System.out.println("Class created!\n");
    }

    public static String getClassName() {
        return className;
    }
}