public class Jail extends Square{
	Players p;
    public Jail(String name, int price, int rent) {
		super(name, price, rent);
	}
	public void task (Players p){ //we have done a simple implementation of jail.
		this.p = p;
		System.out.println("75 will be deducted from the "+ p.getName()+" funds.");
        p.substractMoney(75);
	}
}
