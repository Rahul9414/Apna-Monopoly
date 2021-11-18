import java.util.Random;


public class Die {

	public int getFace() {
		Random rand = new Random();
		int face = 1+rand.nextInt(6); //random no. between 1 and 6
		return face;
	}
}