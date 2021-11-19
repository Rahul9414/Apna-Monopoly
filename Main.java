import java.util.*;
public class Main {
    static int currentStatus =1;
    static ArrayList<Players> players; //this is the players array which stores the information of each player
    static int numberOfPlayer; //this variable stores the number of player which are going to participate
    static PlayerThread1[] objplayerthreads; //this array is for running the players on different threads
    static Boolean flag = true;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Players");
        numberOfPlayer = sc.nextInt(); //take number of player as input
        players = new ArrayList<>();
        objplayerthreads = new PlayerThread1[numberOfPlayer];
        Main objmain = new Main();
        //we are initializing the array of players using this loop
        for(int i=0;i<numberOfPlayer;i++){
            System.out.println("Enter the name of "+(i+1)+" player");
            String name = sc.next();
            players.add(new Players(name));
            objplayerthreads[i] = new PlayerThread1(objmain, i+1);
        }
        System.out.println("Game Starting");
        new Tickets().SquareObjectInjection(); //this line is required so that all tickets get initialized in our array
        //this loop is to start the threads of each player
        for(int i=0;i<numberOfPlayer; i++){
            objplayerthreads[i].start();
        }
    }
}
