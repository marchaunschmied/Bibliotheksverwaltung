package model;

public class Standort {
	private int id;
	private int plz;
	private String ort;
	private String strasse;
	private int bibliothekar_id;
	
	
	public int getStandort_id() {
		return id;
	}
	public void setStandort_id(int standort_id) {
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
	public int getBibliothekar_id() {
		return bibliothekar_id;
	}
	public void setBibliothekar_id(int bibliothekar_id) {
		this.bibliothekar_id = bibliothekar_id;
	}
}
