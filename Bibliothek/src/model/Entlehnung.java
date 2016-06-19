package model;

import java.sql.Date;

/**
 * This class represents a Entlehnung. The Interface ITable has to be implemented. Every table class has a getFields
 * function which is required to get e.g names oder other information instead of the id
 * 
 * @author MarcAnton
 * 
 */
public class Entlehnung implements ITable {
	private int id;
	private int kunde_id;
	private int medium_id;
	private Date von;
	private Date bis;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKundeId() {
		return kunde_id;
	}

	public void setKundeId(int kunde_id) {
		this.kunde_id = kunde_id;
	}

	public int getMediumId() {
		return medium_id;
	}

	public void setMediumId(int medium_id) {
		this.medium_id = medium_id;
	}

	public Date getVon() {
		return von;
	}

	public void setVon(Date von) {
		this.von = von;
	}

	public Date getBis() {
		return bis;
	}

	public void setBis(Date bis) {
		this.bis = bis;
	}

	/**
	 * Is required for the GUI. A tablemodel needs an object array for insertion
	 * 
	 * @return every field in an Object array
	 */
	public Object[] getFields() {
		Object[] fields = { id, kunde_id, medium_id, von, bis };
		return fields;
	}

	/**
	 * @return the name of the table
	 */
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Entlehnung";
	}
}
