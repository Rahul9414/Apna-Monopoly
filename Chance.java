import java.util.ArrayList;

import java.util.Random;
public class Chance extends Square{
	ArrayList<Cards> chanceCards = new ArrayList<Cards>();
    public Chance(String name, int price, int rent) {
		super(name, price, rent);
	}
	
	public void task (Players p){
		chanceCards.add(new Cards("Advance to Go Square", 0));
		chanceCards.add(new Cards("It is your birthday. Collect ", 70));
		chanceCards.add(new Cards("From sale of stock you get ",50));
		chanceCards.add(new Cards("Speeding charge fine. Pay ",50));
		chanceCards.add(new Cards("You have won a crossword competition. Collect ", 125));
		chanceCards.add(new Cards("Bank pays you interest. Collect ", 70));
		Random rand = new Random();
		int face = 1+rand.nextInt(6); //returns a random number between 1 and 6
		Cards objCards = chanceCards.get(face-1);
		if((face-1)==0){
			System.out.println(objCards.statement);
			p.updatePosition(0);
		}
		else{
			System.out.println(objCards.statement+objCards.amount);
			p.addMoney(objCards.amount);
		}

	}

}
