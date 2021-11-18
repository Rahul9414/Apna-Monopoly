import java.util.*;
import java.io.*;
public class Tickets {
    String[] names;
    int[] prices;
    int[] rents;
    static Square[] squares=new Square[19];
    static HashMap<String, Integer> PlayerProperties=new HashMap<>();

    public Tickets(){
    names = new String[] { "GO", "Baltic Avenue", "Income Tax", "Rail Road", "Vermont Avenue", "Jail",
            "Electric Company", "States Avenue", "Community Chest", "New York Avenue", "Free Parking", "Chance",
            "Indiana Avenue", "Atlantic Avenue", "Water Works", "Go To Jail", "Pacific Avenue", "Park Place",
            "Luxary Tax" };
    prices = new int[] { 0, 60, 0, 200, 100, 0, 0, 140, 0, 200, 0, 0, 220, 260, 150, 0, 300, 350, 0 };
    rents = new int[] { 0, 18, 0, 60, 30, 0, 0, 42, 0, 60, 0, 0, 66, 78, 45, 0, 90, 105, 0 }; // have to                                                                                          
    }

    public void SquareObjectInjection(){
        for(int i = 0;i<names.length;i++)
            {
                if (i == 0) {
                    squares[i] = new GoSquare(names[i], prices[i], rents[i]);
                    PlayerProperties.put(squares[i].name,0);
                } else if (i == 2) {
                    squares[i] = new IncomeTax(names[i], prices[i], rents[i]);
                    PlayerProperties.put(squares[i].name,0);
                } else if (i == 5) {
                    squares[i] = new Jail(names[i], prices[i], rents[i]);
                    PlayerProperties.put(squares[i].name,0);
                } else if (i == 6) {
                    squares[i] = new Utility(names[i], prices[i], rents[i]);
                    PlayerProperties.put(squares[i].name,0);
                } else if (i == 8) {
                    squares[i] = new CommunityChest(names[i], prices[i], rents[i]);
                    PlayerProperties.put(squares[i].name,0);
                } else if (i == 10) {
                    squares[i] = new FreeParking(names[i], prices[i], rents[i]);
                    PlayerProperties.put(squares[i].name,0);
                } else if (i == 11) {
                    squares[i] = new Chance(names[i], prices[i], rents[i]);
                    PlayerProperties.put(squares[i].name,0);
                } else if (i == 15) {
                    squares[i] = new GoToJail(names[i], prices[i], rents[i]);
                    PlayerProperties.put(squares[i].name,0);
                } else if (i == 18) {
                    squares[i] = new LuxaryTax(names[i], prices[i], rents[i]);
                    PlayerProperties.put(squares[i].name,0);
                } else {
                    squares[i] = new ColorCards(names[i], prices[i], rents[i]);
                    PlayerProperties.put(squares[i].name,0);
                }
            }
    }
    
    public static int isPurchasedStatus(Square objSquare){
        return new Tickets().PlayerProperties.get(objSquare.name);
    }

    }
 