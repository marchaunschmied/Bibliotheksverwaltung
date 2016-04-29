package model;

import java.util.Date;

public class Entlehnung {
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
	public int getKunde_id() {
		return kunde_id;
	}
	public void setKunde_id(int kunde_id) {
		this.kunde_id = kunde_id;
	}
	public int getMedium_id() {
		return medium_id;
	}
	public void setMedium_id(int medium_id) {
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
}
