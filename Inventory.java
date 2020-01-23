import java.util.ArrayList;
/**
 * Shows all items in the inventory.
 * 
 */
public class Inventory{
    ArrayList<Item> inventory = new ArrayList<>();
    ArrayList<KeyItem> keyItemInventory = new ArrayList<>();

    public Inventory(){
        Item item = new Item(Potions.HEALTH_POT);
        Item item1 = new Item(Potions.HEALTH_POT_STRONG);
        Item item2 = new Item(Potions.HEALTH_POT_ULTRA);
        inventory.add(item);
        inventory.add(item1);
        inventory.add(item2);
    }

    public void getInventory(){
        int y = 1;
        if(inventory.size() != 0){
            System.out.println(Dialogue.response[Game.gameLanguage][19]);
            for(Item i : inventory){
                System.out.println("" + y + ". " + i.getItemName());
                y++;
            }
        } else if(keyItemInventory.size() != 0){
            int z = 1;
            System.out.println("Key items:");
            for(KeyItem i : keyItemInventory){
                System.out.println("" + z + ". " + i.getKeyItemName());
                z++;
            }
        } 
        else System.out.println(Dialogue.response[Game.gameLanguage][20]);

    }
/**
 * whenever an item is used, its used here.
 */
    public int useItem(int item){
        for(int i = 0; i < inventory.size(); i++){
            if(i == (item - 1)){
                System.out.println(Dialogue.response[Game.gameLanguage][21] + inventory.get(i).getItemName());
                int value = inventory.get(i).getItemValue();
                inventory.remove(i);
                return value;
            }
        }
        return 0;
    }
/** 
 * whenever an item is taken, this command runs.
 */
    public void addItem(Item item){
        if(inventory.size() >= 5){
            System.out.println(Dialogue.response[Game.gameLanguage][32]);  
        } else inventory.add(item);
    }
    
    public void addKeyItem(KeyItem item){
        keyItemInventory.add(item);
    }

    public void useKeyItem(int item){
        for(int i = 0; i < keyItemInventory.size(); i++){
            if(i == (item - 1)){
                System.out.println("Used " + keyItemInventory.get(i).getKeyItemName());
                keyItemInventory.remove(item);
            }
        }
    }
} 