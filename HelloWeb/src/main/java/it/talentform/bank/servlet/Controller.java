package it.talentform.bank.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.talentform.bank.actions.Action;
import it.talentform.bank.actions.AddClientAction;
import it.talentform.bank.actions.ClientModifiedAction;
import it.talentform.bank.actions.ModifyClientAction;
import it.talentform.bank.actions.NoComandAction;
import it.talentform.bank.actions.SaveClientAction;
import it.talentform.bank.actions.SearchClientAction;
import it.talentform.bank.actions.SearchResultAction;
import it.talentform.bank.actions.ShowClientsAction;
import it.talentform.bank.model.exceptions.DataException;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println(request.getRequestURI());
		String uri = request.getRequestURI();
		int pos = uri.lastIndexOf('/') + 1; // pos = posizione di s
		// ci dà l'ultimo carattere all'interno della stringa in ()
		int endPos = uri.length() - 3;
		String commandUrl = uri.substring(pos, endPos);
		Action command = null;
		switch (commandUrl.toLowerCase()) {
		case "showclients":
			command = new ShowClientsAction();
			break;
		case "addclient":
			command = new AddClientAction();
			break;
		case "saveclient":
			command = new SaveClientAction();
			break;
		case "searchclient":
			command = new SearchClientAction();
			break;
		case "searchclientresult":
			command = new SearchResultAction();
			break;
		case "modifyclient":
			command = new ModifyClientAction();
			break;
		case "clientmodified":
			command = new ClientModifiedAction();
			break;
		default:
			command = new NoComandAction();

		}
		String jspName;
		try {
			jspName = command.execute(request, response);
		} catch (DataException e) {
			e.printStackTrace();
			jspName = "internalError.jsp";
			request.setAttribute("EXCEPTION", e);
		}
		String jspUrl = "/WEB-INF/jsp/" + jspName;
		RequestDispatcher dispatcher = request.getRequestDispatcher(jspUrl);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
