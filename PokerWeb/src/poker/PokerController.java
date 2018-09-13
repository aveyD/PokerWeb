package poker;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PokerController {

	@Autowired
	private PokerService pokerService;

	public Bean initBean() {
		addMessage("Init bean...");
		Bean bean = new Bean();
		return bean;
	}

	public void buttonAction(ActionEvent actionEvent) {
		addMessage("You are about to deal!!!");
//		Bean bean = (Bean) request.getAttribute("bean");
//		PokerService.runPoker(bean);
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void dealPoker(Bean bean) {
		addMessage("You are about to deal!!!");
		getPokerService().runPoker(bean);
	}

	public PokerService getPokerService() {
		return pokerService;
	}

	public void setPokerService(PokerService pokerService) {
		this.pokerService = pokerService;
	}
}
