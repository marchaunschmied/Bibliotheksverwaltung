package model;

import java.sql.Date;

/**
 * This class represents a Kunde. The Interface ITable has to be implemented. Every table class has a getFields
 * function which is required to get e.g names oder other information instead of the id
 * 
 * @author MarcAnton
 * 
 */

public class Kunde implements ITable {

	private int id;
	private String name;
	private Date gbdatum;
	private String strasse;
	private String wohnort;
	private String plz;

	public Kunde() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getGbdatum() {
		return gbdatum;
	}

	public void setGbdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getWohnort() {
		return wohnort;
	}

	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	/**
	 * Is required for the GUI. A tablemodel needs an object array for insertion
	 * 
	 * @return every field in an Object array
	 */
	public Object[] getFields() {
		Object[] fields = { id, name, gbdatum, strasse, wohnort, plz };
		return fields;
	}

	/**
	 *  @return the name of the table
	 */
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Kunde";
	}

}
