import java.awt.EventQueue;

/**
 * 
 *  This is the main class for the programm
 * It is based on a MVC Patter
 * @author MarcAnton

 */
import controller.BibliothekController;
import model.BibliothekModel;
import view.BibliothekView;
import view.BibliothekViewGUI;

public class BibliothekMain {
	public static void main(String[] args) {

		BibliothekModel model = new BibliothekModel();
		BibliothekController controller = new BibliothekController(model);

		/**
		 * This is the main thread
		 */
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try{
					BibliothekViewGUI view = new BibliothekViewGUI(model, controller);
					view.setVisible(true);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}
