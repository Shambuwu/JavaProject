import java.util.ArrayList;
import java.util.Iterator;

public class Map{
    private ArrayList<Room> rooms = new ArrayList<>();

    Room outside = new Room(Dialogue.description[Game.gameLanguage][0]);
    Room castle = new Room(Dialogue.description[Game.gameLanguage][1]);
    Room garden = new Room(Dialogue.description[Game.gameLanguage][2]);
    Room wall = new Room(Dialogue.description[Game.gameLanguage][3]);
    Room dungeon = new Room(Dialogue.description[Game.gameLanguage][4]);

    private Room test = new Room("test");

    private ArrayList<Room> map = new ArrayList<>();
    private Iterator<Room> iterator;

    public Map(int amountOfRooms){
        rooms.add(outside);
        rooms.add(castle);
        rooms.add(garden);
        rooms.add(wall);
        rooms.add(dungeon);

        for(int i = 0; i < amountOfRooms; i++){
            for(Room y : rooms){
                map.add(y);
            }
        }
        iterator = map.iterator();
        setExit();
    }

    public void setExit(){
        while(iterator.hasNext()){
                iterator.next().setExits(null, null, null, null);
                System.out.println("Dit werkt?");
        }
    }

    public static void main(String[] args){
        Map map = new Map(3);
    }
}