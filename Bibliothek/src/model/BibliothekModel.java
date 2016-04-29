package model;

import java.util.ArrayList;

public class BibliothekModel {
	
	public DatabaseConnection connection = null;

	
	public BibliothekModel(){
		connection = new DatabaseConnection();
	}


	public DatabaseConnection getConnection() {
		return connection;
	}


}
