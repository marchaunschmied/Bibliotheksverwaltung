package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import oracle.net.aso.e;

/**
 * Interface for the connection between the database and the program. Everything has to go trough this class. There are many
 * methods which basically do the same, but have different names. TODO find a way to only have on method which can handle
 * every table obeject --> interface, abstract class???
 * 
 * @author MarcAnton
 *
 */
public class DatabaseConnection {

	private static Connection conn = null;

	/**
	 * IP address of the MySQL Database
	 */
	private static String dbHost = "192.168.56.2";

	/**
	 * MySQL Port -- Standard: 3306
	 */
	private static String dbPort = "3306";

	/**
	 * Database name
	 */
	private static String dbName = "Bibliothek";

	/**
	 * Username for the database These are defaults
	 */
	private static String dbUser = "root";

	/**
	 * Password for the Database
	 */
	private static String dbPass = "";

	/**
	 * This string is used to connect to the database
	 */
	private static final String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/"
			+ dbName + "?" + "user=" + dbUser + "&" + "password=" + dbPass;

	/**
	 * Opens the connection to a database
	 */
	public DatabaseConnection() {

		/**
		 * Connection String
		 */
		System.out.println(connectionString);
		try{

			/**
			 * Load the jdbc driver
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/**
			 * Connect to the Database
			 */
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

	/**
	 * This method gets a single Bibliothekar based on its id
	 * 
	 * @param id
	 *            the id given by the database
	 * @return <b>Bibliothekar</b> or null if not found in the database
	 */

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

	/**
	 * This method gets a single Entlehnung based on its id
	 * 
	 * @param id
	 *            the id given by the database
	 * @return <b>Entlehnung</b> or null if not found in the database
	 */
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

	/**
	 * This method gets a single Kunde based on its id
	 * 
	 * @param id
	 *            the id given by the database
	 * @return <b>Kunde</b> or null if not found in the database
	 */
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

	/**
	 * This method gets a single Medium based on its id
	 * 
	 * @param id
	 *            the id given by the database
	 * @return <b>Medium</b> or null if not found in the database
	 */
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

	/**
	 * This method gets a single Regal based on its id
	 * 
	 * @param id
	 *            the id given by the database
	 * @return <b>Regal</b> or null if not found in the database
	 */
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

	/**
	 * This method gets a single Standort based on its id
	 * 
	 * @param id
	 *            the id given by the database
	 * @return <b>Standort</b> or null if not found in the database
	 */
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

	/**
	 * Adds a Bibliothekar to the database The id must not be set, because the database generates the id with auto-increment
	 * 
	 * @param bib
	 */
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

	/**
	 * Adds a Entlehnung to the database The id must not be set, because the database generates the id with auto-increment
	 * 
	 * @param ent
	 */
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

	/**
	 * Adds a Kunde to the database The id must not be set, because the database generates the id with auto-increment
	 * 
	 * @param kun
	 */
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

	/**
	 * Adds a Medium to the database The id must not be set, because the database generates the id with auto-increment
	 * 
	 * @param med
	 */
	public void insertMedium(Medium med) {
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "INSERT INTO Medium (titel,typ,autor,altersbes,kosten,genre) VALUES('"
						+ med.getTitel() + "','" + med.getTyp() + "','" + med.getAutor() + "','"
						+ med.getAltersbes() + "','" + med.getKosten() + "','" + med.getGenre()
						+ "');";
				int result = query.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	/**
	 * Adds a Regal to the database The id must not be set, because the database generates the id with auto-increment
	 * 
	 * @param reg
	 */
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

	/**
	 * Adds a Standort to the database The id must not be set, because the database generates the id with auto-increment
	 * 
	 * @param sta
	 */
	public void insertStandort(Standort sta) {

		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "INSERT INTO Standort (plz,ort,strasse,bibliothekar_id) VALUES('"
						+ sta.getPlz() + "','" + sta.getOrt() + "','" + sta.getStrasse() + "','"
						+ sta.getBibliothekarId() + "');";
				System.out.println(sql);
				int result = query.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	// #############################################################################################
	// #############################################################################################

	/**
	 * Deletes a Bibliothekar with the given id 
	 * @param id
	 */
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

	/**
	 * Deletes a Entlehnung with the given id 
	 * @param id
	 */
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


	/**
	 * Deletes a Kunde with the given id 
	 * @param id
	 */
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
	

	/**
	 * Deletes a Medium with the given id 
	 * @param id
	 */
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


	/**
	 * Deletes a Regal with the given id 
	 * @param id
	 */
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
	

	/**
	 * Deletes a Standort with the given id 
	 * @param id
	 */
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

	/**
	 * A LinkedHashMap is used to guarantee that the entrys are always in the same order. 
	 * The key for the LinkedHashMap is the id of an entry and the value the entry it self.
	 * The LinkedHashMap is orderd by the id
	 * @return a LinkedHashMap with every single entry in the database
	 */
	public LinkedHashMap<Integer, Bibliothekar> getBibliothekarAll() {

		LinkedHashMap<Integer, Bibliothekar> bibMap = new LinkedHashMap<Integer, Bibliothekar>();

		if(conn != null){
			Statement query;
			try{

				query = conn.createStatement();
				String sql = "SELECT * FROM Bibliothekar";
				ResultSet result = query.executeQuery(sql);

				while(result.next()){
					Bibliothekar bib = new Bibliothekar();
					bib.setId(result.getInt("bibliothekar_id"));
					bib.setName(result.getString("name"));
					bib.setGbdatum(result.getDate("geburtsdatum"));
					bibMap.put(bib.getId(), bib);

				}
			}catch (SQLException e){
				e.printStackTrace();
			}

		}
		return bibMap;
	}
	/**
	 * A LinkedHashMap is used to guarantee that the entrys are always in the same order. 
	 * The key for the LinkedHashMap is the id of an entry and the value the entry it self.
	 * The LinkedHashMap is orderd by the id
	 * @return a LinkedHashMap with every single entry in the database
	 */
	public LinkedHashMap<Integer, Entlehnung> getEntlehnungAll() {

		LinkedHashMap<Integer, Entlehnung> entMap = new LinkedHashMap<Integer, Entlehnung>();

		if(conn != null){
			Statement query;
			try{

				query = conn.createStatement();
				String sql = "SELECT * FROM Entlehnung";
				ResultSet result = query.executeQuery(sql);

				while(result.next()){
					Entlehnung ent = new Entlehnung();
					ent.setId(result.getInt("entlehnung_id"));
					ent.setKundeId(result.getInt("kunde_id"));
					ent.setMediumId(result.getInt("medium_id"));
					ent.setVon(result.getDate("von"));
					ent.setBis(result.getDate("bis"));

					entMap.put(ent.getId(), ent);

				}
			}catch (SQLException e){
				e.printStackTrace();
			}

		}
		return entMap;
	}
	/**
	 * A LinkedHashMap is used to guarantee that the entrys are always in the same order. 
	 * The key for the LinkedHashMap is the id of an entry and the value the entry it self.
	 * The LinkedHashMap is orderd by the id
	 * @return a LinkedHashMap with every single entry in the database
	 */
	public LinkedHashMap<Integer, Kunde> getKundeAll() {

		LinkedHashMap<Integer, Kunde> kunMap = new LinkedHashMap<Integer, Kunde>();

		if(conn != null){
			Statement query;
			try{

				query = conn.createStatement();
				String sql = "SELECT * FROM Kunde";
				ResultSet result = query.executeQuery(sql);

				while(result.next()){
					Kunde kun = new Kunde();

					kun.setId(result.getInt("kunde_id"));
					kun.setName(result.getString("name"));
					kun.setGbdatum(result.getDate("geburtsdatum"));
					kun.setStrasse(result.getString("strasse"));
					kun.setWohnort(result.getString("wohnort"));
					kun.setPlz(result.getString("plz"));

					kunMap.put(kun.getId(), kun);

				}
			}catch (SQLException e){
				e.printStackTrace();
			}

		}
		return kunMap;

	}
	/**
	 * A LinkedHashMap is used to guarantee that the entrys are always in the same order. 
	 * The key for the LinkedHashMap is the id of an entry and the value the entry it self.
	 * The LinkedHashMap is orderd by the id
	 * @return a LinkedHashMap with every single entry in the database
	 */
	public LinkedHashMap<Integer, Medium> getMediumAll() {

		LinkedHashMap<Integer, Medium> medMap = new LinkedHashMap<Integer, Medium>();

		if(conn != null){
			Statement query;
			try{

				query = conn.createStatement();
				String sql = "SELECT * FROM Medium";
				ResultSet result = query.executeQuery(sql);

				while(result.next()){
					Medium med = new Medium();

					med.setId(result.getInt("medium_id"));
					med.setTitel(result.getString("titel"));
					med.setTyp(result.getString("typ"));
					med.setAutor(result.getString("autor"));
					med.setAltersbes(result.getInt("altersbes"));
					med.setKosten(result.getInt("kosten"));
					med.setGenre(result.getString("genre"));

					medMap.put(med.getId(), med);

				}
			}catch (SQLException e){
				e.printStackTrace();
			}

		}
		return medMap;
	}
	/**
	 * A LinkedHashMap is used to guarantee that the entrys are always in the same order. 
	 * The key for the LinkedHashMap is the id of an entry and the value the entry it self.
	 * The LinkedHashMap is orderd by the id
	 * @return a LinkedHashMap with every single entry in the database
	 */
	public LinkedHashMap<Integer, Regal> getRegalAll() {

		LinkedHashMap<Integer, Regal> regMap = new LinkedHashMap<Integer, Regal>();

		if(conn != null){
			Statement query;
			try{

				query = conn.createStatement();
				String sql = "SELECT * FROM Regal";
				ResultSet result = query.executeQuery(sql);

				while(result.next()){
					Regal reg = new Regal();

					reg.setId(result.getInt("regal_id"));
					reg.setMediumId(result.getInt("medium_id"));
					reg.setStandortId(result.getInt("standort_id"));

					regMap.put(reg.getId(), reg);

				}
			}catch (SQLException e){
				e.printStackTrace();
			}

		}
		return regMap;
	}
	/**
	 * A LinkedHashMap is used to guarantee that the entrys are always in the same order. 
	 * The key for the LinkedHashMap is the id of an entry and the value the entry it self.
	 * The LinkedHashMap is orderd by the id
	 * @return a LinkedHashMap with every single entry in the database
	 */
	public LinkedHashMap<Integer, Standort> getStandortAll() {

		LinkedHashMap<Integer, Standort> staMap = new LinkedHashMap<Integer, Standort>();

		if(conn != null){
			Statement query;
			try{

				query = conn.createStatement();
				String sql = "SELECT * FROM Standort";
				ResultSet result = query.executeQuery(sql);

				while(result.next()){
					Standort sta = new Standort();

					sta.setId(result.getInt("standort_id"));
					sta.setBibliothekarId(result.getInt("bibliothekar_id"));
					sta.setOrt(result.getString("ort"));
					sta.setPlz(result.getInt("plz"));
					sta.setStrasse(result.getString("strasse"));

					staMap.put(sta.getId(), sta);

				}
			}catch (SQLException e){
				e.printStackTrace();
			}

		}
		return staMap;
	}
	// #############################################################################################
	// #############################################################################################

	/**
	 * Updates a entry in the database 
	 * @param bib the Bibliothekar which gets updated
	 * @return  1 if the update has worked otherwise its -1
	 */
	public int updateBibliothekar(Bibliothekar bib) {

		int result = 0;
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "UPDATE Bibliothekar SET name='" + bib.getName() + "', geburtsdatum='"
						+ bib.getGbdatum() + "' WHERE bibliothekar_id='" + bib.getId() + "';";
				result = query.executeUpdate(sql);

				System.out.println(sql);
				System.out.println(result);

			}catch (SQLException e){
				e.printStackTrace();
			}
		}

		return result;
	}
	/**
	 * Updates a entry in the database 
	 * @param ent the Entlehnung which gets updated
	 * @return  1 if the update has worked otherwise its -1
	 */
	public int updateEntlehnung(Entlehnung ent) {

		int result = 0;
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "UPDATE Entlehnung SET kunde_id='" + ent.getKundeId()
						+ "', medium_id='" + ent.getMediumId() + "', von='" + ent.getVon()
						+ "' , bis='" + ent.getBis() + "' WHERE entlehnung_id ='" + ent.getId()
						+ "';";

				System.out.println(sql);

				result = query.executeUpdate(sql);

				System.out.println(sql);
				System.out.println(result);

			}catch (SQLException e){
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * Updates a entry in the database 
	 * @param kun the Kunde which gets updated
	 * @return  1 if the update has worked otherwise its -1
	 */
	public int updateKunde(Kunde kun) {

		int result = 0;
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "UPDATE Kunde SET name='" + kun.getName() + "', geburtsdatum='"
						+ kun.getGbdatum() + "', strasse='" + kun.getStrasse() + "' , wohnort='"
						+ kun.getWohnort() + "', plz='" + kun.getPlz() + " ' WHERE kunde_id ='"
						+ kun.getId() + "';";

				System.out.println(sql);

				result = query.executeUpdate(sql);

				System.out.println(sql);
				System.out.println(result);

			}catch (SQLException e){
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * Updates a entry in the database 
	 * @param med the Medium which gets updated
	 * @return  1 if the update has worked otherwise its -1
	 */
	public int updateMedium(Medium med) {

		int result = 0;
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "UPDATE Medium SET titel='" + med.getTitel() + "', typ='"
						+ med.getTyp() + "', autor='" + med.getAutor() + "' , altersbes='"
						+ med.getAltersbes() + "', kosten='" + med.getKosten() + "', genre='"
						+ med.getGenre() + "' WHERE medium_id ='" + med.getId() + "';";

				System.out.println(sql);

				result = query.executeUpdate(sql);

				System.out.println(sql);
				System.out.println(result);

			}catch (SQLException e){
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * Updates a entry in the database 
	 * @param reg the Regal which gets updated
	 * @return  1 if the update has worked otherwise its -1
	 */
	public int updateRegal(Regal reg) {

		int result = 0;
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "UPDATE Regal SET standort_id='" + reg.getStandortId()
						+ "', medium_id='" + reg.getMediumId() + "' WHERE regal_id ='" + reg.getId()
						+ "';";

				System.out.println(sql);

				result = query.executeUpdate(sql);

				System.out.println(sql);
				System.out.println(result);

			}catch (SQLException e){
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * Updates a entry in the database 
	 * @param sta the Standort which gets updated
	 * @return  1 if the update has worked otherwise its -1
	 */
	public int updateStandort(Standort sta) {

		int result = 0;
		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "UPDATE Standort SET plz='" + sta.getPlz() + "', ort='" + sta.getOrt()
						+ "', strasse='" + sta.getStrasse() + "', bibliothekar_id='"
						+ sta.getBibliothekarId() + "' WHERE standort_id ='" + sta.getId() + "';";

				System.out.println(sql);

				result = query.executeUpdate(sql);

				System.out.println(sql);
				System.out.println(result);

			}catch (SQLException e){
				e.printStackTrace();
			}
		}

		return result;
	}

	// #############################################################################################
	// #############################################################################################
	/**
	 * Is needed to retrieve the id of an object because the database generates the id. 
	 * After an insertion the object doesnt have any id. It has to be fetched from the database.
	 * The last entry is always the newest one. 
	 * @param tableName The name of the Table where the last entry has to be returned
	 * @return
	 */
	public int getLastEntryId(String tableName) {

		String idName = "";
		int id = -1;
		
		/**
		 * The SQL Statement is different for every table
		 */
		switch (tableName) {
		case "Bibliothekar":
			idName = "bibliothekar_id";
			break;
		case "Entlehnung":
			idName = "entlehnung_id";
			break;
		case "Kunde":
			idName = "kunde_id";
			break;
		case "Medium":
			idName = "medium_id";
			break;
		case "Regal":
			idName = "regal_id";
			break;
		case "Standort":
			idName = "standort_id";
			break;
		default:
			break;
		}

		if(conn != null){
			Statement query;

			try{
				query = conn.createStatement();
				String sql = "SELECT " + idName + " FROM " + tableName + " ORDER BY " + idName
						+ " DESC LIMIT 1;";
				ResultSet result = query.executeQuery(sql);
				result.next();
				id = result.getInt(idName);

			}catch (SQLException e){
				e.printStackTrace();
			}
		}

		return id;
	}

}
