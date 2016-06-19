package controller;

import model.BibliothekModel;
import model.Bibliothekar;
import model.Entlehnung;
import model.ITable;
import model.Kunde;
import model.Medium;
import model.Regal;
import model.Standort;

/**
 * The controller gets a table object.The methods in the model are used for the insertion, deleting or changing of data In
 * this case the Controller is just a wrapper for the model classes
 * 
 * @author MarcAnton
 * 
 */

public class BibliothekController {

	private BibliothekModel model;

	public BibliothekController(BibliothekModel model) {
		this.model = model;
	}

	public void insertBibliothekar(Bibliothekar bib) {
		model.getConnection().insertBibliothekar(bib);
	}

	public void insertEntlehnung(Entlehnung ent) {
		model.getConnection().insertEntlehnung(ent);
	}

	public void insertKunde(Kunde kun) {
		model.getConnection().insertKunde(kun);
	}

	public void insertMedium(Medium med) {
		model.getConnection().insertMedium(med);
	}

	public void insertRegal(Regal reg) {
		model.getConnection().insertRegal(reg);
	}

	public void insertStandort(Standort sta) {
		model.getConnection().insertStandort(sta);
	}

}
