package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BibliothekController;
import model.BibliothekModel;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * This class is partly auto-generated. For the GUI the Eclipse Window Builder is used
 * @author MarcAnton
 *
 */
public class BibliothekViewGUI extends JFrame {
	
	private BibliothekModel model;
	private BibliothekController controller;

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public BibliothekViewGUI(BibliothekModel model, BibliothekController controller) {
		
		this.model = model;
		this.controller = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		/**
		 * TableModel is used for the data storage in the table
		 */
		BibliothekarTableModel bibTableModel = new BibliothekarTableModel();
		table = new JTable(bibTableModel);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 5;
		gbc_table.gridy = 3;
		contentPane.add(table, gbc_table);
		
		/**
		 * Every value has to be set 
		 */
		bibTableModel.setValueAt(model.getConnection().getBibliothekarById(2).getId(), 0, 0);
		bibTableModel.setValueAt(model.getConnection().getBibliothekarById(2).getName(), 0, 1);
		
		bibTableModel.setValueAt(model.getConnection().getBibliothekarById(1).getId(), 1, 0);
		bibTableModel.setValueAt(model.getConnection().getBibliothekarById(1).getName(), 1, 1);
		
	}


}
