package it.talentform.bank.model.repositories;

import it.talentform.bank.model.Client;
import it.talentform.bank.model.exceptions.DataException;

import java.util.ArrayList;

public interface ClientRepository {
    boolean deleteById(long id) throws DataException;

    ArrayList<Client> getAll() throws DataException;

    long add(Client c) throws DataException;

    ArrayList<Client> searchByNameLike(String part) throws DataException;

    Client findById(long id) throws DataException;
}
