package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BibliothekController;
import model.BibliothekModel;
import model.Bibliothekar;

import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;

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
	private JButton btnNeuerBibliothekar;
	private JButton btnLschen;
	private JPanel panel;
	private JPanel panel_1;
	private JTabbedPane tabbedPane;
	private JButton btnndern;

	/**
	 * Create the frame.
	 */
	public BibliothekViewGUI(BibliothekModel model, BibliothekController controller) {
		
		this.model = model;
		this.controller = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		/**
		 * TableModel is used for the data storage in the table
		 */
		BibliothekarTableModel bibTableModel = new BibliothekarTableModel();
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Bibliothekar", panel);
		//panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNeuerBibliothekar, scrollPane, table, btnLschen}));
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable(bibTableModel);
		scrollPane.setViewportView(table);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{119, 0};
		gbl_panel_1.rowHeights = new int[]{0, 23, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnNeuerBibliothekar = new JButton("Neuer Bibliothekar");
		GridBagConstraints gbc_btnNeuerBibliothekar = new GridBagConstraints();
		gbc_btnNeuerBibliothekar.insets = new Insets(0, 0, 5, 0);
		gbc_btnNeuerBibliothekar.anchor = GridBagConstraints.WEST;
		gbc_btnNeuerBibliothekar.gridx = 0;
		gbc_btnNeuerBibliothekar.gridy = 0;
		panel_1.add(btnNeuerBibliothekar, gbc_btnNeuerBibliothekar);
		
		btnLschen = new JButton("L\u00F6schen");
		GridBagConstraints gbc_btnLschen = new GridBagConstraints();
		gbc_btnLschen.insets = new Insets(0, 0, 5, 0);
		gbc_btnLschen.gridx = 0;
		gbc_btnLschen.gridy = 1;
		panel_1.add(btnLschen, gbc_btnLschen);
		
		btnndern = new JButton("\u00C4ndern");
		GridBagConstraints gbc_btnndern = new GridBagConstraints();
		gbc_btnndern.insets = new Insets(0, 0, 5, 0);
		gbc_btnndern.gridx = 0;
		gbc_btnndern.gridy = 2;
		panel_1.add(btnndern, gbc_btnndern);
		btnLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.getConnection().deleteBibliothekarById((int)bibTableModel.getValueAt(table.getSelectedRow(), 0));
			}
		});
		btnNeuerBibliothekar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bibliothekar b  = new Bibliothekar();
				b.setName("Tester");
				b.setGbdatum(Date.valueOf("1900-01-01"));
				model.getConnection().insertBibliothekar(b);
			}
		});
		
		/**
		 * Every value has to be set 
		 */
		bibTableModel.setValueAt(model.getConnection().getBibliothekarById(2).getId(), 0, 0);
		bibTableModel.setValueAt(model.getConnection().getBibliothekarById(2).getName(), 0, 1);
		bibTableModel.setValueAt(model.getConnection().getBibliothekarById(2).getGbdatum(), 0, 2);
		
		bibTableModel.setValueAt(model.getConnection().getBibliothekarById(1).getId(), 1, 0);
		bibTableModel.setValueAt(model.getConnection().getBibliothekarById(1).getName(), 1, 1);
		bibTableModel.setValueAt(model.getConnection().getBibliothekarById(1).getGbdatum(), 1, 2);
		
		bibTableModel.setValueAt(model.getConnection().getBibliothekarById(6).getId(), 2, 0);
		bibTableModel.setValueAt(model.getConnection().getBibliothekarById(6).getName(), 2, 1);
		bibTableModel.setValueAt(model.getConnection().getBibliothekarById(6).getGbdatum(), 2, 2);
		
	}


}
