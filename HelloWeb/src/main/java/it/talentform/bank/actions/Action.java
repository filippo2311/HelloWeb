package it.talentform.bank.actions;

import it.talentform.bank.model.exceptions.DataException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {
	String execute (HttpServletRequest request,HttpServletResponse response) throws DataException;

}