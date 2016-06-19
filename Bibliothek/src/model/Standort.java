package model;

public class Standort implements ITable{
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

	public Object[] getFields() {
		Object[] fields = {id,plz,ort,strasse,bibliothekar_id};
		return fields;
	}
	
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Standort";
	}

}
