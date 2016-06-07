package model;

public class Regal {
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
	public Object[] getFields() {
		Object[] fields = {id,standort_id,medium_id};
		return fields;
	}
}
