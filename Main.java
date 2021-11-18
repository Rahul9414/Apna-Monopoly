import java.util.*;
public class Main {
    static int status =1;
    static ArrayList<Players> players;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Players");
        int numberOfPlayer = sc.nextInt(); //take number of player as input
        //we are initializing the array of players using this loop
        players = new ArrayList<>();
        for(int i=0;i<numberOfPlayer;i++){
            System.out.println("Enter the name of "+(i+1)+" player");
            String name = sc.next();
            players.add(new Players(name));
        }
        System.out.println("Game Starting");
        new Tickets().SquareObjectInjection();
        Main objmain = new Main();
        PlayerThread1 objplayerthread1 = new PlayerThread1(objmain);
        PlayerThread2 objplayerthread2 = new PlayerThread2(objmain);
        PlayerThread3 objplayerthread3 = new PlayerThread3(objmain);
        objplayerthread1.start();
        objplayerthread2.start();
        objplayerthread3.start();
    }
}
