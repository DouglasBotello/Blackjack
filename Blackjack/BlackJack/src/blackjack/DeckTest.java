package blackjack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {

	Deck deck;
	
	//sets up new deck
	@Before
	public void setUp() throws Exception {
		deck = new Deck();
	}

	//tests setup and shuffle
	@Test
	public void testConstructor() {
		boolean[] noDuplicateArray = new boolean[52];
		//if the card exists, the value in noDuplicateArray at the point where
		//the card would be if it was not shuffled will be true
		for (int i = 0; i < 52; i++)
		{
			int rank = deck.getDeck()[i].getRank();
			int suit = deck.getDeck()[i].getSuit();
			noDuplicateArray[suit * 13 + rank] = true;
		}
		
		
		
		
		boolean anyNonCard = false;
		boolean anyFalse = false;
		Card card = new Card(0, 0);
		//Checks to make sure that all cards in the deck are of the card class
		//then checks to see if there are any cards missing.
		for (int i = 0; i < 52; i++)
		{
			if (deck.getDeck()[i].getClass() != card.getClass())
			{
				anyNonCard = true;
			}
			if (!noDuplicateArray[i])
			{
				anyFalse = true;
			}
		}
		
		//by this logic, if all cards in the deck are valid cards
		//and no card is the same, then all 52 cards should be
		//inside the deck (post shuffle)
		assertFalse(anyNonCard);
		assertFalse(anyFalse);
		
	}
	
	@Test
	public void testDrawCard()
	{
		Card card = new Card(0,0);
		assertEquals(52, deck.getSize());
		assertEquals(card.getClass(), deck.draw().getClass());
		assertEquals(51, deck.getSize());
	}

}
