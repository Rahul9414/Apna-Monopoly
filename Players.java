import java.util.ArrayList;
public class Players extends Money{
    ArrayList<String> property; //this will store what are the property which a player has
    String name; //in this we are going to store the name of player
    public int currentPosition;

    //Constructor
    Players(String name){
        super();
        this.name = name;
        currentPosition=0;
        property = new ArrayList<>();
    }
    //default constructor
    Players(){
        
    }
    public int updatePosition(int dieFace){
        currentPosition += dieFace;
        return currentPosition;
    }
    public String getName(){
        return name;
    }
}
