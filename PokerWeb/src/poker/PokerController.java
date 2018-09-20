package poker;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PokerController {

	public Bean bean = new Bean();

	@Autowired
	private PokerService pokerService;

	public Bean initBean() {
		bean.setNumPlayers(6);
		return bean;
	}

	public void alert() {
		addMessage("Alert!!!");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void dealPoker(String value) {
		if (value == null) {
			addMessage("Please enter number of players.");
		} else {
			int numPlayers = 6;
			try {
				numPlayers = Integer.parseInt(value);
			} catch (NumberFormatException e) {
				addMessage("Default number of players set to 6.");
			}
			if (numPlayers <= 1 || numPlayers > 10) {
				addMessage("Invalid number of players. Must be between 2-10");
			}
			dealPoker(numPlayers);
		}
	}
	
	public void dealPoker(int numPlayers) {
		bean.setNumPlayers(numPlayers);
		dealPoker(bean);
	}

	public void dealPoker(Bean bean) {
		getPokerService().runPoker(bean);
	}

	public PokerService getPokerService() {
		return pokerService;
	}

	public void setPokerService(PokerService pokerService) {
		this.pokerService = pokerService;
	}

	public Bean getBean() {
		return bean;
	}

	public void setBean(Bean bean) {
		this.bean = bean;
	}
}
