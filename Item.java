/** 
 * Creates items which are further worked on in Game
 */
public class Item{
    private Potions potion;

    /**
     * Item constructor, this sets the potion values
     * @param potion this is needed to see which type of potion this item is
     */
    public Item(Potions potion){
        this.potion = potion;
    }

    /**
     * returns the potion name
     * @return returns a string
     */
    public String getItemName(){
        return potion.getPotionName();
    }
    
    /**
     * returns the potion value
     * @return returns an int
     */
    public int getItemValue(){
        return potion.getPotionValue();
    }
}