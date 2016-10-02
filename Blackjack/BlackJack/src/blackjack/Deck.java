package blackjack;

import java.util.Random;

/**
 * Deck can store any number of cards from a full deck to an empty one
 * It cannot store more than one full deck, and have more than one kind
 * if card.
 *
 */
public class Deck {

	
	private int size;
	private Card[] cards;
	private int top;
	
	/**
	 * The constructor for the deck
	 * creates the cards, places them in the deck, then shuffles them.
	 * Sets size to 52
	 */
	public Deck()
	{
		cards = new Card[52];
		initializeDeck();
		shuffleDeck();
		size = 52;
		top = 0;
	}
	
	/**
	 * getter for the size
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * getter for the deck
	 */
	public Card[] getDeck()
	{
		return cards;
	}
	
	
	/**
	 * draws a card from the top of the deck and returns it
	 */
	public Card draw()
	{
		top++;
		size--;
		return cards[top - 1];
	}
	
	/**
	 * Resets deck for new game
	 */
	public void reInitialize()
	{
		initializeDeck();
		shuffleDeck();
		size = 52;
		top = 0;
	}
	
	/**
	 * Places a full deck of cards in the deck
	 */
	private void initializeDeck()
	{
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 13; j++)
			{
				cards[j + (13 * i)] = new Card(i, j); 
			}
		}
	}
	
	/**
	 * Shuffles a full deck.
	 */
	private void shuffleDeck()
	{
		Random random = new Random();
		for (int i = 0; i < 52; i++)
		{
			int randomNum = random.nextInt(52);
			Card holder = cards[i];
			cards[i] = cards[randomNum];
			cards[randomNum] = holder;
		}
	}
	
}
