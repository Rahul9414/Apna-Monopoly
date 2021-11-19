import java.util.ArrayList;

import java.util.Random;
public class Chance extends Square{
	ArrayList<Cards> chanceCards = new ArrayList<Cards>();
    public Chance(String name, int price, int rent) {
		super(name, price, rent);
	}
	
	public void task (Players p){
		chanceCards.add(new Cards("Charges for street repairs ", 50));
		chanceCards.add(new Cards("Pay school fees of ", 50));
		chanceCards.add(new Cards("Drunk in charge fine. Pay ", 50));
		chanceCards.add(new Cards("Speeding charge fine. Pay ",50));
		chanceCards.add(new Cards("You have won a crossword competition. Collect ", 125));
		chanceCards.add(new Cards("Bank pays you interest. Collect ", 70));
		Random rand = new Random();
		int face = 1+rand.nextInt(6); //returns a random number between 1 and 6
		Cards c = chanceCards.get(face);
		if(face==0||face==1||face==2||face==3){
			System.out.println(c.statement+c.amount);
			p.substractMoney(c.amount);
		}
		else{
			System.out.println(c.statement+c.amount);
			p.addMoney(c.amount);
		}

	}

}
