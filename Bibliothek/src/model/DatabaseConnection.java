package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnection {

	private static Connection conn = null;
	private static String dbHost = "192.168.56.2"; // Hostname
	private static String dbPort = "3306"; // Port -- Standard: 3306
	private static String dbName = "Bibliothek"; // Datenbankname
	private static String dbUser = "root"; // Datenbankuser
	private static String dbPass = ""; // Datenbankpasswort

	// TODO Auto-generated method stub
	public DatabaseConnection() {

		System.out.println("jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?" + "user="
				+ dbUser + "&" + "password=" + dbPass);
		try{
			Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber für JDBC
													// Schnittstellen laden.

			// Verbindung zur JDBC-Datenbank herstellen.

			conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":" + dbPort + "/"
					+ dbName + "?" + "user=" + dbUser + "&" + "password=" + dbPass);
			// conn = DriverManager.getConnection("jdbc:mysql://192.168.56.2:3306","root","");

		}catch (ClassNotFoundException e){
			System.out.println("Treiber nicht gefunden");
		}catch (SQLException e){
			System.out.println("Verbindung nicht moglich");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			System.out.println(e.getErrorCode());
		}
	}

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
	
	public Standort getStandortById(int id){
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
