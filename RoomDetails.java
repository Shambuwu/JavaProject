public enum RoomDetails{
    OUTSIDE(Dialogue.view[Game.gameLanguage]),
    CASTLE(Dialogue.view[Game.gameLanguage]),
    GARDEN(Dialogue.view[Game.gameLanguage]),
    WALL(Dialogue.view[Game.gameLanguage]),
    DUNGEON(Dialogue.view[Game.gameLanguage]);

    private String[] descriptions;

    RoomDetails(String[] descriptions){
        this.descriptions = descriptions;
    }

    public String[] getRoomDescriptions(){
        return descriptions;
    }
}