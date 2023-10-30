package it.talentform.bank.actions;

import java.time.LocalDate;

import it.talentform.bank.model.Client;
import it.talentform.bank.model.DateUtils;
import it.talentform.bank.model.EnumUtils;
import it.talentform.bank.model.Sex;
import it.talentform.bank.model.exceptions.DataException;
import it.talentform.bank.model.services.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SaveClientAction implements Action {

	private ClientService service = new ClientService();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws DataException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		Sex s = EnumUtils.stringToSex(request.getParameter("gender"));
		LocalDate d = DateUtils.dateFromString(request.getParameter("birthdate"));
		double deficit = Double.parseDouble(request.getParameter("deficit"));
		double maxDeficit = Double.parseDouble(request.getParameter("maxDeficit"));
		Client c = new Client(firstname, lastname, d, s, maxDeficit, deficit);
		service.saveClient(c);
		return "clientsaved.jsp";
	}

}
