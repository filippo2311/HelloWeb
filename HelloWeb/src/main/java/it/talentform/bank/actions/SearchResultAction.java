package it.talentform.bank.actions;
import java.util.Collection;

import it.talentform.bank.model.Client;
import it.talentform.bank.model.exceptions.DataException;
import it.talentform.bank.model.services.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchResultAction implements Action {
	
	private ClientService service = new ClientService();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException{
		String word = request.getParameter("wordToSearch");
		Collection<Client> resultList = service.searchClientsByNameLike(word);
		
		request.setAttribute("RESULT_LIST", resultList); 
		
		return "searchClientResult.jsp";
	}
}
