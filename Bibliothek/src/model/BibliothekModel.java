package model;

import java.util.ArrayList;

public class BibliothekModel {
	
	public ArrayList<Kunde> kundenList;
	public ArrayList<Entlehnung> entlehnungList;
	
	public BibliothekModel(){
		DatabaseConnection db = new DatabaseConnection();
		
		 kundenList = db.getKunden();
		 entlehnungList = db.getEntlehnung();
	}
}
