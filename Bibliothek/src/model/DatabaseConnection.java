package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.net.aso.e;

/**
 * Interface for the connection between the database and the program. Everything has to go trough this class.
 * 
 * @author MarcAnton
 *
 */
public class DatabaseConnection {

	private static Connection conn = null;
	private static String dbHost = "192.168.56.2"; // Hostname
	private static String dbPort = "3306"; // Port -- Standard: 3306
	private static String dbName = "Bibliothek"; // Database name
	private static String dbUser = "root"; // Database user
	private static String dbPass = ""; // Database password

	private static final String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/"
			+ dbName + "?" + "user=" + dbUser + "&" + "password=" + dbPass;

	/**
	 * Opens the connection to a database
	 */
	public DatabaseConnection() {

		// Connection String
		System.out.println(connectionString);
		try{

			// Load the jdbc driver
			Class.forName("com.mysql.jdbc.Driver");

			// Connect to the Database
			conn = DriverManager.getConnection(connectionString);
			// conn = DriverManager.getConnection("jdbc:mysql://192.168.56.2:3306","root","");

		}catch (ClassNotFoundException e){
			System.out.println("Driver not found");
		}catch (SQLException e){
			System.out.println("Connection to database not possible");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			System.out.println(e.getErrorCode());
		}
	}

	// #############################################################################################
	// #############################################################################################

	// G E T --- D A T A ---

	public Bibliothekar getBibliothekarById(int id) {
		Bibliothekar b = null;

		if(conn != null){
			Statement query;
			try{
				query = conn.createStatement();
				String sql = "SELECT * FROM Bibliothekar WHERE bibliothekar_id = '" + id + "'";
				ResultSet result = query.executeQuery(sql);

				while(result.next()){
					b = new Bibliothekar();
					b.setId(result.getInt("bibliothekar_id"));
					b.setName(result.getString("name"));
					b.setGbdatum(result.getDate("geburtsdatum"));

				}

			}catch (SQLException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return b;
	}

	public Entlehnung getEntlehnungById(int id) {
		Entlehnung ent = null;

		if(conn != null){
			Statement query;
			try{
				query = conn.createStatement();
				String sql = "SELECT * FROM Entlehnung WHERE entlehnung_id = '" + id + "'";
				ResultSet result = query.executeQuery(sql);

				while(result.next()){
					ent = new Entlehnung();
					ent.setId(result.getInt("entlehnung_id"));
					ent.setKundeId(result.getInt("kunde_id"));
					ent.setMediumId(result.getInt("medium_id"));
					ent.setVon(result.getDate("von"));
					ent.setBis(result.getDate("bis"));
				}

			}catch (SQLException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return ent;
	}

	public Kunde getKundeById(int id) {
		Kunde k = null;

		if(conn != null){
			Statement query;
			try{
				query = conn.createStatement();
				String sql = "SELECT * FROM Kunde WHERE kunde_id = '" + id + "'";
				ResultSet result = query.executeQuery(sql);

				while(result.next()){
					k = new Kunde();
					k.setId(result.getInt("kunde_id"));
					k.setName(result.getString("name"));
					k.setGbdatum(result.getDate("geburtsdatum"));
					k.setStrasse(result.getString("strasse"));
					k.setWohnort(result.getString("wohnort"));
					k.setPlz(result.getString("plz"));

				}

			}catch (SQLException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return k;
	}

	public Medium getMediumById(int id) {
		Medium med = null;

		if(conn != null){
			Statement query;
			try{
				query = conn.createStatement();
				String sql = "SELECT * FROM Medium WHERE medium_id = '" + id + "'";
				ResultSet result = query.executeQuery(sql);

				while(result.next()){
					med = new Medium();
					med.setId(result.getInt("medium_id"));
					med.setTitel(result.getString("titel"));
					med.setTyp(result.getString("typ"));
					med.setAutor(result.getString("autor"));
					med.setAltersbes(result.getInt("altersbes"));
					med.setKosten(result.getInt("kosten"));
					med.setGenre(result.getString("genre"));
				}

			}catch (SQLException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return med;
	}

	public Regal getRegalById(int id) {
		Regal reg = null;

		if(conn != null){
			Statement query;
			try{
				query = conn.createStatement();
				String sql = "SELECT * FROM Regal WHERE regal_id = '" + id + "'";
				ResultSet result = query.executeQuery(sql);

				while(result.next()){
					reg = new Regal();
					reg.setId(result.getInt("regal_id"));
					reg.setStandortId(result.getInt("standort_id"));
					reg.setMediumId(result.getInt("medium_id"));
				}

			}catch (SQLException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return reg;
	}

	public Standort getStandortById(int id) {
		Standort sta = null;

		if(conn != null){
			Statement query;
			try{
				query = conn.createStatement();
				String sql = "SELECT * FROM Standort WHERE standort_id = '" + id + "'";
				ResultSet result = query.executeQuery(sql);

				while(result.next()){
					sta = new Standort();
					sta.setId(result.getInt("standort_id"));
					sta.setPlz(result.getInt("plz"));
					sta.setOrt(result.getString("ort"));
					sta.setStrasse(result.getString("strasse"));
					sta.setBibliothekarId(result.getInt("bibliothekar_id"));
				}

			}catch (SQLException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return sta;
	}

	// #############################################################################################
	// #############################################################################################

	// S E T --- D A T A
	// ID is not set because of auto increment in MYSQL

	public void insertBibliothekar(Bibliothekar bib) {
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "INSERT INTO Bibliothekar (name,geburtsdatum) VALUES('" + bib.getName()
						+ "','" + bib.getGbdatum() + "');";
				int result = query.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	public void insertEntlehnung(Entlehnung ent) {
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "INSERT INTO Entlehnung (kunde_id,medium_id,von,bis) VALUES('"
						+ ent.getKundeId() + "','" + ent.getMediumId() + "','" + ent.getVon()
						+ "','" + ent.getBis() + "');";
				int result = query.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void insertKunde(Kunde kun) {
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "INSERT INTO Kunde (name,geburtsdatum,strasse,wohnort,plz) VALUES('"
						+ kun.getName() + "','" + kun.getGbdatum() + "','" + kun.getStrasse()
						+ "','" + kun.getWohnort() + "','" + kun.getPlz() + "');";
				int result = query.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void insertMedium(Medium med) {
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "INSERT INTO Medium (titel,typ,autor,altersbes,kosten,genre) VALUES('"
						+ med.getTitel() + "','" + med.getTyp() + "','" + med.getAutor()
						+ "','" + med.getAltersbes() + "','" + med.getKosten() + "','" + med.getGenre() + "');";
				int result = query.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void insertRegal(Regal reg) {
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "INSERT INTO Regal (standort_id,medium_id) VALUES('"
						+ reg.getStandortId() + "','" + reg.getMediumId() + "');";
				int result = query.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void insertStandort(Standort sta) {
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "INSERT INTO Standort (plz,ort,strasse,bibliothekar_id) VALUES('"
						+ sta.getPlz() + "','" + sta.getOrt() + "','" + sta.getStrasse()
						 + sta.getBibliothekarId() + "');";
				int result = query.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	// #############################################################################################
	// #############################################################################################
	
	public void deleteBibliothekarById(int id) {
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "DELETE from Bibliothekar WHERE bibliothekar_id = '" + id + "' ;";
				int result = query.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void deleteEntlehnungById(int id) {
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "DELETE from Entlehnung WHERE entlehnung_id = '" + id + "' ;";
				int result = query.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void deleteKundeById(int id) {
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "DELETE from Kunde WHERE kunde_id = '" + id + "' ;";
				int result = query.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void deleteMediumById(int id) {
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "DELETE from Medium WHERE medium_id = '" + id + "' ;";
				int result = query.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void deleteRegalById(int id) {
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "DELETE from Regal WHERE regal_id = '" + id + "' ;";
				int result = query.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void deleteStandortById(int id) {
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "DELETE from Standort WHERE standort_id = '" + id + "' ;";
				int result = query.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	// #############################################################################################
	// #############################################################################################
	/*
	 * public ArrayList getKunden() {
	 * 
	 * ArrayList<Kunde> list = new ArrayList(); conn = getInstance();
	 * 
	 * if(conn != null){ Statement query; try{ query = conn.createStatement(); String sql = "SELECT * FROM Kunde"; ResultSet
	 * result = query.executeQuery(sql);
	 * 
	 * while(result.next()){ Kunde k = new Kunde(); k.setId(result.getInt("kunde_id")); k.setName(result.getString("name"));
	 * k.setGbdatum(result.getDate("geburtsdatum")); k.setStrasse(result.getString("strasse"));
	 * k.setWohnort(result.getString("wohnort")); k.setPlz(result.getString("plz"));
	 * 
	 * list.add(k);
	 * 
	 * }
	 * 
	 * }catch (SQLException e){ // TODO Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * return list;
	 * 
	 * }
	 */

}
