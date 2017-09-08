import java.util.Scanner;

public class Intro {
	//Returns 17
	public int ret() {
		return 17;
	}
	
	/**
	 * Returns the logical and of three given booleans
	 * @param a - boolean you want to compare
	 * @param b - boolean you want to compare
	 * @param c - boolean you want to compare
	 * @return The logical and of the three given booleans
	 */
	public boolean logic(boolean a, boolean b, boolean c) {
		return a&&b&&c;
	}
	
	/**
	 * Prints out a left justified pyramid of stars with given row number n
	 * @param n - Rows of stars to print
	 * @return pyramid - the string that represents the desired pyramid
	 */
	public String stars(int n) {
		String pyramid = "";
		for(int x = 1; x <= n; x++) {
			for(int y = 0; y < x; y++) {
				pyramid += "*";
			}
			pyramid += "\n";
		}
		return pyramid;
	}
	
	/**
	 *Returns the minimun number of 2cent and 5cent coins that go into the amount of money to exchange, Returns negative 1 if not possible
	 * @param n - cents that you want to exchange
	 * @return Minimun number of 2cent and 5cent coins that go into the amount of money to exchange, Returns negative 1 if not possible
	 */
	public static int coins(int n) {
		int remainder = n % 5;
		int numOfNickels = (n-remainder)/5;
		int numOfTwoCentCoins = remainder/2;
		if(numOfNickels * 5 + numOfTwoCentCoins * 2 == n) {
			return numOfNickels + numOfTwoCentCoins;
		}
		numOfNickels -= 1;
		numOfTwoCentCoins = (n - numOfNickels*5)/2;
		if(numOfNickels * 5 + numOfTwoCentCoins * 2 == n) {
			return numOfNickels + numOfTwoCentCoins;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(coins(1));
	}
}
