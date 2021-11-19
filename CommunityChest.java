import java.util.ArrayList;
import java.util.Random;
public class CommunityChest extends Square {
    ArrayList<Cards> communityChestCards = new ArrayList<>();
    public CommunityChest(String name, int price, int rent) {
		super(name, price, rent);
	}

    public void task (Players p){
		communityChestCards.add(new Cards("Pay hospital ", 50));
		communityChestCards.add(new Cards("Doctor's fee. Pay ", 50));
		communityChestCards.add(new Cards("Pay your insurance premium. ", 50));
		communityChestCards.add(new Cards("From sale of stock you get ",50));
		communityChestCards.add(new Cards("Income tax refund. Collect ", 125));
		communityChestCards.add(new Cards("It is your birthday. Collect  ", 70));
		Random rand = new Random();
		int face = 1+rand.nextInt(6); //returns a random number between 1 and 6
		Cards c = communityChestCards.get(face);
		if(face==0||face==1||face==2){
			System.out.println(c.statement+c.amount);
			p.substractMoney(c.amount);
		}
		else{
			System.out.println(c.statement+c.amount);
			p.addMoney(c.amount);
		}

	}
}
