import controller.BibliothekController;
import model.BibliothekModel;
import view.BibliothekView;


public class BibliothekMain {
	public static void main(String[] args) {
		BibliothekModel model = new BibliothekModel();
		BibliothekController controller = new BibliothekController(model);
		BibliothekView view = new BibliothekView(model,controller);
		
		view.start();
	}
}
