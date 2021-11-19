public class Money { //this class handels all the operations related to players money
	int money;
	
	public Money() {
		this.money =1000;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void addMoney(int amount) {
		money += amount;
	}
	
	public void substractMoney(int amount) {
		money -= amount;
	}
	
	public boolean isBrokeOut() {
		return money < 0;
	}
}