
public enum Card {
	TWO_HEART(Rank.TWO, Suit.HEART, "2H"), TWO_CLUB(Rank.TWO, Suit.CLUB, "2C"), TWO_SPADE(Rank.TWO, Suit.SPADE, "2S"),
	TWO_DIAMOND(Rank.TWO, Suit.DIAMOND, "2D"),

	THREE_HEART(Rank.THREE, Suit.HEART, "3H"), THREE_CLUB(Rank.THREE, Suit.CLUB, "3C"),
	THREE_SPADE(Rank.THREE, Suit.SPADE, "3S"), THREE_DIAMOND(Rank.THREE, Suit.DIAMOND, "3D"),

	FOUR_HEART(Rank.FOUR, Suit.HEART, "4H"), FOUR_CLUB(Rank.FOUR, Suit.CLUB, "4C"),
	FOUR_SPADE(Rank.FOUR, Suit.SPADE, "4S"), FOUR_DIAMOND(Rank.FOUR, Suit.DIAMOND, "4D"),

	FIVE_HEART(Rank.FIVE, Suit.HEART, "5H"), FIVE_CLUB(Rank.FIVE, Suit.CLUB, "5C"),
	FIVE_SPADE(Rank.FIVE, Suit.SPADE, "5S"), FIVE_DIAMOND(Rank.FIVE, Suit.DIAMOND, "5D"),

	SIX_HEART(Rank.SIX, Suit.HEART, "6H"), SIX_CLUB(Rank.SIX, Suit.CLUB, "6C"), SIX_SPADE(Rank.SIX, Suit.SPADE, "6S"),
	SIX_DIAMOND(Rank.SIX, Suit.DIAMOND, "6D"),

	SEVEN_HEART(Rank.SEVEN, Suit.HEART, "7H"), SEVEN_CLUB(Rank.SEVEN, Suit.CLUB, "7C"),
	SEVEN_SPADE(Rank.SEVEN, Suit.SPADE, "7S"), SEVEN_DIAMOND(Rank.SEVEN, Suit.DIAMOND, "7D"),

	EIGHT_HEART(Rank.EIGHT, Suit.HEART, "8H"), EIGHT_CLUB(Rank.EIGHT, Suit.CLUB, "8C"),
	EIGHT_SPADE(Rank.EIGHT, Suit.SPADE, "8S"), EIGHT_DIAMOND(Rank.EIGHT, Suit.DIAMOND, "8D"),

	NINE_HEART(Rank.NINE, Suit.HEART, "9H"), NINE_CLUB(Rank.NINE, Suit.CLUB, "9C"),
	NINE_SPADE(Rank.NINE, Suit.SPADE, "9S"), NINE_DIAMOND(Rank.NINE, Suit.DIAMOND, "9D"),

	TEN_HEART(Rank.TEN, Suit.HEART, "10H"), TEN_CLUB(Rank.TEN, Suit.CLUB, "10C"),
	TEN_SPADE(Rank.TEN, Suit.SPADE, "10S"), TEN_DIAMOND(Rank.TEN, Suit.DIAMOND, "10D"),

	JACK_HEART(Rank.JACK, Suit.HEART, "JH"), JACK_CLUB(Rank.JACK, Suit.CLUB, "JC"),
	JACK_SPADE(Rank.JACK, Suit.SPADE, "JS"), JACK_DIAMOND(Rank.JACK, Suit.DIAMOND, "JD"),

	QUEEN_HEART(Rank.QUEEN, Suit.HEART, "QH"), QUEEN_CLUB(Rank.QUEEN, Suit.CLUB, "QC"),
	QUEEN_SPADE(Rank.QUEEN, Suit.SPADE, "QS"), QUEEN_DIAMOND(Rank.QUEEN, Suit.DIAMOND, "QD"),

	KING_HEART(Rank.KING, Suit.HEART, "KH"), KING_CLUB(Rank.KING, Suit.CLUB, "KC"),
	KING_SPADE(Rank.KING, Suit.SPADE, "KS"), KING_DIAMOND(Rank.KING, Suit.DIAMOND, "KD"),

	ACE_HEART(Rank.ACE, Suit.HEART, "AH"), ACE_CLUB(Rank.ACE, Suit.CLUB, "AC"), ACE_SPADE(Rank.ACE, Suit.SPADE, "AS"),
	ACE_DIAMOND(Rank.ACE, Suit.DIAMOND, "AD");

	private Rank rank;
	private Suit suit;
	private String str;

	Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	Card(Rank rank, Suit suit, String str) {
		this.rank = rank;
		this.suit = suit;
		this.setStr(str);
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public static Card getCardFromRankAndSuit(Rank rank, Suit suit) {
		Card card = null;
		for (Card e : Card.values()) {
			if (e.rank == rank && e.suit == suit) {
				card = e;
				break;
			}
		}
		return card;
	}

	@Override
	public String toString() {
		return str;
	}
}
