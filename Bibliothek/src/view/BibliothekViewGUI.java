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
import model.Regal;
import model.Standort;

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
	private JTextField kunInputStrasse;
	private JPanel medPanel;
	private JPanel medInput;
	private JLabel medLblTitel;
	private JPanel regPanel;
	private JPanel regInput;
	private JLabel regLblStandort;
	private JLabel regLblMedium;
	private JPanel staPanel;
	private JPanel staInput;
	private JLabel staLblPlz;
	private JTextField staInputPlz;
	private JLabel staLblOrt;
	private JTextField staInputOrt;
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
	private LinkedHashMap<Integer, Standort> staMap;
	private LinkedHashMap<Integer, Regal> regMap;
	private JLabel kunLblName;
	private JTextField kunInputGeburtsdatum;
	private JTextField kunInputName;
	private JLabel kunLblGeburtsdatum;
	private JLabel kunLblStrasse;
	private JTextField kunInputWohnort;
	private JLabel kunLblWohnort;
	private JTextField kunInputPlz;
	private JLabel kunLblPlz;
	private JTextField medInputTitel;
	private JTextField medInputTyp;
	private JLabel medLblTyp;
	private JTextField medInputAutor;
	private JLabel medLblAutor;
	private JTextField medInputAltersbeschränkung;
	private JLabel medLblAltersbeschrnkung;
	private JTextField medInputKosten;
	private JLabel medLblKosten;
	private JTextField medInputGenre;
	private JLabel medLblGenre;
	private JComboBox regBoxStandort;
	private JComboBox regBoxMedium;
	private JTextField staInputStrasse;
	private JLabel staLblStrasse;
	private JComboBox staBoxBibliothekar;
	private JLabel staLblBibliothekar;

	/**
	 * Create the frame.
	 */
	public BibliothekViewGUI(BibliothekModel model, BibliothekController controller) {

		this.model = model;
		this.controller = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 735);
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
		regMap = model.getConnection().getRegalAll();
		staMap = model.getConnection().getStandortAll();

		/**
		 * Declare all table models each table model is unique for each table
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
				new String[] { "id", "name", "Geburtsdatum", "strasse", "wohnort", "plz" }){
			public boolean isCellEditable(int row, int column) {
				return false;// This causes all cells to be not editable
			}
		};
		medTableModel = new DefaultTableModel(new Object[][] {}, new String[] { "id", "titel",
				"typ", "autor", "Altersbeschränkung", "kosten", "genre" }){
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
				new String[] { "id", "plz", "ort", "strasse", "bilbiothekar" }){
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

		kunLblName = new JLabel("Name");
		kunInput.add(kunLblName);

		kunInputName = new JTextField();
		kunInput.add(kunInputName);
		kunInputName.setColumns(10);

		kunLblGeburtsdatum = new JLabel("Geburtsdatum");
		kunInput.add(kunLblGeburtsdatum);

		kunInputGeburtsdatum = new JTextField();
		kunInput.add(kunInputGeburtsdatum);
		kunInputGeburtsdatum.setColumns(10);

		kunLblStrasse = new JLabel("Strasse");
		kunInput.add(kunLblStrasse);

		kunInputStrasse = new JTextField();
		kunInputStrasse.setColumns(10);
		kunInput.add(kunInputStrasse);

		kunLblWohnort = new JLabel("Wohnort");
		kunInput.add(kunLblWohnort);

		kunInputWohnort = new JTextField();
		kunInput.add(kunInputWohnort);
		kunInputWohnort.setColumns(10);

		kunLblPlz = new JLabel("PLZ");
		kunInput.add(kunLblPlz);

		kunInputPlz = new JTextField();
		kunInput.add(kunInputPlz);
		kunInputPlz.setColumns(10);

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

		medLblTitel = new JLabel("Titel");
		medInput.add(medLblTitel);

		medInputTitel = new JTextField();
		medInput.add(medInputTitel);
		medInputTitel.setColumns(10);

		medLblTyp = new JLabel("Typ");
		medInput.add(medLblTyp);

		medInputTyp = new JTextField();
		medInput.add(medInputTyp);
		medInputTyp.setColumns(10);

		medLblAutor = new JLabel("Autor");
		medInput.add(medLblAutor);

		medInputAutor = new JTextField();
		medInput.add(medInputAutor);
		medInputAutor.setColumns(10);

		medLblAltersbeschrnkung = new JLabel("Altersbeschr\u00E4nkung\r\n");
		medInput.add(medLblAltersbeschrnkung);

		medInputAltersbeschränkung = new JTextField();
		medInput.add(medInputAltersbeschränkung);
		medInputAltersbeschränkung.setColumns(10);

		medLblKosten = new JLabel("Kosten");
		medInput.add(medLblKosten);

		medInputKosten = new JTextField();
		medInput.add(medInputKosten);
		medInputKosten.setColumns(10);

		medLblGenre = new JLabel("Genre");
		medInput.add(medLblGenre);

		medInputGenre = new JTextField();
		medInput.add(medInputGenre);
		medInputGenre.setColumns(10);

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

		regLblStandort = new JLabel("Standort");
		regInput.add(regLblStandort);

		String[] regBoxStandortArguments = new String[staMap.size()];
		cnt = 0;
		for (Iterator iterator = staMap.keySet().iterator(); iterator.hasNext();){
			Standort sta = staMap.get(iterator.next());
			regBoxStandortArguments[cnt] = sta.getOrt() + " ( " + sta.getId() + " )";
			cnt++;
		}

		regBoxStandort = new JComboBox(regBoxStandortArguments);
		regInput.add(regBoxStandort);

		regLblMedium = new JLabel("Medium");
		regInput.add(regLblMedium);

		String[] regBoxMediumArguments = new String[medMap.size()];
		cnt = 0;
		for (Iterator iterator = medMap.keySet().iterator(); iterator.hasNext();){
			Medium med = medMap.get(iterator.next());
			regBoxMediumArguments[cnt] = med.getTitel() + " ( " + med.getId() + " )";
			cnt++;
		}

		regBoxMedium = new JComboBox(regBoxMediumArguments);
		regInput.add(regBoxMedium);

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

		staLblPlz = new JLabel("PLZ");
		staInput.add(staLblPlz);

		staInputPlz = new JTextField();
		staInputPlz.setColumns(10);
		staInput.add(staInputPlz);

		staLblOrt = new JLabel("Ort");
		staInput.add(staLblOrt);

		staInputOrt = new JTextField();
		staInputOrt.setColumns(10);
		staInput.add(staInputOrt);

		staLblStrasse = new JLabel("Strasse");
		staInput.add(staLblStrasse);

		staInputStrasse = new JTextField();
		staInput.add(staInputStrasse);
		staInputStrasse.setColumns(10);

		staLblBibliothekar = new JLabel("Bibliothekar");
		staInput.add(staLblBibliothekar);

		String[] staBoxBibliothekarArguments = new String[bibMap.size()];
		cnt = 0;
		for (Iterator iterator = bibMap.keySet().iterator(); iterator.hasNext();){
			Bibliothekar bib = bibMap.get(iterator.next());
			staBoxBibliothekarArguments[cnt] = bib.getName() + " ( " + bib.getId() + " )";
			cnt++;
		}

		staBoxBibliothekar = new JComboBox(staBoxBibliothekarArguments);
		staInput.add(staBoxBibliothekar);

		// #############################################################################################
		// #############################################################################################

		// Fill the tables

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

		for (Iterator iterator = kunMap.keySet().iterator(); iterator.hasNext();){
			Kunde kun = kunMap.get(iterator.next());
			Object[] content = kun.getFields();

			kunTableModel.addRow(content);
		}

		for (Iterator iterator = medMap.keySet().iterator(); iterator.hasNext();){
			Medium med = medMap.get(iterator.next());
			Object[] content = med.getFields();

			medTableModel.addRow(content);
		}

		for (Iterator iterator = regMap.keySet().iterator(); iterator.hasNext();){
			Regal reg = regMap.get(iterator.next());
			Object[] content = reg.getFields();

			content[1] = model.getConnection().getStandortById((int) content[1]).getOrt();
			content[2] = model.getConnection().getMediumById((int) content[2]).getTitel();

			regTableModel.addRow(content);
		}

		for (Iterator iterator = staMap.keySet().iterator(); iterator.hasNext();){
			Standort sta = staMap.get(iterator.next());
			Object[] content = sta.getFields();

			content[4] = model.getConnection().getBibliothekarById((int) content[4]).getName();

			staTableModel.addRow(content);
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
			break;
		case 2:
			selectedTable = kunTable;
			break;
		case 3:
			selectedTable = medTable;
			break;
		case 4:
			selectedTable = regTable;
			break;
		case 5:
			selectedTable = staTable;
			break;

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
			case "Kunde":
				Kunde kun = new Kunde();

				Date kunGeburtsdatum = Date.valueOf(kunInputGeburtsdatum.getText());
				String kunName = kunInputName.getText();
				String kunPlz = kunInputPlz.getText();
				String kunStrasse = kunInputStrasse.getText();
				String kunWohnort = kunInputWohnort.getText();

				kun.setGbdatum(kunGeburtsdatum);
				kun.setName(kunName);
				kun.setPlz(kunPlz);
				kun.setStrasse(kunStrasse);
				kun.setWohnort(kunWohnort);

				model.getConnection().insertKunde(kun);
				kun.setId(model.getConnection().getLastEntryId("Kunde"));

				// add the new object to all components
				kunMap.put(kun.getId(), kun);

				kunTableModel.addRow(kun.getFields());
				kunInputGeburtsdatum.setText("");
				kunInputName.setText("");
				kunInputPlz.setText("");
				kunInputStrasse.setText("");
				kunInputWohnort.setText("");
				break;
			case "Medium":
				Medium med = new Medium();

				int medAltersbes = Integer.parseInt(medInputAltersbeschränkung.getText());
				String medAutor = medInputAutor.getText();
				String medGenre = medInputGenre.getText();
				int medKosten = Integer.parseInt(medInputKosten.getText());
				String medTitel = medInputTitel.getText();
				String medTyp = medInputTyp.getText();
				
				med.setAltersbes(medAltersbes);
				med.setAutor(medAutor);
				med.setGenre(medGenre);
				med.setKosten(medKosten);
				med.setTitel(medTitel);
				med.setTyp(medTyp);
				
				model.getConnection().insertMedium(med);
				med.setId(model.getConnection().getLastEntryId("Medium"));

				// add the new object to all components
				medMap.put(med.getId(), med);
				
				medTableModel.addRow(med.getFields());
				
				medInputAltersbeschränkung.setText("");
				medInputAutor.setText("");
				medInputGenre.setText("");
				medInputKosten.setText("");
				medInputTitel.setText("");
				medInputTyp.setText("");
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
					bib.setId((int) selectedTable.getValueAt(row, 0));

					model.getConnection().updateBibliothekar(bib);

					// add the new object to all components
					bibMap.replace(bib.getId(), bib);
					bibTableModel.setValueAt(bib.getName(), row, 1);
					bibTableModel.setValueAt(bib.getGbdatum(), row, 2);
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

		if(e.getSource() == btnLschen)

		{
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

		if(e.getSource() == btnWhlen)

		{

			if(row != -1){
				bibInputName.setText(selectedTable.getValueAt(row, 1).toString());
				bibInputGeburtsdatum.setText(selectedTable.getValueAt(row, 2).toString());
			}
		}
	}

}
