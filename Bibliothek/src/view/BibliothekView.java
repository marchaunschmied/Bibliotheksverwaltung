package view;

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
			System.out.print("Welche ID anzeigen?: ");
			int id = s.nextInt();
			try{
				printKunde(model.getConnection().getKundeById(id));
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
		System.out.print(e.getKunde_id() + " \t");
		System.out.print(e.getMedium_id() + " \t");
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
		System.out.print("foo" + " \t");

		System.out.println("");
	}

	public void printRegal(Regal r) {

		System.out.print("foo" + " \t");

		System.out.println("");
	}

	public void printStandort(Standort k) {
		System.out.print("foo" + " \t");

		System.out.println("");
	}

}
