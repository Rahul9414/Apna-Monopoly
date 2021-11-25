import java.util.*;
public class Tickets {
    String[] names;
    int[] prices;
    int[] rents;
    static Square[] squares=new Square[19]; //this array is to store all the tickets
    static HashMap<String, Integer> PlayerProperties=new HashMap<>(); //this is for storing which ticket is owned by which player

    public Tickets(){
    names = new String[] { "GO", "Baltic Avenue", "Income Tax", "Rail Road", "Vermont Avenue", "Jail",
            "Electric Company", "States Avenue", "Community Chest", "New York Avenue", "Free Parking", "Chance",
            "Indiana Avenue", "Atlantic Avenue", "Water Works", "Go To Jail", "Pacific Avenue", "Park Place",
            "Luxary Tax" };
    prices = new int[] { 0, 60, 0, 200, 100, 0, 150, 140, 0, 200, 0, 0, 220, 260, 150, 0, 300, 350, 0 };
    rents = new int[] { 0, 18, 0, 60, 30, 0, 45, 42, 0, 60, 0, 0, 66, 78, 45, 0, 90, 105, 0 };                                                                                          
    }
    public void SquareObjectInjection(){
        for(int i = 0;i<names.length;i++)//by this loop we are filling the board
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
                } else if (i == 6) { //isko hatana hai
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
    // this function is checking that the given ticket is already purchased or not
    public static int isPurchasedStatus(Square objSquare){
        return Tickets.PlayerProperties.get(objSquare.name);
    }
    }
 