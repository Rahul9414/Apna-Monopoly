import java.util.ArrayList;
import java.util.Random;
public class CommunityChest extends Square {
    ArrayList<Cards> communityChestCards = new ArrayList<>();
    public CommunityChest(String name, int price, int rent) {
		super(name, price, rent);
	}

    public void task (Players p){
		communityChestCards.add(new Cards("Go to free parking", 0));
		communityChestCards.add(new Cards("Annuity matures. Collect ", 50));
		communityChestCards.add(new Cards("You have won second prize in a beauty contest. Collect ", 75));
		communityChestCards.add(new Cards("From sale of stock you get ",50));
		communityChestCards.add(new Cards("Income tax refund. Collect ", 125));
		communityChestCards.add(new Cards("It is your birthday. Collect  ", 70));
		Random rand = new Random();
		int face = 1+rand.nextInt(6); //returns a random number between 1 and 6
		Cards objCards = communityChestCards.get(face-1);
		if((face-1)==0){
			System.out.println(objCards.statement);
			p.updatePosition(10);
		}
		else{
			System.out.println(objCards.statement+objCards.amount);
			p.addMoney(objCards.amount);
		}

	}
}
