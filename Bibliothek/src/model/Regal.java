package model;
/**
 * This class represents a Regal. The Interface ITable has to be implemented. Every table class has a getFields
 * function which is required to get e.g names oder other information instead of the id
 * 
 * @author MarcAnton
 * 
 */

public class Regal implements ITable{
	private int id;
	private int standort_id;
	private int medium_id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStandortId() {
		return standort_id;
	}
	public void setStandortId(int standort_id) {
		this.standort_id = standort_id;
	}
	public int getMediumId() {
		return medium_id;
	}
	public void setMediumId(int medium_id) {
		this.medium_id = medium_id;
	}
	/**
	 * Is required for the GUI. A tablemodel needs an object array for insertion
	 * 
	 * @return every field in an Object array
	 */
	public Object[] getFields() {
		Object[] fields = {id,standort_id,medium_id};
		return fields;
	}
	
	/**
	 *  @return the name of the table
	 */
	public String getTableName() {
		return "Regal";
	}
}
