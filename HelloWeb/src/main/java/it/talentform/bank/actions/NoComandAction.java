package it.talentform.bank.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NoComandAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "404.jsp";
	}

}
