package model;

import java.sql.Date;

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

	public Object[] getFields() {
		Object[] fields = { id, name, gbdatum, strasse, wohnort, plz };
		return fields;
	}

	
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Kunde";
	}

}
