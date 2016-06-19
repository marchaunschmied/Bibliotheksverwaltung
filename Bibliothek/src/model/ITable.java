package model;

/**
 * Every table object has to implement this interface It is used to make sure that these methods are implemented in the table
 * class
 * 
 * @author MarcAnton
 *
 */

public interface ITable {

	/**
	 * 
	 * Is required for the GUI. A tablemodel needs an object array for insertion
	 * 
	 * @return every field of the class in an object array
	 */
	public Object[] getFields();

	/**
	 * @return the name of the table
	 */
	public String getTableName();
}
