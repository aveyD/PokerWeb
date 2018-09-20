package poker;

import java.io.Serializable;
import java.util.List;

public class Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int numPlayers = 0;
	private List<Player> players = null;
	private List<String> messages;
	private List<Player> winners;
	private List<Card> flopTurnRiver;

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public List<Player> getWinners() {
		return winners;
	}

	public void setWinners(List<Player> winners) {
		this.winners = winners;
	}

	public List<Card> getFlopTurnRiver() {
		return flopTurnRiver;
	}

	public void setFlopTurnRiver(List<Card> flopTurnRiver) {
		this.flopTurnRiver = flopTurnRiver;
	}
}
