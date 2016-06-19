package model;

import java.sql.Date;

import junit.framework.TestCase;

public class BibliothekUnitTest extends TestCase {

	private Bibliothekar bib1;
	private BibliothekModel model;
	
	@Override
	protected void setUp() throws Exception {
	 model = new BibliothekModel();
		
		
		
		bib1 = new Bibliothekar();
		bib1.setName("Wasser");
		bib1.setGbdatum(Date.valueOf("1111-11-11"));
		model.getConnection().insertBibliothekar(bib1);
	}

	public void testBibliothekar() {
		Bibliothekar bib2 = model.getConnection().getBibliothekarById(model.getConnection().getLastEntryId("Bibliothekar"));
		assertTrue(bib2.getName().equals(bib1.getName()));
	}
	
	public void testUpdateBibliothekar(){
		Bibliothekar bib3 = model.getConnection().getBibliothekarById(model.getConnection().getLastEntryId("Bibliothekar"));
		assertTrue(model.getConnection().updateBibliothekar(bib3) == 1);
	}
	
	public void testDeleteBibliothekar(){
		assertTrue(model.getConnection().deleteBibliothekarById(model.getConnection().getLastEntryId("Bibliothekar")) == 1);
	}
}
