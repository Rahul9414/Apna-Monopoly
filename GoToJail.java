public class GoToJail extends Square {
	public GoToJail(String name, int price, int rent) {
		super(name, price, rent);
	}

    //50 will be deducted from the players account
	public void task (Players p){
		System.out.println(p.getName() + " position is now changed to Jail");
		p.modifiedPosition(5);
	}
}