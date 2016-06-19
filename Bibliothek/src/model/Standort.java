package model;

/**
 * This class represents a Standort. The Interface ITable has to be implemented. Every table class has a getFields function
 * which is required to get e.g names oder other information instead of the id
 * 
 * @author MarcAnton
 * 
 */

public class Standort implements ITable {
	private int id;
	private int plz;
	private String ort;
	private String strasse;
	private int bibliothekar_id;

	public int getId() {
		return id;
	}

	public void setId(int standort_id) {
		this.id = standort_id;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public int getBibliothekarId() {
		return bibliothekar_id;
	}

	public void setBibliothekarId(int bibliothekar_id) {
		this.bibliothekar_id = bibliothekar_id;
	}

	/**
	 * Is required for the GUI. A tablemodel needs an object array for insertion
	 * 
	 * @return every field in an Object array
	 */
	public Object[] getFields() {
		Object[] fields = { id, plz, ort, strasse, bibliothekar_id };
		return fields;
	}

	/**
	 * @return the name of the table
	 */
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Standort";
	}

}
