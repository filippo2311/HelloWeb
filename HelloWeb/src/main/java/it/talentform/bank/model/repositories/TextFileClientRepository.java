package it.talentform.bank.model.repositories;


import it.talentform.bank.model.Client;
import it.talentform.bank.model.DateUtils;
import it.talentform.bank.model.EnumUtils;
import it.talentform.bank.model.Sex;
import it.talentform.bank.model.exceptions.DataException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TextFileClientRepository implements ClientRepository{

    private String textFileName;
    private Path filePath ;
    private long maxId = -1;
    public TextFileClientRepository(String textFileName) {
        this.textFileName= textFileName;
        this.filePath= Paths.get(textFileName);
        if (Files.notExists(filePath)){
            File f = new File(textFileName);
            try {
                f.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public boolean deleteById(long id) {
        return false;
    }
// in un metodo override posso aggiungere eccezioni che non sono presenti
//nel metodo originario? NO perchè?
// in un metodo override posso restringere la visibilità del metodo originario?(se il metodo della madre
//è pubblico posso cambiarlo in protected?) se si/no perchè?
    @Override
    public ArrayList<Client> getAll() throws DataException {
        try {
            List<String> lines = Files.readAllLines(filePath);
            ArrayList<Client> clients= new ArrayList<>();
            for (String s:lines) {
                clients.add(fromCsvLine(s));
            }
            return clients;
        } catch (IOException e) {
            throw new DataException("errore nella lettura su file di tutti i clienti", e);
        }

    }

    @Override
    public long add(Client c) throws DataException {
        //FileWriter writer= null;
        try (FileWriter writer= new FileWriter(this.textFileName, true)){
            readMaxId();
            maxId++;
            c.setId(maxId);
            String line = toCsvLine(c);
            writer.write(System.lineSeparator()+ line);
            return maxId;
        }catch (IOException e){
            throw new DataException("errore della scrittura su file csv", e);
        }
//        finally {
//            try {
//                if (writer != null){
//                    writer.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

    }

    @Override
    public ArrayList<Client> searchByNameLike(String part) {
        return null;
    }

    @Override
    public Client findById(long id) {
        return null;
    }
    //id,Firstname,Lastname,Bithdate(gg/mm/yyyy),Sex,MaxDeficit,Deficit
    public String toCsvLine(Client c)  {

        return String.format(Locale.US,"%d,%s,%s,%s,%s,%.2f,%.2f",c.getId(), c.getFirstname(),c.getLastname(),
                DateUtils.stringFromDate(c.getDateOfBirth()), EnumUtils.sexToString(c.getSex()),
                c.getDeficit(),c.getMaxTotalDeficit());
   }
    public Client fromCsvLine(String line){
        String [] parts= line.split(",");
        LocalDate dob = DateUtils.dateFromString(parts[3]);
        Sex s= EnumUtils.stringToSex(parts[4]);
        double maxDeficit = Double.parseDouble(parts[5]);
        double deficit = Double.parseDouble(parts[6]);
        Client nc= new Client(parts[1],parts[2],dob, s, maxDeficit, deficit);
        nc.setId(Long.parseLong(parts[0]));
        return nc;
    }
    public void readMaxId() throws IOException {
        if (maxId != -1){
            return;
        }
        List<String> lines = Files.readAllLines(filePath);
        for (String s:lines) {
            String [] parts= s.split(",");
            long id = Long.parseLong(parts[0]);
            if (id>maxId){
                maxId=id;
            }
        }
    }
}
