public class GoSquare extends Square{
    Players p;
    public GoSquare(String name, int price, int rent) {
		super(name, price, rent);
	}
    // add 200 money to the players account
    public void task (Players p){ //if a player comes to Go Square then 200 will be added to players account
		this.p = p;
        p.addMoney(200);
	}
}
