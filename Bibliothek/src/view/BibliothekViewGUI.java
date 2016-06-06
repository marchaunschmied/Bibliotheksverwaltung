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
import model.Kunde;
import model.Medium;

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
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import javax.swing.JSeparator;

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
	private LinkedHashMap<Integer, Bibliothekar> bibMap;
	private LinkedHashMap<Integer, Entlehnung> entMap;
	private JPanel entInput;
	private JLabel lblKunde;
	private JLabel lblMedium;
	private JLabel lblVon;
	private JTextField entInputVon;
	private JLabel lblBis;
	private JTextField entInputBis;
	private JComboBox entBoxKunde;
	private JComboBox entBoxMedium;
	private LinkedHashMap<Integer, Kunde> kunMap;
	private LinkedHashMap<Integer, Medium> medMap;
	private JButton btnWhlen;
	private JSeparator separator;
	private JPanel kunPanel;
	private JPanel kunInput;
	private JLabel label;
	private JComboBox comboBox;
	private JLabel label_1;
	private JComboBox comboBox_1;
	private JLabel label_2;
	private JTextField textField;
	private JLabel label_3;
	private JTextField textField_1;
	private JPanel medPanel;
	private JPanel medInput;
	private JLabel label_4;
	private JComboBox comboBox_2;
	private JLabel label_5;
	private JComboBox comboBox_3;
	private JLabel label_6;
	private JTextField textField_2;
	private JLabel label_7;
	private JTextField textField_3;
	private JPanel regPanel;
	private JPanel regInput;
	private JLabel label_8;
	private JComboBox comboBox_4;
	private JLabel label_9;
	private JComboBox comboBox_5;
	private JLabel label_10;
	private JTextField textField_4;
	private JLabel label_11;
	private JTextField textField_5;
	private JPanel staPanel;
	private JPanel staInput;
	private JLabel label_12;
	private JComboBox comboBox_6;
	private JLabel label_13;
	private JComboBox comboBox_7;
	private JLabel label_14;
	private JTextField textField_6;
	private JLabel label_15;
	private JTextField textField_7;
	private JTable kunTable;
	private JScrollPane kunScrollPane;
	private JTable medTable;
	private JScrollPane medScrollPane;
	private JTable regTable;
	private JScrollPane regScrollPane;
	private JTable staTable;
	private JScrollPane staScrollPane;
	private DefaultTableModel kunTableModel;
	private DefaultTableModel medTableModel;
	private DefaultTableModel regTableModel;
	private DefaultTableModel staTableModel;

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

		/**
		 * reads all data from the database and puts it into a hash map
		 */
		bibMap = model.getConnection().getBibliothekarAll();
		entMap = model.getConnection().getEntlehnungAll();
		kunMap = model.getConnection().getKundeAll();
		medMap = model.getConnection().getMediumAll();

		/**
		 * Declare all table models
		 * each table model is unique for each table
		 * 
		 */
		bibTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "id", "name", "Geburtsdatum" }){
			public boolean isCellEditable(int row, int column) {
				return false;// This causes all cells to be not editable
			}
		};

		entTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "id", "kunde_id", "medium_id", "von", "bis" }){
			public boolean isCellEditable(int row, int column) {
				return false;// This causes all cells to be not editable
			}
		};

		
		kunTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "id", "name", "Geburtsdatum", "strasse", "wohnort", "plz"}){
			public boolean isCellEditable(int row, int column) {
				return false;// This causes all cells to be not editable
			}
		};
		medTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "id", "titel", "typ", "autor", "Altersbeschränkung", "kosten", "genre" }){
			public boolean isCellEditable(int row, int column) {
				return false;// This causes all cells to be not editable
			}
		};
		
		regTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "id", "standort", "medium" }){
			public boolean isCellEditable(int row, int column) {
				return false;// This causes all cells to be not editable
			}
		};
		staTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "id", "plz", "ort","strasse","bilbiothekar" }){
			public boolean isCellEditable(int row, int column) {
				return false;// This causes all cells to be not editable
			}
		};
		
		
		/**
		 * 
		 */
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
		gbc_btnNeu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNeu.insets = new Insets(0, 0, 5, 0);
		gbc_btnNeu.gridx = 0;
		gbc_btnNeu.gridy = 0;
		panel_1.add(btnNeu, gbc_btnNeu);

		btnLschen = new JButton("L\u00F6schen");
		btnLschen.addActionListener(this);
		GridBagConstraints gbc_btnLschen = new GridBagConstraints();
		gbc_btnLschen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLschen.insets = new Insets(0, 0, 5, 0);
		gbc_btnLschen.gridx = 0;
		gbc_btnLschen.gridy = 1;
		panel_1.add(btnLschen, gbc_btnLschen);

		btnndern = new JButton("\u00C4ndern");
		btnndern.addActionListener(this);
		GridBagConstraints gbc_btnndern = new GridBagConstraints();
		gbc_btnndern.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnndern.insets = new Insets(0, 0, 5, 0);
		gbc_btnndern.gridx = 0;
		gbc_btnndern.gridy = 2;
		panel_1.add(btnndern, gbc_btnndern);

		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.VERTICAL;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 3;
		panel_1.add(separator, gbc_separator);

		btnWhlen = new JButton("W\u00E4hlen");
		btnWhlen.addActionListener(this);
		GridBagConstraints gbc_btnWhlen = new GridBagConstraints();
		gbc_btnWhlen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnWhlen.insets = new Insets(0, 0, 5, 0);
		gbc_btnWhlen.gridx = 0;
		gbc_btnWhlen.gridy = 4;
		panel_1.add(btnWhlen, gbc_btnWhlen);
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

		entTable = new JTable(entTableModel);
		entScrollPane.setViewportView(entTable);
		entPanel.add(entScrollPane, BorderLayout.CENTER);

		entInput = new JPanel();
		entInput.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Eingabe",

				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		entPanel.add(entInput);
		entInput.setLayout(new GridLayout(0, 2, 0, 5));

		lblKunde = new JLabel("Kunde");
		entInput.add(lblKunde);

		String[] entBoxKundeArguments = new String[kunMap.size()];
		int cnt = 0;
		for (Iterator iterator = kunMap.keySet().iterator(); iterator.hasNext();){
			Kunde kun = kunMap.get(iterator.next());
			entBoxKundeArguments[cnt] = kun.getName() + " ( " + kun.getId() + " )";
			cnt++;
		}

		entBoxKunde = new JComboBox(entBoxKundeArguments);
		entInput.add(entBoxKunde);

		lblMedium = new JLabel("Medium");
		entInput.add(lblMedium);

		String[] entBoxMediumArguments = new String[medMap.size()];
		cnt = 0;
		for (Iterator iterator = medMap.keySet().iterator(); iterator.hasNext();){
			Medium med = medMap.get(iterator.next());
			entBoxMediumArguments[cnt] = med.getTitel() + " ( " + med.getId() + " )";
			cnt++;
		}

		entBoxMedium = new JComboBox(entBoxMediumArguments);
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
		
		kunPanel = new JPanel();
		tabbedPane.addTab("Kunde", null, kunPanel, null);
		kunPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		kunScrollPane = new JScrollPane();
		kunPanel.add(kunScrollPane);
		
		kunTable = new JTable(kunTableModel);
		kunScrollPane.setViewportView(kunTable);
		
		kunInput = new JPanel();
		kunInput.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Eingabe",
		
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		kunPanel.add(kunInput);
		kunInput.setLayout(new GridLayout(0, 2, 0, 5));
		
		label = new JLabel("Kunde");
		kunInput.add(label);
		
		comboBox = new JComboBox(new Object[]{});
		kunInput.add(comboBox);
		
		label_1 = new JLabel("Medium");
		kunInput.add(label_1);
		
		comboBox_1 = new JComboBox(new Object[]{});
		kunInput.add(comboBox_1);
		
		label_2 = new JLabel("Von");
		kunInput.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		kunInput.add(textField);
		
		label_3 = new JLabel("Bis");
		kunInput.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		kunInput.add(textField_1);
		
		medPanel = new JPanel();
		tabbedPane.addTab("Medium", null, medPanel, null);
		medPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		medScrollPane = new JScrollPane();
		medPanel.add(medScrollPane);
		
		medTable = new JTable(medTableModel);
		medScrollPane.setViewportView(medTable);
		
		medInput = new JPanel();
		medInput.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Eingabe",
		
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		medPanel.add(medInput);
		medInput.setLayout(new GridLayout(0, 2, 0, 5));
		
		label_4 = new JLabel("Kunde");
		medInput.add(label_4);
		
		comboBox_2 = new JComboBox(new Object[]{});
		medInput.add(comboBox_2);
		
		label_5 = new JLabel("Medium");
		medInput.add(label_5);
		
		comboBox_3 = new JComboBox(new Object[]{});
		medInput.add(comboBox_3);
		
		label_6 = new JLabel("Von");
		medInput.add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		medInput.add(textField_2);
		
		label_7 = new JLabel("Bis");
		medInput.add(label_7);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		medInput.add(textField_3);
		
		regPanel = new JPanel();
		tabbedPane.addTab("Regal", null, regPanel, null);
		regPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		regScrollPane = new JScrollPane();
		regPanel.add(regScrollPane);
		
		regTable = new JTable(regTableModel);
		regScrollPane.setViewportView(regTable);
		
		regInput = new JPanel();
		regInput.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Eingabe",
		
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		regPanel.add(regInput);
		regInput.setLayout(new GridLayout(0, 2, 0, 5));
		
		label_8 = new JLabel("Kunde");
		regInput.add(label_8);
		
		comboBox_4 = new JComboBox(new Object[]{});
		regInput.add(comboBox_4);
		
		label_9 = new JLabel("Medium");
		regInput.add(label_9);
		
		comboBox_5 = new JComboBox(new Object[]{});
		regInput.add(comboBox_5);
		
		label_10 = new JLabel("Von");
		regInput.add(label_10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		regInput.add(textField_4);
		
		label_11 = new JLabel("Bis");
		regInput.add(label_11);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		regInput.add(textField_5);
		
		staPanel = new JPanel();
		tabbedPane.addTab("Standort", null, staPanel, null);
		staPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		staScrollPane = new JScrollPane();
		staPanel.add(staScrollPane);
		
		staTable = new JTable(staTableModel);
		staScrollPane.setViewportView(staTable);
		
		staInput = new JPanel();
		staInput.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Eingabe",
		
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		staPanel.add(staInput);
		staInput.setLayout(new GridLayout(0, 2, 0, 5));
		
		label_12 = new JLabel("Kunde");
		staInput.add(label_12);
		
		comboBox_6 = new JComboBox(new Object[]{});
		staInput.add(comboBox_6);
		
		label_13 = new JLabel("Medium");
		staInput.add(label_13);
		
		comboBox_7 = new JComboBox(new Object[]{});
		staInput.add(comboBox_7);
		
		label_14 = new JLabel("Von");
		staInput.add(label_14);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		staInput.add(textField_6);
		
		label_15 = new JLabel("Bis");
		staInput.add(label_15);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		staInput.add(textField_7);

		for (Iterator iterator = bibMap.keySet().iterator(); iterator.hasNext();){
			Bibliothekar bib = bibMap.get(iterator.next());
			Object[] content = bib.getFields();
			System.out.println(bibMap.keySet());
			bibTableModel.addRow(content);
		}

		for (Iterator iterator = entMap.keySet().iterator(); iterator.hasNext();){
			Entlehnung ent = entMap.get(iterator.next());
			Object[] content = ent.getFields();
			content[1] = model.getConnection().getKundeById((int) content[1]).getName();
			content[2] = model.getConnection().getMediumById((int) content[2]).getTitel();
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

	private int getComboId(JComboBox box) {
		char[] c = box.getSelectedItem().toString().toCharArray();
		String id = "";
		for (int i = 0; i < c.length; i++){
			if(Character.isDigit(c[i])){
				id += c[i];
			}
		}
		return Integer.parseInt(id);
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

				// add the new object to all components
				bibMap.put(b.getId(), b);
				bibTableModel.addRow(b.getFields());
				bibInputName.setText("");
				bibInputGeburtsdatum.setText("");
				break;

			case "Entlehnung":
				Entlehnung ent = new Entlehnung();

				int entKunde = getComboId(entBoxKunde);
				int entMedium = getComboId(entBoxMedium);
				Date von = Date.valueOf(entInputVon.getText());
				Date bis = Date.valueOf(entInputBis.getText());

				ent.setKundeId(entKunde);
				ent.setMediumId(entMedium);
				ent.setVon(von);
				ent.setBis(bis);

				model.getConnection().insertEntlehnung(ent);
				ent.setId(model.getConnection().getLastEntryId("Entlehnung"));

				// add the new object to all components
				entMap.put(ent.getId(), ent);
				Object[] content = ent.getFields();
				content[1] = model.getConnection().getKundeById((int) content[1]).getName();
				content[2] = model.getConnection().getMediumById((int) content[2]).getTitel();
				entTableModel.addRow(content);
				entInputVon.setText("");
				entInputBis.setText("");
				break;
			default:
				break;
			}

			System.out.println("N E U");
		}

		if(e.getSource() == btnndern){
			if(row != -1){
				System.out.println("Ä N D E R N");

				switch (selectedTableName) {
				case "Bibliothekar":
					Bibliothekar bib = new Bibliothekar();

					String bibName = bibInputName.getText();

					Date bibGeburtsdatum = Date.valueOf(bibInputGeburtsdatum.getText());

					bib.setName(bibName);
					bib.setGbdatum(bibGeburtsdatum);
					bib.setId((int)selectedTable.getValueAt(row, 0));

					model.getConnection().updateBibliothekar(bib);

					// add the new object to all components
					bibMap.replace(bib.getId(), bib);
					bibTableModel.setValueAt(bib.getName(),row, 1);
					bibTableModel.setValueAt(bib.getGbdatum(),row, 2);
					bibInputName.setText("");
					bibInputGeburtsdatum.setText("");
					break;
				case "Entlehnung":
					System.out.println(getComboId(entBoxKunde));
					System.out.println(getComboId(entBoxMedium));
					break;
				default:
					break;
				}
			}

		}

		if(e.getSource() == btnLschen){
			if(row != -1){
				int id = (int) selectedTable.getValueAt(row, 0);

				switch (selectedTableName) {
				case "Bibliothekar":
					model.getConnection().deleteBibliothekarById(id);
					bibMap.remove(id);
					bibTableModel.removeRow(row);

					break;
				case "Entlehnung":
					model.getConnection().deleteEntlehnungById(id);
					entMap.remove(id);
					entTableModel.removeRow(id);
					break;

				default:
					break;
				}

				// (int) bibTableModel.getValueAt(bibTable.getSelectedRow(), 0));
				System.out.println("L Ö S C H EN");
			}
		}

		if(e.getSource() == btnWhlen){

			if(row != -1){
				bibInputName.setText(selectedTable.getValueAt(row,1).toString());
				bibInputGeburtsdatum.setText(selectedTable.getValueAt(row,2).toString());
			}
		}
	}

}
