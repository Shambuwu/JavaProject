import java.util.ArrayList;
import java.util.Iterator;

public class Map(){
    private ArrayList<Room> rooms = new ArrayList<>();

    Room outside = new Room(Dialogue.description[gameLanguage][0]);
    Room castle = new Room(Dialogue.description[gameLanguage][1]);
    Room garden = new Room(Dialogue.description[gameLanguage][2]);
    Room wall = new Room(Dialogue.description[gameLanguage][3]);
    Room dungeon = new Room(Dialogue.description[gameLanguage][4]);

    rooms.add(outside);
    rooms.add(castle);
    rooms.add(garden);
    rooms.add(wall);
    rooms.add(dungeon);

    private ArrayList<Room> map = new ArrayList<>();
    private Iterator<map> iterator;

    public Map(int amountOfRooms){
        for(int i = 0; i < amountOfRooms; i++){
            for(Room y : rooms){
                map.add(y);
            }
        }
        iterator = map.iterator;
    }

    public void setExit(){
        while(iterator.hasNext()){
            
        }
    }
}