import java.awt.EventQueue;

import controller.BibliothekController;
import model.BibliothekModel;
import view.BibliothekView;
import view.BibliothekViewGUI;


public class BibliothekMain {
	public static void main(String[] args) {
		BibliothekModel model = new BibliothekModel();
		BibliothekController controller = new BibliothekController(model);
		
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try{
					BibliothekViewGUI view = new BibliothekViewGUI(model,controller); 
					view.setVisible(true);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}
