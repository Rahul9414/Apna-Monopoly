public class LuxaryTax extends Square{
    Players p;
    public LuxaryTax(String name, int price, int rent){
        super(name,price,rent);
    }
    public void task (Players p){ //if a player comes to Luxary Tax then we should deduct 100 from his account
		this.p = p;
        System.out.println("Pay Luxary Tax of 100");
        p.substractMoney(100);
	}
}
