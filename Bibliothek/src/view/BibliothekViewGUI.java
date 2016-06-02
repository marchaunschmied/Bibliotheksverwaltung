package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BibliothekController;
import model.BibliothekModel;
import model.Bibliothekar;
import model.Entlehnung;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * This class is partly auto-generated. For the GUI the Eclipse Window Builder is used
 * 
 * @author MarcAnton
 *
 */
public class BibliothekViewGUI extends JFrame {

	private BibliothekModel model;
	private BibliothekController controller;

	private JPanel contentPane;
	private JTable bibTable;
	private JButton btnNeu;
	private JButton btnLschen;
	private JPanel bibPanel;
	private JPanel panel_1;
	private JTabbedPane tabbedPane;
	private JButton btnndern;
	private JPanel entPanel;
	private JScrollPane entScrollPane;
	private JTable entTable;
	private JPanel buttonPanel;

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

		ArrayList<Bibliothekar> bibList = model.getConnection().getBibliothekarAll();
		ArrayList<Entlehnung> entList = model.getConnection().getEntlehnungAll();

		DefaultTableModel bibTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "id", "name", "Geburtsdatum" });

		DefaultTableModel entTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "id", "kunde_id", "medium_id", "von", "bis" });
		contentPane.setLayout(new BorderLayout(0, 0));

		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.WEST);

		panel_1 = new JPanel();
		buttonPanel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 119, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 23, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		btnNeu = new JButton("Neu");
		GridBagConstraints gbc_btnNeu = new GridBagConstraints();
		gbc_btnNeu.insets = new Insets(0, 0, 5, 0);
		gbc_btnNeu.gridx = 0;
		gbc_btnNeu.gridy = 0;
		panel_1.add(btnNeu, gbc_btnNeu);

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
		btnLschen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				model.getConnection().deleteBibliothekarById(
						(int) bibTableModel.getValueAt(bibTable.getSelectedRow(), 0));
			}
		});
		btnNeu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Bibliothekar b = new Bibliothekar();
				b.setName("Tester");
				b.setGbdatum(Date.valueOf("1900-01-01"));
				model.getConnection().insertBibliothekar(b);
			}
		});

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);

		bibPanel = new JPanel();
		tabbedPane.addTab("Bibliothekar", bibPanel);
		bibPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JScrollPane bibScrollPane = new JScrollPane();

		bibTable = new JTable(bibTableModel);
		bibScrollPane.setViewportView(bibTable);
		bibPanel.add(bibScrollPane);

		entPanel = new JPanel();
		tabbedPane.addTab("Entlehnung", null, entPanel, null);
		entPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		entScrollPane = new JScrollPane();

		entPanel.add(entScrollPane, BorderLayout.NORTH);

		entTable = new JTable(entTableModel);
		entScrollPane.setViewportView(entTable);
		entPanel.add(entScrollPane, BorderLayout.CENTER);

		/**
		 * Every value has to be set
		 */
		/*
		 * bibTableModel.setValueAt(model.getConnection().getBibliothekarById(2).getId(), 0, 0);
		 * bibTableModel.setValueAt(model.getConnection().getBibliothekarById(2).getName(), 0, 1);
		 * bibTableModel.setValueAt(model.getConnection().getBibliothekarById(2).getGbdatum(), 0, 2);
		 * 
		 * model.getConnection().getBibliothekarById(2).getId(), 0, 0);
		 * model.getConnection().getBibliothekarById(2).getName(), 0, 1);
		 * model.getConnection().getBibliothekarById(2).getGbdatum(), 0, 2);
		 * 
		 * bibTableModel.setValueAt(model.getConnection().getBibliothekarById(1).getId(), 1, 0);
		 * bibTableModel.setValueAt(model.getConnection().getBibliothekarById(1).getName(), 1, 1);
		 * bibTableModel.setValueAt(model.getConnection().getBibliothekarById(1).getGbdatum(), 1, 2);
		 * 
		 * bibTableModel.setValueAt(model.getConnection().getBibliothekarById(7).getId(), 2, 0);
		 * bibTableModel.setValueAt(model.getConnection().getBibliothekarById(7).getName(), 2, 1);
		 * bibTableModel.setValueAt(model.getConnection().getBibliothekarById(7).getGbdatum(), 2, 2);
		 */

		for (int i = 0; i < bibList.size(); i++){
			Object[] content = { bibList.get(i).getId(), bibList.get(i).getName(),
					bibList.get(i).getGbdatum() };
			bibTableModel.addRow(content);
		}

		for (int i = 0; i < entList.size(); i++){
			Object[] content = { entList.get(i).getId(), entList.get(i).getKundeId(),
					entList.get(i).getMediumId(), entList.get(i).getVon(),
					entList.get(i).getBis() };
			entTableModel.addRow(content);
		}
	}

}
