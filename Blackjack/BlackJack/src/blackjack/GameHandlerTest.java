package blackjack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameHandlerTest {
	
	GameHandler game;

	@Before
	public void setUp() throws Exception {
		game = new GameHandler();
	}
	
	
	/**
	 * tests the getCardType function, making sure that
	 * every card gets represented correctly
	 */
	@Test
	public void testGetCardType() {
		String[] testArray = new String[13];
		for (int i = 0; i < 13; i++)
		{
			testArray[i] = game.getCardType(new Card(0, i));
		}
		assertEquals(testArray[0], "Ace of Hearts");
		assertEquals(testArray[1], "Two of Hearts");
		assertEquals(testArray[2], "Three of Hearts");
		assertEquals(testArray[3], "Four of Hearts");
		assertEquals(testArray[4], "Five of Hearts");
		assertEquals(testArray[5], "Six of Hearts");
		assertEquals(testArray[6], "Seven of Hearts");
		assertEquals(testArray[7], "Eight of Hearts");
		assertEquals(testArray[8], "Nine of Hearts");
		assertEquals(testArray[9], "Ten of Hearts");
		assertEquals(testArray[10], "Jack of Hearts");
		assertEquals(testArray[11], "Queen of Hearts");
		assertEquals(testArray[12], "King of Hearts");
		
		for (int i = 0; i < 13; i++)
		{
			testArray[i] = game.getCardType(new Card(1, i));
		}
		assertEquals(testArray[0], "Ace of Spades");
		assertEquals(testArray[1], "Two of Spades");
		assertEquals(testArray[2], "Three of Spades");
		assertEquals(testArray[3], "Four of Spades");
		assertEquals(testArray[4], "Five of Spades");
		assertEquals(testArray[5], "Six of Spades");
		assertEquals(testArray[6], "Seven of Spades");
		assertEquals(testArray[7], "Eight of Spades");
		assertEquals(testArray[8], "Nine of Spades");
		assertEquals(testArray[9], "Ten of Spades");
		assertEquals(testArray[10], "Jack of Spades");
		assertEquals(testArray[11], "Queen of Spades");
		assertEquals(testArray[12], "King of Spades");
		
		for (int i = 0; i < 13; i++)
		{
			testArray[i] = game.getCardType(new Card(2, i));
		}
		assertEquals(testArray[0], "Ace of Clubs");
		assertEquals(testArray[1], "Two of Clubs");
		assertEquals(testArray[2], "Three of Clubs");
		assertEquals(testArray[3], "Four of Clubs");
		assertEquals(testArray[4], "Five of Clubs");
		assertEquals(testArray[5], "Six of Clubs");
		assertEquals(testArray[6], "Seven of Clubs");
		assertEquals(testArray[7], "Eight of Clubs");
		assertEquals(testArray[8], "Nine of Clubs");
		assertEquals(testArray[9], "Ten of Clubs");
		assertEquals(testArray[10], "Jack of Clubs");
		assertEquals(testArray[11], "Queen of Clubs");
		assertEquals(testArray[12], "King of Clubs");
		
		for (int i = 0; i < 13; i++)
		{
			testArray[i] = game.getCardType(new Card(3, i));
		}
		assertEquals(testArray[0], "Ace of Diamonds");
		assertEquals(testArray[1], "Two of Diamonds");
		assertEquals(testArray[2], "Three of Diamonds");
		assertEquals(testArray[3], "Four of Diamonds");
		assertEquals(testArray[4], "Five of Diamonds");
		assertEquals(testArray[5], "Six of Diamonds");
		assertEquals(testArray[6], "Seven of Diamonds");
		assertEquals(testArray[7], "Eight of Diamonds");
		assertEquals(testArray[8], "Nine of Diamonds");
		assertEquals(testArray[9], "Ten of Diamonds");
		assertEquals(testArray[10], "Jack of Diamonds");
		assertEquals(testArray[11], "Queen of Diamonds");
		assertEquals(testArray[12], "King of Diamonds");
	}
	
	@Test
	public void whoWinsTest()
	{
		assertEquals(0, game.whoWins(21, 21));
		assertEquals(1, game.whoWins(21, 20));
		assertEquals(1, game.whoWins(21, 22));
		assertEquals(1, game.whoWins(10, 5));
		assertEquals(1, game.whoWins(10, 22));
		assertEquals(2, game.whoWins(22, 22));
		assertEquals(2, game.whoWins(22, 20));
		assertEquals(2, game.whoWins(2, 21));
		assertEquals(2, game.whoWins(2, 20));
	}

}
