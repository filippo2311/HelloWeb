package it.talentform.bank.model.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import it.talentform.bank.model.Client;
import it.talentform.bank.model.exceptions.DataException;

public class JdbcClientRepository implements ClientRepository{
	private Connection conn;
	private static final String QUERY_FIND_BY_ID = """
													SELECT id, firstname, lastname, date_of_birth
													FROM clients
													WHERE id = ?
													""";
	
	
	public JdbcClientRepository(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean deleteById(long id) throws DataException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Client> getAll() throws DataException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public long add(Client c) throws DataException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<Client> searchByNameLike(String part) throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findById(long id) throws DataException {
		try (PreparedStatement ps = conn.prepareStatement(QUERY_FIND_BY_ID)){
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()){
				if (rs.next()) {
					Client c = new Client(rs.getLong("id"), rs.getString("firstname"),  
							rs.getString("lastname"),  rs.getDate("date_of_birth").toLocalDate());
					return c;
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw new DataException("errore nella ricerca per ID", e);
		}

	}

}
