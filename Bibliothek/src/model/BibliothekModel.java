package model;

import java.util.ArrayList;

/**
 * The model class is just a wrapper for the database connection because the data is only stored in the database
 * @author MarcAnton
 *
 */
public class BibliothekModel {
	
	
	private DatabaseConnection connection = null;

	
	public BibliothekModel(){
		connection = new DatabaseConnection();
	}


	/**
	 * 
	 * @return the Databaseconnection
	 */
	public DatabaseConnection getConnection() {
		return connection;
	}


}
