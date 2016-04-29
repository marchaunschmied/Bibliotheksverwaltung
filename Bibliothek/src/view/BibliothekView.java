package view;

import java.util.ArrayList;
import java.util.Iterator;

import controller.BibliothekController;
import model.BibliothekModel;
import model.Entlehnung;
import model.Kunde;

public class BibliothekView {

	BibliothekModel model;
	BibliothekController controller;

	public BibliothekView(BibliothekModel model, BibliothekController controller) {
		// TODO Auto-generated constructor stub
  		this.controller = controller;
  		this.model = model;
  		
	}

	public void start() {
		ArrayList<Kunde> list = model.kundenList;
		ArrayList<Entlehnung> entlehnungList = model.entlehnungList;
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();){
			Kunde kunde = (Kunde) iterator.next();
			printKunde(kunde);
		}
		System.out.println("");
		for (Iterator iterator = entlehnungList.iterator(); iterator.hasNext();){
			Entlehnung entlehnung = (Entlehnung) iterator.next();
			printEntlehnung(entlehnung);
		}
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
	
	public void printEntlehnung(Entlehnung e) {
		System.out.print(e.getId() + " \t");
		System.out.print(e.getKunde_id() + " \t");
		System.out.print(e.getMedium_id() + " \t");
		System.out.print(e.getVon() + " \t");
		System.out.print(e.getBis() + " \t");
		

		System.out.println("");
	}

}
