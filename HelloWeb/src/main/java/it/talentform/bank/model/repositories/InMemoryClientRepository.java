package it.talentform.bank.model.repositories;

import it.talentform.bank.model.Client;
import it.talentform.bank.model.Sex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class InMemoryClientRepository implements ClientRepository {
    private static HashMap<Long,Client> clientMap = new HashMap<>();
    //private static ArrayList<Client> clientList = new ArrayList<>();
    private static long nexId = 7;
    static {
    	Client c1 = new Client("Mario", "Rossi", LocalDate.now(), Sex.MALE, 100, 1000);
    	Client c2 = new Client("Giovanni","Giovanna",LocalDate.now(), Sex.MALE,150, 11500);
    	Client c3 = new Client("Giovanna", "Giovanni", LocalDate.now(), Sex.FEMALE, 500, 2000);
    	Client c4 = new Client("Marina","Marino",LocalDate.now(), Sex.FEMALE,1150, 11500);
    	Client c5 = new Client("Carlo", "Carlino", LocalDate.now(), Sex.MALE, 1000, 10000);
    	Client c6 = new Client("Antonino","Antonuccio",LocalDate.now(), Sex.MALE,1500, 15000);
    	
    	c1.setId(1);
    	c2.setId(2);
    	c3.setId(3);
    	c4.setId(4);
    	c5.setId(5);
    	c6.setId(6);
    	
    	clientMap.put(c1.getId(),c1);
    	clientMap.put(c2.getId(),c2);
    	clientMap.put(c3.getId(),c3);
    	clientMap.put(c4.getId(),c4);
    	clientMap.put(c5.getId(),c5);
    	clientMap.put(c6.getId(),c6);
    }

   /* public boolean deleteById0(long id){
        for(int i=0; i<clientList.size(); i++){
            if(id == clientList.get(i).getId()){
                clientList.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById1(long id) {
        Client toRemove = null;
        for (Client c : clientList){
            if(id == c.getId()){
                toRemove = c; //non è possibile eliminare direttamente l'oggetto durante l'iterazione
                break;
            }
        }
        if(toRemove != null){
            clientList.remove(toRemove);
            return true;
        }
        else {
            return false;
        }
    } */

    @Override
    public boolean deleteById(long id){
        Client c = clientMap.remove(id);
        if(c != null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Collection<Client> getAll(){
        return new ArrayList<>(clientMap.values());
    }
    @Override
    public long add(Client c){
       c.setId(nexId);
       clientMap.put(nexId,c);
       nexId++;
       return c.getId();
    }

    @Override
    public Collection<Client> searchByNameLike(String part){
        ArrayList<Client> users = new ArrayList<>();
        for (Client c : clientMap.values()){
            if (c.containsInName(part)){
                users.add(c);
            }
        }
        return users;
    }

    @Override
    public Client findById(long id){
        return clientMap.get(id);
    }
    /*
    public void temp(){
        Client[] cs = new Client[3];
        cs[0] = new Client("pluto1", "bianchi", LocalDate.now(), Sex.FEMALE, 5000, 1000);
        cs[1] = new Client("pluto2", "bianchi", LocalDate.now(), Sex.FEMALE, 5000, 1000);
        cs[2] = new Client("pluto3", "bianchi", LocalDate.now(), Sex.FEMALE, 5000, 1000);
        Client x = new Client("giovanni", "bianchi", LocalDate.now(), Sex.FEMALE, 5000, 1000);
        /*for(int i=0; i<cs.length; i++){
            cs[i] = x;
        }*/
    /*
        for (Client c : cs) {
            //c.setFirstname("pippo");
            System.out.println(c.getFirstname());
        }
        for (Client c : cs) {
            c = x;
        }
        for(int i=0; i<cs.length; i++){
            Client c = cs[i];
            c = x;
        }
    } */
}
