import java.util.ArrayList;
public class Players extends Money{
    ArrayList<String> property; //this will store what are the property a player owns
    String name; //in this we are going to store the name of player
    public int currentPosition; //this variable is to store the current position of the player

    //Parametrized Constructor
    Players(String name){
        super();
        this.name = name;
        currentPosition=0;
        property = new ArrayList<>();
    }
    //Default constructor
    Players(){ 
    }
    public int updatePosition(int dieFace){ //this function updates the position of player
        currentPosition += dieFace;
        return currentPosition;
    }
    public String getName(){ //getter function for name
        return name;
    }
    public void modifiedPosition(int currentPosition){
        this.currentPosition=currentPosition;
    }

    public void stopThreads(){
        for(int j=0;j<Main.numberOfPlayer;j++){
            Main.objplayerthreads[j].stop();
        }
    }
}
