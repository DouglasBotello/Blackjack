package blackjack;

import java.util.Random;

public class GameHandler {

	//Main method.
	public static void main(String args[])
	{
		//create new deck and a hand for each player
		Deck deck = new Deck();
		Hand playerHand = new Hand();
		Hand dealerHand = new Hand();
		System.out.println("Welcome to BlackJack, Developed by Douglas Botello.");
		System.out.println("You are playing against a dealer.\nYou and the dealer will be dealt two cards.");
		//dealing cards for player and dealer
		playerHand.addCard(deck.draw());
		dealerHand.addCard(deck.draw());
		playerHand.addCard(deck.draw());
		dealerHand.addCard(deck.draw());
		//total scores not including aces
		int playerPoints = playerHand.getPointTotal()[0];
		int dealerPoints = dealerHand.getPointTotal()[0];
		//print out results of the deal
		System.out.println("You drew a " + getCardType(playerHand.getCard(1)) + " and"
				+ " a " + getCardType(playerHand.getCard(0)));
		System.out.println("The dealer will reveal one of his cards: "
				+ "it is a " + getCardType(dealerHand.getCard(0)));
		int numAces = playerHand.getPointTotal()[1];
		System.out.print("Your score totals to " + playerPoints);
		if (numAces > 0)
		{
			if (numAces == 1)
			{
				System.out.print(" and 1 Ace");
			}
			else
			{
				System.out.print(" and " + numAces + " Aces");
			}
		}
		
		
		playerPoints = playerTurn(playerPoints, playerHand, deck, numAces);
		
		dealerPoints = dealerTurn(dealerPoints, dealerHand, deck);
		
		System.out.println("All cards are in!");
		System.out.println("Your final score is " + playerPoints);
		System.out.println("The dealer's final score is " + dealerPoints);
		whoWins(playerPoints, dealerPoints);
			
		
	}
	
	/**
	 * Prints out to console the winner of the game,
	 * based on the scores of both of the players
	 * int return value used for testing purposes only
	 * method is public for testing purposes
	 */
	public static int whoWins(int playerPoints, int dealerPoints)
	{
		// draw game
		if (playerPoints == dealerPoints && playerPoints < 22 && dealerPoints < 22 )
		{
			System.out.println("It's a tie! Nobody wins.");
			return 0;
		}
		// player wins
		else if ( (21 - playerPoints < 21 - dealerPoints && playerPoints < 22 && dealerPoints < 22) || (dealerPoints > 21 && playerPoints < 22) )
		{
			System.out.println("You've won! Congratulations!");
			return 1;
		}
		// dealer wins
		else
		{
			System.out.println("The dealer wins. Better luck next time.");
			return 2;
		}
	}
	
	/**
	 * Assigns a string representation of a card based
	 * on its representational data. For instance, passing in
	 * card(0,0) will result in "Ace of Hearts".
	 * method is public for testing purposes
	 */
	public static String getCardType(Card card)
	{
		int suit = card.getSuit();
		int value = card.getRank();
		StringBuilder sb = new StringBuilder();
		if (value == 0)
		{
			sb.append("Ace");
		}
		else if (value == 1)
		{
			sb.append("Two");
		}
		else if (value == 2)
		{
			sb.append("Three");
		}
		else if (value == 3)
		{
			sb.append("Four");
		}
		else if (value == 4)
		{
			sb.append("Five");
		}
		else if (value == 5)
		{
			sb.append("Six");
		}
		else if (value == 6)
		{
			sb.append("Seven");
		}
		else if (value == 7)
		{
			sb.append("Eight");
		}
		else if (value == 8)
		{
			sb.append("Nine");
		}
		else if (value == 9)
		{
			sb.append("Ten");
		}
		else if (value == 10)
		{
			sb.append("Jack");
		}
		else if (value == 11)
		{
			sb.append("Queen");
		}
		else
		{
			sb.append("King");
		}
		if (suit == 0)
		{
			sb.append(" of Hearts");
		}
		else if (suit == 1)
		{
			sb.append(" of Spades");
		}
		else if (suit == 2)
		{
			sb.append(" of Clubs");
		}
		else
		{
			sb.append(" of Diamonds");
		}
		return sb.toString();
	}

	/**
	 * Processes the players turn(s)
	 * takes in human input
	 */
	private static int playerTurn(int playerPoints, Hand playerHand, Deck deck, int numAces)
	{
		boolean gameOver = false;
		//loops until bust, 21, or stand
		while (!gameOver)
		{
			System.out.println("\nWill you hit or stand? Type HIT or STAND");
			String input = System.console().readLine();
			if (input.equalsIgnoreCase("HIT"))
			{
				Card newCard = deck.draw();
				playerHand.addCard(newCard);
				playerPoints = playerHand.getPointTotal()[0];
				System.out.print("You drew a " + getCardType(newCard) + " for"
						+ " a new total score of " + playerPoints + " points");
				//if the new card was an ace
				if (newCard.getRank() == 0)
				{
					numAces++;
				}
				if (numAces > 0)
				{
					if (numAces == 1)
					{
						System.out.print(" and 1 Ace");
					}
					else
					{
						System.out.print(" and " + numAces + " Aces");
					}
				}
				System.out.print("\n");
				//if the score + number of aces all equaling 1 is enough
				//to cause a bust, then cause a bust
				if (playerPoints + numAces > 21)
				{
					System.out.println("You've busted!");
					playerPoints = playerPoints + numAces;
					gameOver = true;
				}
				//if the score is exactly 21 w/o aces
				else if (playerPoints == 21)
				{
					System.out.println("You've hit 21!");
					gameOver = true;
				}
			}
			else if (input.equalsIgnoreCase("STAND"))
			{
				gameOver = true;
				System.out.println("You have chosen to stand.");
				//calculate highest score under 22 with aces
				playerPoints = playerPoints + (11 * numAces);
				while (playerPoints > 21 && numAces != 0)
				{
					playerPoints = playerPoints - 10;
					numAces--;
				}
			}
			//invalid input
			else
			{
				System.out.println("That command is not recognised. "
						+ "Try again");
			}
		}
		
		return playerPoints;
	}

	private static int dealerTurn(int dealerPoints, Hand dealerHand, Deck deck)
	{
		System.out.println("The dealer will now reveal his second card:");
		int dealerAces = dealerHand.getPointTotal( )[1];
		System.out.print("The dealer's second card is"
				+ " a " + getCardType(dealerHand.getCard(1)) + " for a total of "
						+ dealerPoints + " points");
		if (dealerAces > 0)
		{
			if (dealerAces == 1)
			{
				System.out.print(" and 1 Ace");
			}
			else
			{
				System.out.print(" and " + dealerAces + " Aces");
			}
		}
		System.out.print("\n");
		//assume all aces are 11 points
		dealerPoints = dealerPoints + (11 * dealerAces);
		//if both first cards were aces
		if (dealerAces == 2)
		{
			//turn Force an ace to be 1
			dealerPoints = dealerPoints - 10;
		}
		//keep drawing until you have at least 17 points
		while (dealerPoints < 17)
		{
			Card newCard = deck.draw();
			dealerHand.addCard(newCard);
			//if the new card is an ace
			if (newCard.getRank() == 0)
			{
				//if your current score is less than 11, make ace worth 11 points
				if (dealerPoints <= 10)
				{
					dealerPoints = dealerPoints + 11;
					System.out.println("The dealer has drawn "
							+ "a " + getCardType(newCard) + " for 11.");
					System.out.println("The dealer's new score is " + dealerPoints);
				}
				//or make the ace worth 1 point
				else
				{
					dealerPoints++;
					System.out.println("The dealer has drawn "
							+ "a " + getCardType(newCard) + " for 1.");
					System.out.println("The dealer's new score is " + dealerPoints);
				}
			}
			//if the new card is not an ace
			else
			{
				dealerPoints = dealerPoints + dealerHand.getTopScore();
				System.out.println("The dealer has drawn "
						+ "a " + getCardType(newCard));
				System.out.println("The dealer's new score is " + dealerPoints);
				if (dealerPoints > 21)
				{
					System.out.println("The dealer has busted!");
				}
			}
			
		}
		
		return dealerPoints;
	}
}
