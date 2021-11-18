import java.util.ArrayList;
public class Players extends Money{
    private ArrayList<String> property = null; //this will store what are the property which a playesr has
    String name; //in this we are going to store the name of player
    public int currentPosition;

    //Constructor
    Players(String name){
        super();
        this.name = name;
        currentPosition=0;
    }

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
