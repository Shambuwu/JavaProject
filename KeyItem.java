public class KeyItem{
    private KeyItems key;

    public KeyItem(KeyItems key){
        this.key = key;
    }

    public String getKeyItemName(){
        return key.getDescription();
    }

    public int getKeyItemType(){
        return key.getType();
    }
}