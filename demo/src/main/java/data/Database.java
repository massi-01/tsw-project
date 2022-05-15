package data;

import java.io.InputStream;
import java.sql.*;

public class Database {

	public enum QueryStatus{
		QUERY_SUCCESS,
		QUERY_ERROR
	};

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tsw";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "dado1000";
	
	private Connection conn; 
	private final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	
	public Database(){
		
		try{
			Class.forName(DRIVER_CLASS); //load driver
			this.conn = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public ResultSet execQuery(String query) throws SQLException {
		
		ResultSet set = null; 
		try{
			Statement stmt = this.conn.createStatement();
			set = stmt.executeQuery(query);
		}catch(Exception ex){

		}
		return set;
	}

	public QueryStatus InsertQuery(String query) throws SQLException {
		QueryStatus status = QueryStatus.QUERY_SUCCESS;

		try {
			Statement stmt = this.conn.createStatement();
			stmt.executeUpdate(query);	
		} catch (Exception e) {
			status = QueryStatus.QUERY_ERROR;
		}
	
		return stauts;
	}

	public QueryStatus insertImage(
		String codice, String nome, float prezzo,
		int giorni, String citta, String stato, 
		String descrizione, InputStream foto
	){
		
		QueryStatus status = QueryStatus.QUERY_SUCCESS;

		try{
			PreparedStatement stmt = conn
				.prepareStatement("Insert into viaggio values(?,?,?,?,?,?,?,?)");

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
		}catch(Exception ex){
			status = QueryStatus.QUERY_ERROR;
		}

		return status;
	}
		
}
