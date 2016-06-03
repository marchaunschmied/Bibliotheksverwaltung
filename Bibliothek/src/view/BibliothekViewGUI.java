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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * This class is partly auto-generated. For the GUI the Eclipse Window Builder is used
 * 
 * @author MarcAnton
 *
 */
public class BibliothekViewGUI extends JFrame implements ActionListener {

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
	private JPanel bibInput;
	private JTextField bibInputName;
	private JLabel lblName;
	private JTextField bibInputGeburtsdatum;
	private JLabel lblGeburtsdatum;
	private DefaultTableModel bibTableModel;
	private DefaultTableModel entTableModel;
	private HashMap<Integer, Bibliothekar> bibMap;
	private HashMap<Integer, Entlehnung> entMap;
	private JPanel entInput;
	private JLabel lblKunde;
	private JLabel lblMedium;
	private JLabel lblVon;
	private JTextField entInputVon;
	private JLabel lblBis;
	private JTextField entInputBis;
	private JComboBox entBoxKunde;
	private JComboBox entBoxMedium;

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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		bibMap = model.getConnection().getBibliothekarAll();
		entMap = model.getConnection().getEntlehnungAll();

		bibTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "id", "name", "Geburtsdatum" });

		entTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "id", "kunde_id", "medium_id", "von", "bis" });

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
		btnLschen.addActionListener(this);
		GridBagConstraints gbc_btnLschen = new GridBagConstraints();
		gbc_btnLschen.insets = new Insets(0, 0, 5, 0);
		gbc_btnLschen.gridx = 0;
		gbc_btnLschen.gridy = 1;
		panel_1.add(btnLschen, gbc_btnLschen);

		btnndern = new JButton("\u00C4ndern");
		btnndern.addActionListener(this);
		GridBagConstraints gbc_btnndern = new GridBagConstraints();
		gbc_btnndern.insets = new Insets(0, 0, 5, 0);
		gbc_btnndern.gridx = 0;
		gbc_btnndern.gridy = 2;
		panel_1.add(btnndern, gbc_btnndern);
		btnNeu.addActionListener(this);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);

		bibPanel = new JPanel();
		tabbedPane.addTab("Bibliothekar", bibPanel);
		bibPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JScrollPane bibScrollPane = new JScrollPane();

		bibTable = new JTable(bibTableModel);
		bibScrollPane.setViewportView(bibTable);
		bibPanel.add(bibScrollPane);

		bibInput = new JPanel();
		bibInput.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Eingabe",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		bibPanel.add(bibInput);
		bibInput.setLayout(new GridLayout(0, 2, 0, 5));

		lblName = new JLabel("Name");
		bibInput.add(lblName);

		bibInputName = new JTextField();
		bibInput.add(bibInputName);
		bibInputName.setColumns(10);

		lblGeburtsdatum = new JLabel("Geburtsdatum");
		bibInput.add(lblGeburtsdatum);

		bibInputGeburtsdatum = new JTextField();
		bibInput.add(bibInputGeburtsdatum);
		bibInputGeburtsdatum.setColumns(10);

		entPanel = new JPanel();
		tabbedPane.addTab("Entlehnung", null, entPanel, null);
		entPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		entScrollPane = new JScrollPane();

		entPanel.add(entScrollPane, BorderLayout.NORTH);

		entTable = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "kunde_id", "medium_id", "von", "bis"
			}
		));
		entScrollPane.setViewportView(entTable);
		entPanel.add(entScrollPane, BorderLayout.CENTER);
		
		entInput = new JPanel();
		entInput.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Eingabe",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		entPanel.add(entInput);
		entInput.setLayout(new GridLayout(0, 2, 0, 5));
		
		lblKunde = new JLabel("Kunde");
		entInput.add(lblKunde);
		
		entBoxKunde = new JComboBox();
		entInput.add(entBoxKunde);
		
		lblMedium = new JLabel("Medium");
		entInput.add(lblMedium);
		
		entBoxMedium = new JComboBox();
		entInput.add(entBoxMedium);
		
		lblVon = new JLabel("Von");
		entInput.add(lblVon);
		
		entInputVon = new JTextField();
		entInput.add(entInputVon);
		entInputVon.setColumns(10);
		
		lblBis = new JLabel("Bis");
		entInput.add(lblBis);
		
		entInputBis = new JTextField();
		entInput.add(entInputBis);
		entInputBis.setColumns(10);

		for (Iterator iterator = bibMap.keySet().iterator(); iterator.hasNext();){
			Bibliothekar bib = bibMap.get(iterator.next());
			Object[] content = bib.getFields();
			bibTableModel.addRow(content);
		}

		for (Iterator iterator = entMap.keySet().iterator(); iterator.hasNext();){
			Entlehnung ent = entMap.get(iterator.next());
			Object[] content = ent.getFields();
			entTableModel.addRow(content);
		}
		/*
		 * for (int i = 0; i < bibList.size(); i++){
		 * 
		 * 
		 * Object[] content = bibList.get(i).getFields();
		 * 
		 * bibTableModel.addRow(content); }
		 */
		/*
		 * for (
		 * 
		 * int i = 0; i < entList.size(); i++)
		 * 
		 * { Object[] content = { entList.get(i).getId(), entList.get(i).getKundeId(), entList.get(i).getMediumId(),
		 * entList.get(i).getVon(), entList.get(i).getBis() }; entTableModel.addRow(content); }
		 */

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int selectedPane = tabbedPane.getSelectedIndex();

		JTable selectedTable = null;

		switch (selectedPane) {
		case 0:
			selectedTable = bibTable;

			break;
		case 1:
			selectedTable = entTable;
		default:
			break;
		}

		int row = selectedTable.getSelectedRow();
		int col = selectedTable.getSelectedColumn();
		String selectedTableName = tabbedPane.getTitleAt(selectedPane);

		System.out.println(selectedTableName);
		System.out.println("Zeile: " + row);
		System.out.println("Spalte: " + col);

		if(e.getSource() == btnNeu){

			switch (selectedTableName) {
			case "Bibliothekar":
				Bibliothekar b = new Bibliothekar();

				String bibName = bibInputName.getText();

				Date bibGeburtsdatum = Date.valueOf(bibInputGeburtsdatum.getText());
				
				

				b.setName(bibName);
				b.setGbdatum(bibGeburtsdatum);

				model.getConnection().insertBibliothekar(b);
				b.setId(model.getConnection().getLastEntryId("Bibliothekar"));
				bibMap.put(b.getId(), b);
				bibTableModel.addRow(b.getFields());
				bibInputName.setText("");
				bibInputGeburtsdatum.setText("");
				break;

			case "Entlehnung":
				System.out.println("Entlehnung hinzugefügt");
				break;
			default:
				break;
			}

			System.out.println("N E U");
		}

		if(e.getSource() == btnndern){
			
			System.out.println("Ä N D E R N");

		}

		if(e.getSource() == btnLschen){
			int id = (int) selectedTable.getValueAt(row, 0);
			model.getConnection().deleteBibliothekarById(id);

			bibMap.remove(id);
			bibTableModel.removeRow(row);
			// (int) bibTableModel.getValueAt(bibTable.getSelectedRow(), 0));
			System.out.println("L Ö S C H EN");
		}
	}

}
