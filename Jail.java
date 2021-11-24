public class Jail extends Square{
	Players p;
    public Jail(String name, int price, int rent) {
		super(name, price, rent);
	}
	public void task (Players p){
		this.p = p;
        p.substractMoney(50);
	}
}
