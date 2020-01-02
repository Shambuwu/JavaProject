public class Character{
    String name;
    String characterClass;

    public Character(String name){
        System.out.println("Character created!");
        this.name = name;
    }

    public void setClass(String characterClass){
        this.characterClass = characterClass; 
    }
}