package blackjack;

public class Card {

	/**
	 * An integer that represents the suit.
	 *		0 = hearts
	 *		1 = spades
	 *		2 = clubs
	 *		3 = diamonds
	 */
	private int suit;
	
	/**
	 * An integer that represents the card type
	 * 		0 = ace
	 * 		1-10 = 1-10
	 * 		11 = jack
	 * 		12 = queen
	 * 		13 = king
	 */
	private int rank;
	
	/**
	 * The constructor. Sets the suit and rank.
	 */
	public Card(int type, int value)
	{
		suit = type;
		rank = value;
	}
	
	/**
	 * getter for the suit
	 */
	public int getSuit()
	{
		return suit;
	}
	
	/**
	 * getter for the rank
	 */
	public int getRank()
	{
		return rank;
	}
}
