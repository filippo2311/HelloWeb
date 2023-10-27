package it.talentform.bank.actions;

import it.talentform.bank.model.exceptions.DataException;
import it.talentform.bank.model.services.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowClientsAction implements Action {
	
	private ClientService service = new ClientService();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException {
		var clients = service.getAllClients();
		request.setAttribute("ALL_CLIENTS", clients); //diamo la possibilità al jsp di avere accesso ai dati di clients
		return "showClients.jsp";
	}

}
