
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PokerTest {
	
//	@Before
//	public void setup()
//	{
//		PokerUtil.players = new ArrayList<Player>();
//	}
//
//	@Test
//	public void rankHandsTest()
//	{
//		Player player1 = createPlayer("David", Card.TWO_HEART, Card.THREE_CLUB, Card.FIVE_DIAMOND, Card.KING_CLUB, Card.ACE_SPADE);
//		Player player2 = createPlayer("Shelly", Card.TWO_DIAMOND, Card.THREE_SPADE, Card.FIVE_HEART, Card.KING_DIAMOND, Card.KING_CLUB);
//		Player player3 = createPlayer("Joe", Card.TWO_HEART, Card.TWO_CLUB, Card.FIVE_DIAMOND, Card.FIVE_CLUB, Card.ACE_SPADE);
//		Player player4 = createPlayer("Jane", Card.SEVEN_DIAMOND, Card.SEVEN_SPADE, Card.SEVEN_HEART, Card.KING_DIAMOND, Card.QUEEN_CLUB);
//		Player player5 = createPlayer("Bob", Card.TWO_HEART, Card.THREE_CLUB, Card.FIVE_DIAMOND, Card.FOUR_CLUB, Card.SIX_SPADE);
//		Player player6 = createPlayer("Sue", Card.THREE_SPADE, Card.SEVEN_SPADE, Card.SIX_SPADE, Card.KING_SPADE, Card.QUEEN_SPADE);
//		Player player7 = createPlayer("John", Card.SEVEN_DIAMOND, Card.SEVEN_SPADE, Card.SEVEN_HEART, Card.KING_DIAMOND, Card.KING_CLUB);
//		Player player8 = createPlayer("Jacob", Card.EIGHT_HEART, Card.EIGHT_CLUB, Card.EIGHT_DIAMOND, Card.FOUR_HEART, Card.EIGHT_SPADE);
//		Player player9 = createPlayer("Junior", Card.TEN_SPADE, Card.JACK_SPADE, Card.NINE_SPADE, Card.SEVEN_SPADE, Card.EIGHT_SPADE);
//		
//		PokerUtil.texasHoldem = false;
//		PokerUtil.players.add(player1);
//		PokerUtil.players.add(player2);
//		PokerUtil.players.add(player3);
//		PokerUtil.players.add(player4);
//		PokerUtil.players.add(player5);
//		PokerUtil.players.add(player6);
//		PokerUtil.players.add(player7);
//		PokerUtil.players.add(player8);
//		PokerUtil.players.add(player9);
//		
//		assertNull(PokerUtil.players.get(0).getPokerHandRank());
//		assertNull(PokerUtil.players.get(1).getPokerHandRank());
//		assertNull(PokerUtil.players.get(2).getPokerHandRank());
//		assertNull(PokerUtil.players.get(3).getPokerHandRank());
//		assertNull(PokerUtil.players.get(4).getPokerHandRank());
//		assertNull(PokerUtil.players.get(5).getPokerHandRank());
//		assertNull(PokerUtil.players.get(6).getPokerHandRank());
//		assertNull(PokerUtil.players.get(7).getPokerHandRank());
//		assertNull(PokerUtil.players.get(8).getPokerHandRank());
//		
//		PokerUtil.rankAllHands();
//		
//		assertEquals(PokerHandRank.HIGH_CARD, PokerUtil.players.get(0).getPokerHandRank());
//		assertEquals(PokerHandRank.ONE_PAIR, PokerUtil.players.get(1).getPokerHandRank());
//		assertEquals(PokerHandRank.TWO_PAIR, PokerUtil.players.get(2).getPokerHandRank());
//		assertEquals(PokerHandRank.THREE_OF_A_KIND, PokerUtil.players.get(3).getPokerHandRank());
//		assertEquals(PokerHandRank.STRAIGHT, PokerUtil.players.get(4).getPokerHandRank());
//		assertEquals(PokerHandRank.FLUSH, PokerUtil.players.get(5).getPokerHandRank());
//		assertEquals(PokerHandRank.FULL_HOUSE, PokerUtil.players.get(6).getPokerHandRank());
//		assertEquals(PokerHandRank.FOUR_OF_A_KIND, PokerUtil.players.get(7).getPokerHandRank());
//		assertEquals(PokerHandRank.STRAIGHT_FLUSH, PokerUtil.players.get(8).getPokerHandRank());
//	}
	
	@Test
	public void rankHighCardsHighCardTest()
	{
		PokerHand player1 = createPokerHand(Card.SEVEN_HEART, Card.ACE_CLUB, Card.FIVE_DIAMOND, Card.KING_CLUB, Card.THREE_CLUB);
		PokerHand player2 = createPokerHand(Card.ACE_SPADE, Card.THREE_SPADE, Card.FIVE_CLUB, Card.KING_SPADE, Card.SEVEN_DIAMOND);
		PokerHand player3 = createPokerHand(Card.TWO_SPADE, Card.THREE_DIAMOND, Card.ACE_DIAMOND, Card.KING_DIAMOND, Card.FIVE_SPADE);
		
		List<PokerHand> pokerHands = Arrays.asList(player1, player2, player3);
		List<PokerHand> bestPokerHands = PokerUtil.complexRules(pokerHands, PokerHandRank.HIGH_CARD);
		
		// David and Shelly have the same hand, but Joe has a lower kicker than the winners
		assertEquals(2, bestPokerHands.size());
	}
	
	@Test
	public void rankHighCardsFlushTest()
	{
		PokerHand player1 = createPokerHand(Card.SEVEN_HEART, Card.ACE_HEART, Card.FIVE_HEART, Card.KING_HEART, Card.THREE_HEART);
		PokerHand player2 = createPokerHand(Card.ACE_SPADE, Card.THREE_SPADE, Card.FIVE_SPADE, Card.KING_SPADE, Card.SEVEN_SPADE);
		PokerHand player3 = createPokerHand(Card.TWO_DIAMOND, Card.THREE_DIAMOND, Card.ACE_DIAMOND, Card.KING_DIAMOND, Card.FIVE_DIAMOND);
		
		List<PokerHand> pokerHands = Arrays.asList(player1, player2, player3);
		List<PokerHand> bestPokerHands = PokerUtil.complexRules(pokerHands, PokerHandRank.FLUSH);
		
		// David and Shelly have the same hand, but Joe has a lower kicker than the winners
		assertEquals(2, bestPokerHands.size());
	}
	
	@Test
	public void rankHighCardsStraightTest()
	{
		PokerHand player1 = createPokerHand(Card.SEVEN_HEART, Card.FOUR_CLUB, Card.FIVE_DIAMOND, Card.SIX_CLUB, Card.THREE_CLUB);
		PokerHand player2 = createPokerHand(Card.FOUR_SPADE, Card.THREE_SPADE, Card.FIVE_CLUB, Card.SIX_SPADE, Card.SEVEN_DIAMOND);
		PokerHand player3 = createPokerHand(Card.TWO_SPADE, Card.THREE_DIAMOND, Card.SIX_DIAMOND, Card.FOUR_DIAMOND, Card.FIVE_SPADE);
		
		List<PokerHand> pokerHands = Arrays.asList(player1, player2, player3);
		List<PokerHand> bestPokerHands = PokerUtil.complexRules(pokerHands, PokerHandRank.STRAIGHT);
		
		// David and Shelly have the same hand, but Joe has a lower kicker than the winners
		assertEquals(2, bestPokerHands.size());
	}
	
	@Test
	public void rankHighCardsStraightFlushTest()
	{
		PokerHand player1 = createPokerHand(Card.SEVEN_CLUB, Card.FOUR_CLUB, Card.FIVE_CLUB, Card.SIX_CLUB, Card.THREE_CLUB);
		PokerHand player2 = createPokerHand(Card.FOUR_SPADE, Card.THREE_SPADE, Card.FIVE_SPADE, Card.SIX_SPADE, Card.SEVEN_SPADE);
		PokerHand player3 = createPokerHand(Card.TWO_DIAMOND, Card.THREE_DIAMOND, Card.SIX_DIAMOND, Card.FOUR_DIAMOND, Card.FIVE_DIAMOND);
		
		List<PokerHand> pokerHands = Arrays.asList(player1, player2, player3);
		List<PokerHand> bestPokerHands = PokerUtil.complexRules(pokerHands, PokerHandRank.STRAIGHT_FLUSH);
		
		// David and Shelly have the same hand, but Joe has a lower kicker than the winners
		assertEquals(2, bestPokerHands.size());
	}
	
	@Test
	public void rankPairsOnePairTest()
	{
		PokerHand player1 = createPokerHandWithHighPair(Rank.SEVEN, Card.SEVEN_HEART, Card.QUEEN_CLUB, Card.FIVE_DIAMOND, Card.KING_CLUB, Card.SEVEN_CLUB);
		PokerHand player2 = createPokerHandWithHighPair(Rank.SEVEN, Card.QUEEN_SPADE, Card.SEVEN_SPADE, Card.FIVE_CLUB, Card.KING_SPADE, Card.SEVEN_DIAMOND);
		PokerHand player3 = createPokerHandWithHighPair(Rank.THREE, Card.TWO_SPADE, Card.THREE_DIAMOND, Card.ACE_DIAMOND, Card.THREE_SPADE, Card.FIVE_SPADE);
		
		List<PokerHand> players = Arrays.asList(player1, player2, player3);
		List<PokerHand> winners = PokerUtil.rankPairs(players, 2);
		
		// David and Shelly have the same hand, but Joe has a lower kicker than the winners
		assertEquals(2, winners.size());
	}
	
	@Test
	public void rankPairsTwoPairTest()
	{
		PokerHand player1 = createPokerHandWithHighPair(Rank.SEVEN, Card.SEVEN_HEART, Card.QUEEN_CLUB, Card.FIVE_DIAMOND, Card.FIVE_CLUB, Card.SEVEN_CLUB);
		PokerHand player2 = createPokerHandWithHighPair(Rank.SEVEN, Card.QUEEN_SPADE, Card.SEVEN_SPADE, Card.FIVE_HEART, Card.FIVE_SPADE, Card.SEVEN_DIAMOND);
		PokerHand player3 = createPokerHandWithHighPair(Rank.FOUR, Card.FOUR_SPADE, Card.THREE_CLUB, Card.ACE_DIAMOND, Card.THREE_DIAMOND, Card.FOUR_DIAMOND);
		
		List<PokerHand> players = Arrays.asList(player1, player2, player3);
		List<PokerHand> winners = PokerUtil.rankPairs(players, 2);
		
		// David and Shelly have the same hand, but Joe has a lower kicker than the winners
		assertEquals(2, winners.size());
	}
	
	@Test
	public void rankPairsThreeOfAKindTest()
	{
		PokerHand player1 = createPokerHandWithHighPair(Rank.QUEEN, Card.QUEEN_HEART, Card.QUEEN_CLUB, Card.FIVE_DIAMOND, Card.QUEEN_SPADE, Card.SEVEN_CLUB);
		PokerHand player2 = createPokerHandWithHighPair(Rank.SEVEN, Card.QUEEN_DIAMOND, Card.SEVEN_SPADE, Card.SEVEN_CLUB, Card.KING_SPADE, Card.SEVEN_DIAMOND);
		PokerHand player3 = createPokerHandWithHighPair(Rank.THREE, Card.TWO_SPADE, Card.THREE_DIAMOND, Card.ACE_DIAMOND, Card.THREE_SPADE, Card.THREE_CLUB);
		
		List<PokerHand> players = Arrays.asList(player1, player2, player3);
		List<PokerHand> winners = PokerUtil.rankPairs(players, 3);
		
		// There can only be one winner in 3 of a kind since there are only 4 ranks
		assertEquals(1, winners.size());
	}
	
	@Test
	public void rankPairsFullHouseTest()
	{
		PokerHand player1 = createPokerHandWithHighPair(Rank.QUEEN, Card.QUEEN_HEART, Card.QUEEN_CLUB, Card.FIVE_DIAMOND, Card.QUEEN_SPADE, Card.FIVE_CLUB);
		PokerHand player2 = createPokerHandWithHighPair(Rank.SEVEN, Card.KING_DIAMOND, Card.SEVEN_SPADE, Card.SEVEN_CLUB, Card.KING_SPADE, Card.SEVEN_DIAMOND);
		PokerHand player3 = createPokerHandWithHighPair(Rank.THREE, Card.TWO_SPADE, Card.THREE_DIAMOND, Card.TWO_DIAMOND, Card.THREE_SPADE, Card.THREE_CLUB);
		
		List<PokerHand> players = Arrays.asList(player1, player2, player3);
		List<PokerHand> winners = PokerUtil.rankPairs(players, 3);
		
		// There can only be one winner in a full house since there are only 4 ranks
		assertEquals(1, winners.size());
	}
	
	@Test
	public void rankPairsFourOfAKindTest()
	{
		PokerHand player1 = createPokerHandWithHighPair(Rank.QUEEN, Card.QUEEN_HEART, Card.QUEEN_CLUB, Card.QUEEN_DIAMOND, Card.QUEEN_SPADE, Card.FIVE_CLUB);
		PokerHand player2 = createPokerHandWithHighPair(Rank.SEVEN, Card.SEVEN_HEART, Card.SEVEN_SPADE, Card.SEVEN_CLUB, Card.KING_SPADE, Card.SEVEN_DIAMOND);
		PokerHand player3 = createPokerHandWithHighPair(Rank.THREE, Card.TWO_SPADE, Card.THREE_DIAMOND, Card.THREE_HEART, Card.THREE_SPADE, Card.THREE_CLUB);
		
		List<PokerHand> players = Arrays.asList(player1, player2, player3);
		List<PokerHand> winners = PokerUtil.rankPairs(players, 4);
		
		// There can only be one winner in a 4 of a kind since there are only 4 ranks
		assertEquals(1, winners.size());
	}
	
//	@Test
//	public void testMain() throws Exception
//	{
//		PokerUtil.readFromConsole = false;
//		Bean bean = new Bean();
//		bean.setNumPlayers(6);
//		PokerUtil.run(bean);
//	}
	
//	@Test
//	public void testPokerDealerTexasHoldem() throws Exception {
//		int numDeals = 0;
//		boolean winningHand = false;
//		PokerUtil.dealer = true;
//		PokerUtil.numPlayers = 6;
//		PokerUtil.texasHoldem = true;
//		while (winningHand == false) {
//			PokerUtil.main(null);
//			for (Player player : PokerUtil.players) {
//				if (player.getPokerHandRank().equals(PokerHandRank.STRAIGHT_FLUSH)) {
//					System.out.println("We have a winner!!! after [" + numDeals + "] deals.");
//					System.out.println(player.printPlayerHand());
//					winningHand = true;
//				}
//				numDeals++;
//			}
//		}
//	}
//
//	@Test
//	public void testPokerDealer() throws Exception {
//		int numDeals = 0;
//		boolean winningHand = false;
//		PokerUtil.dealer = true;
//		PokerUtil.numPlayers = 6;
//		PokerUtil.texasHoldem = false;
//		while (winningHand == false) {
//			PokerUtil.main(null);
//			for (Player player : PokerUtil.players) {
//				if (player.getPokerHandRank().equals(PokerHandRank.STRAIGHT_FLUSH)) {
//					System.out.println("We have a winner!!! after [" + numDeals + "] deals.");
//					System.out.println(player.printPlayerHand());
//					winningHand = true;
//				}
//				numDeals++;
//			}
//		}
//	}
	
	private Player createPlayer(String name, Card... cards) {
		Player player = new Player();
		player.setName(name);
		player.setCards(Arrays.asList(cards));
		return player;
	}

	private PokerHand createPokerHand(Card... cards) {
		PokerHand pokerHand = new PokerHand(Arrays.asList(cards));
		return pokerHand;
	}

	private PokerHand createPokerHandWithHighPair(Rank highPair, Card... cards) {
		PokerHand pokerHand = new PokerHand(Arrays.asList(cards));
		pokerHand.setHighPair(highPair);
		return pokerHand;
	}
}
