package it.talentform.bank.actions;

import java.util.Collection;

import it.talentform.bank.model.Client;
import it.talentform.bank.model.exceptions.DataException;
import it.talentform.bank.model.services.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowClientsAction implements Action {
	
	private ClientService service = new ClientService();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException {
		Collection<Client> clients = service.getAllClients();
		request.setAttribute("ALL_CLIENTS", clients); //diamo la possibilità al jsp di avere accesso ai dati di clients
		return "showClients.jsp";
	}
}
