public class Item{
    private Potions potion;

    public Item(Potions potion){
        this.potion = potion;
    }

    public String getItemName(){
        return potion.getPotionName();
    }
    
    public int getItemValue(){
        return potion.getPotionValue();
    } //lol
}