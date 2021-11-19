public class IncomeTax extends Square{
    Players p;
    public IncomeTax(String name, int price, int rent){
        super(name,price,rent);
    }

    //deduct 100 from players account
    public void task (Players p){
		this.p = p;
        System.out.println("Pay Income Tax of 100");
        p.substractMoney(100);
	}
    
}
