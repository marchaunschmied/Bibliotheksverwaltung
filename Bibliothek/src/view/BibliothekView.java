package view;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import controller.BibliothekController;
import model.BibliothekModel;
import model.Bibliothekar;
import model.Entlehnung;
import model.Kunde;
import model.Medium;
import model.Regal;
import model.Standort;

public class BibliothekView {

	BibliothekModel model;
	BibliothekController controller;

	public BibliothekView(BibliothekModel model, BibliothekController controller) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
		this.model = model;

	}

	public void start() {

		Scanner s = new Scanner(System.in);

		while(true){
			System.out.print("Name: ");
			String name = s.nextLine();
			System.out.print("GbDatum: ");
			String gb = s.nextLine();

			// Converts a string to a date
			Date gbDatum = Date.valueOf(gb);

			try{
				// printKunde(model.getConnection().getKundeById(id));
				// printStandort(model.getConnection().getStandortById(id));
				Bibliothekar bib = new Bibliothekar();
				bib.setName(name);
				bib.setGbdatum(gbDatum);
				
				model.getConnection().insertBibliothekar(bib);

			}catch (NullPointerException e){
				System.out.println("Wasser");
			}
		}

	}

	public void printBibliothekar(Bibliothekar b) {
		System.out.print(b.getId() + " \t");
		System.out.print(b.getName() + " \t");
		System.out.print(b.getGbdatum() + " \t");

		System.out.println("");
	}

	public void printEntlehnung(Entlehnung e) {
		System.out.print(e.getId() + " \t");
		System.out.print(model.getConnection().getKundeById(e.getId()).getName() + " \t");
		System.out.print(model.getConnection().getMediumById(e.getMediumId()).getTitel() + " \t");
		System.out.print(e.getVon() + " \t");
		System.out.print(e.getBis() + " \t");

		System.out.println("");
	}

	public void printKunde(Kunde k) {
		System.out.print(k.getId() + " \t");
		System.out.print(k.getName() + " \t");
		System.out.print(k.getGbdatum() + " \t");
		System.out.print(k.getStrasse() + " \t");
		System.out.print(k.getWohnort() + " \t");
		System.out.print(k.getPlz() + " \t");

		System.out.println("");
	}

	public void printMedium(Medium m) {
		System.out.print(m.getId() + " \t");
		System.out.print(m.getTitel() + " \t");
		System.out.print(m.getTyp() + " \t");
		System.out.print(m.getAutor() + " \t");
		System.out.print(m.getAltersbes() + " \t");
		System.out.print(m.getKosten() + " \t");
		System.out.print(m.getGenre() + " \t");

		System.out.println("");
	}

	public void printRegal(Regal r) {
		System.out.print(r.getId() + " \t");
		System.out.print(model.getConnection().getStandortById(r.getStandortId()).getOrt() + " \t");
		System.out.print(model.getConnection().getMediumById(r.getMediumId()).getTitel() + " \t");

		System.out.println("");
	}

	public void printStandort(Standort k) {
		System.out.print(k.getId() + " \t");
		System.out.print(k.getOrt() + " \t");
		System.out.print(k.getPlz() + " \t");
		System.out.print(k.getStrasse() + " \t");
		System.out.print(
				model.getConnection().getBibliothekarById(k.getBibliothekarId()).getName() + " \t");

		System.out.println("");
	}

}
