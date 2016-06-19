package model;

import java.sql.Date;

/**
 * This class represents a Bibliothekar The Interface ITable has to be implemented. Every table class has a getFields
 * function which is required to get e.g names oder other information instead of the id
 * 
 * @author MarcAnton
 * 
 */
public class Bibliothekar implements ITable {
	private int id;
	private String name;
	private Date gbdatum;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getGbdatum() {
		return gbdatum;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGbdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}

	
	/**
	 * Is required for the GUI. A tablemodel needs an object array for insertion
	 * @return every field in an Object array 
	 */
	public Object[] getFields() {
		Object[] fields = { id, name, gbdatum };
		return fields;
	}
	
	/**	
	 *	 * @return the name of the table
	 */
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Bibliothekar";
	}
}