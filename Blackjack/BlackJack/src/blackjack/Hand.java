package blackjack;

/**
 * This class represents the cards that either
 * the player or the dealer currently have
 *
 */
public class Hand {
	
	/**
	 * Node class for singly linked list
	 */
	private static class Node {
		private Card card;
		private Node nextCard;
		
		public Node(Card newCard, Node nextNode)
		{
			card = newCard;
			nextCard = nextNode;
		}
		
		public void setNext(Node node)
		{
			nextCard = node;
		}
		
		public Node getNext()
		{
			return nextCard;
		}
		
		public Card getCard()
		{
			return card;
		}
	}
	
	private int cards;
	private Node top;
	private Node bottom;
	
	/**
	 * constructor for hand. Sets it up empty.
	 */
	public Hand()
	{
		top = null;
		bottom = null;
		cards = 0;
	}
	
	/**
	 * Adds a card to the hand to the top
	 * returns true if it worked, and
	 * false if the card is null
	 */
	public boolean addCard(Card newCard)
	{
		if (newCard == null)
		{
			return false;
		}
		if (top == null)
		{
			bottom = new Node(newCard, null);
			top = bottom;
			cards++;
			return true;
		}
		else
		{
			Node node = new Node(newCard, top);
			top = node;
			cards++;
			return true;
		}
	}
	
	
	/**
	 * gets rid of top card and returns it
	 * null if deck is empty;
	 * @return
	 */
	public Card discard()
	{
		if (isEmpty())
		{
			return null;
		}
		else if (cards == 1)
		{
			Card returnCard = top.getCard();
			top = null;
			bottom = null;
			cards--;
			return returnCard;
		}
		else
		{
			Card returnCard = top.getCard();
			top = top.getNext();
			cards--;
			return returnCard;
		}
	}
	
	/**
	 * True if there are no cards in the hand
	 * False if there are cards in the hand
	 */
	public boolean isEmpty()
	{
		return (top == null);
	}
	
	/**
	 * This method returns a copy of the
	 * card at a certain position in the
	 * linked list starting with 0
	 */
	public Card getCard(int cardPos)
	{
		Node current = top;
		for (int i = 0; i < cardPos; i++)
		{
			current = current.getNext();
		}
		return current.getCard();
	}
	
	/**
	 * This will total the points in the hand
	 * the first int in the array is the point total
	 * the second int is the number of aces
	 */
	public int[] getPointTotal()
	{
		int total;
		Node currentNode = top;
		int[] returnArray = new int[2];
		for (int i = 0; i < cards; i++)
		{
			Card currentCard = currentNode.getCard();
			//if the card is an ace
			if (currentCard.getRank() == 0)
			{
				returnArray[1]++;
			}
			else if (currentCard.getRank() > 0 && currentCard.getRank() < 10)
			{
				returnArray[0] = returnArray[0] + currentCard.getRank() + 1;
			}
			else
			{
				returnArray[0] = returnArray[0] + 10;
			}
			currentNode = currentNode.getNext();
		}
		return returnArray;
	}
	
	/**
	 * This function gets the point score of the newest card
	 * Pre: Card will never be an ace
	 */
	public int getTopScore()
	{
		if (top.getCard().getRank() > 0 && top.getCard().getRank() < 10)
		{
			return top.getCard().getRank() + 1;
		}
		else
		{
			return 10;
		}
	}
	
	/**
	 * Makes hand empty again
	 */
	public void clearHand()
	{
		top = null;
		bottom = null;
		cards = 0;
	}
	
	/**
	 * A getter for the size of the deck
	 */
	public int getDeckSize()
	{
		return cards;
	}
	

}
