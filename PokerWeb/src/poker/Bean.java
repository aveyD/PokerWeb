package poker;
import java.io.Serializable;
import java.util.List;

public class Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int numPlayers = 0;
	private List<Player> players = null;
	private List<String> messages;

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
}
