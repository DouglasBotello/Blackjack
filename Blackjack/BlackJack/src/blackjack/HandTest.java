package blackjack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HandTest {

	Hand hand;
	Card card1;
	Card card2;
	Card card3;
	Card card4;
	Card card5;
	Card card6;
	Card card7;
	
	
	@Before
	public void setUp() throws Exception
	{
		hand = new Hand();
		card1 = new Card(0,0);
		card2 = new Card(1,1);
		card3 = new Card(2,2);
		card4 = new Card(3,3);
		card5 = new Card(2,0);
		card6 = new Card(0,11);
		card7 = null;
	}

	@Test
	public void testAddCardAndDiscard() 
	{
		assertFalse(hand.addCard(card7));
		assertFalse(hand.addCard(null));
		assertTrue(hand.addCard(card1));
		assertTrue(hand.addCard(card2));
		assertTrue(hand.addCard(card3));
		assertEquals(card3, hand.discard());
		assertEquals(card2, hand.discard());
		assertEquals(card1, hand.discard());
		assertEquals(null, hand.discard());
	}
	
	@Test
	public void testCheckEmpty()
	{
		assertTrue(hand.isEmpty());
		hand.addCard(card1);
		assertFalse(hand.isEmpty());
	}
	
	@Test
	public void testClearHand()
	{
		hand.addCard(card1);
		hand.addCard(card2);
		hand.addCard(card3);
		assertFalse(hand.isEmpty());
		hand.clearHand();
		assertTrue(hand.isEmpty());
	}
	
	@Test
	public void testGetCard()
	{
		hand.addCard(card1);
		hand.addCard(card2);
		hand.addCard(card3);
		assertEquals(card2, hand.getCard(1));
		assertEquals(card3, hand.getCard(0));
		assertEquals(card1, hand.getCard(2));
	}
	
	@Test
	public void testGetDeckSize()
	{
		assertEquals(0, hand.getDeckSize());
		hand.addCard(card1);
		assertEquals(1, hand.getDeckSize());
		hand.addCard(card2);
		hand.addCard(card3);
		assertEquals(3, hand.getDeckSize());
		hand.discard();
		assertEquals(2, hand.getDeckSize());
		hand.clearHand();
		assertEquals(0, hand.getDeckSize());
	}
	
	@Test
	public void testGetPointTotal()
	{
		assertEquals(0, hand.getPointTotal()[0]);
		assertEquals(0, hand.getPointTotal()[1]);
		
		hand.addCard(card2);
		hand.addCard(card3);
		hand.addCard(card4);
		assertEquals(9, hand.getPointTotal()[0]);
		assertEquals(0, hand.getPointTotal()[1]);
		
		hand.addCard(card1);
		assertEquals(9, hand.getPointTotal()[0]);
		assertEquals(1, hand.getPointTotal()[1]);
		
		hand.addCard(card5);
		hand.addCard(card6);
		assertEquals(19, hand.getPointTotal()[0]);
		assertEquals(2, hand.getPointTotal()[1]);
		
		hand.clearHand();
		assertEquals(0, hand.getPointTotal()[0]);
		assertEquals(0, hand.getPointTotal()[1]);
	}
	
	@Test
	public void testGetTopScore()
	{
		hand.addCard(card2);
		assertEquals(2, hand.getTopScore());
		hand.addCard(card3);
		assertEquals(3, hand.getTopScore());
		hand.addCard(card6);
		assertEquals(10, hand.getTopScore());
	}
}
