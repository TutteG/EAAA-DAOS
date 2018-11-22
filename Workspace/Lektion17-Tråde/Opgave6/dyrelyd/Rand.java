package dyrelyd;

public class Rand {
	private int rangeMin;
	private int rangeMax;

	/**
	 * Constructer which set maxRange and minRange, fx for a dice
	 *
	 * @param maxRange
	 * @param minRange
	 */
	public Rand(int maxRange, int minRange) {
		rangeMax = maxRange;
		rangeMin = minRange;
	}

	/**
	 * method that returns a random number between max- and minRange
	 *
	 * @return int
	 */
	public int randomInRange() {
		int range = (rangeMax - rangeMin) + 1;
		return (int) (Math.random() * range) + rangeMin;
	}

}