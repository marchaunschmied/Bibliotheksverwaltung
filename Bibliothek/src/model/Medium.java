package model;
/**
 * This class represents a Medium. The Interface ITable has to be implemented. Every table class has a getFields
 * function which is required to get e.g names oder other information instead of the id
 * 
 * @author MarcAnton
 * 
 */

public class Medium implements ITable {
	private int id;
	private String titel;
	private String typ;
	private String autor;
	private int altersbes;
	private double kosten;
	private String genre;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAltersbes() {
		return altersbes;
	}
	public void setAltersbes(int altersbes) {
		this.altersbes = altersbes;
	}
	public double getKosten() {
		return kosten;
	}
	public void setKosten(double kosten) {
		this.kosten = kosten;
	}

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * Is required for the GUI. A tablemodel needs an object array for insertion
	 * 
	 * @return every field in an Object array
	 */
	public Object[] getFields() {
		Object[] fields = { id, titel, typ, autor, altersbes, kosten,genre };
		return fields;
	}
	/**
	 *  @return the name of the table
	 */
	public String getTableName() {
		return "Medium";
	}
}
