package model;

import java.io.InputStream;
import java.sql.*;

public class Database {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tsw";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "dado1000";
	
	private Connection con; 
	private final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	
	public Database() throws ClassNotFoundException, SQLException{
		
		Class.forName(DRIVER_CLASS); //load driver
		this.con = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
	}
	
	public ResultSet execQuery(String query) throws SQLException {
		
		ResultSet set = null; 
		
		Statement stmt = this.con.createStatement();
		set = stmt.executeQuery(query);
		return set;
	}

	public void InsertQuery(String query) throws SQLException {
		try {
			Statement stmt = this.con.createStatement();
			stmt.executeUpdate(query);	
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	
	}

	public void insertImage(String codice, String nome, float prezzo, int giorni, String citta, String stato, String descrizione, InputStream foto) throws SQLException{
		
		PreparedStatement stmt = con.prepareStatement("Insert into viaggio values(?,?,?,?,?,?,?,?)");
		stmt.setString(1, codice);
		stmt.setString(2, nome);
		stmt.setFloat(3, prezzo);
		stmt.setInt(4, giorni);
		stmt.setString(5,citta);
		stmt.setString(6, stato);
		stmt.setString(7, descrizione);
		if (foto != null) {
			// fetches input stream of the upload file for the blob column
			stmt.setBlob(8,foto);
		}

		stmt.executeUpdate();
		
	}
		
}
