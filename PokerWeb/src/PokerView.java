import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
public class PokerView {
	
	public void buttonAction(ActionEvent actionEvent) {
//		Bean bean = (Bean) request.getAttribute("bean");
//		PokerUtil.run(bean);
		addMessage("You are about to deal!!!");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
