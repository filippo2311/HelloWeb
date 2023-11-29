package it.talentform.bank.model.services;

import it.talentform.bank.model.Client;
import it.talentform.bank.model.exceptions.DataException;
import it.talentform.bank.model.repositories.ClientRepository;
import it.talentform.bank.model.repositories.InMemoryClientRepository;
import it.talentform.bank.model.repositories.TextFileClientRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class ClientService {
   // private ClientRepository clientRepo = new TextFileClientRepository("clientdata.csv");
	private ClientRepository clientRepo = new InMemoryClientRepository();
    public Collection<Client> getAllClients() throws DataException { //Iterable riporta ogni tipo di lista
    	var clients = clientRepo.getAll();
        return clients;
    }

    public long saveClient(Client c) throws DataException {
        return clientRepo.add(c);
    }

    public Collection<Client> searchClientsByNameLike(String part) throws DataException {
        return clientRepo.searchByNameLike(part);
    }

    public boolean modifyClientDate(long idToModify, LocalDate dateToModify) throws DataException {
        Client c = clientRepo.findById(idToModify);
        if(c == null){
            return false;
        }
        else {
            c.setDateOfBirth(dateToModify);
            return true;
        }
    }

    public boolean deleteClientById(long idToModify) throws DataException {
        return clientRepo.deleteById(idToModify);
    }
}
