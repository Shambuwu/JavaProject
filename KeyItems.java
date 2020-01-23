public enum KeyItems{
    KEY("A key to unlock a door", 0);

    private String description;
    private int type;

    KeyItems(String description, int type){
        this.description = description;
        this.type = type;
    }

    public String getDescription(){
        return description;
    }

    public int getType(){
        return type;
    }
}