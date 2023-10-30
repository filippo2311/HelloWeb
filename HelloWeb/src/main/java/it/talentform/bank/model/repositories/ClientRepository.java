package it.talentform.bank.model.repositories;

import it.talentform.bank.model.Client;
import it.talentform.bank.model.exceptions.DataException;

import java.util.ArrayList;
import java.util.Collection;

public interface ClientRepository {
    boolean deleteById(long id) throws DataException;

    Collection<Client> getAll() throws DataException;

    long add(Client c) throws DataException;

    Collection<Client> searchByNameLike(String part) throws DataException;

    Client findById(long id) throws DataException;
}
