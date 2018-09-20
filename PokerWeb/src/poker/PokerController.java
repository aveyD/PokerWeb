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

	public void dealPoker() {
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
