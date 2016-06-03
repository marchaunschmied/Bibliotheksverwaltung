package model;

import java.sql.Date;

public class Bibliothekar {
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

	public Object[] getFields() {
		Object[] fields = { id, name, gbdatum };
		return fields;
	}
}