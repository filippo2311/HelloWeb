package it.talentform.bank.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddClientAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "addClientForm.jsp";
	}

}
