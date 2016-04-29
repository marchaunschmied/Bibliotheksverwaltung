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

	private static Connection getInstance() {
		if(conn == null){
			new DatabaseConnection();
		}
		return conn;
	}

	public ArrayList getKunden() {

		ArrayList<Kunde> list = new ArrayList();
		conn = getInstance();

		if(conn != null){
			Statement query;
			try{
				query = conn.createStatement();
				String sql = "SELECT * FROM Kunde";
				ResultSet result = query.executeQuery(sql);

				while(result.next()){
					Kunde k = new Kunde();
					k.setId(result.getInt("kunde_id"));
					k.setName(result.getString("name"));
					k.setGbdatum(result.getDate("geburtsdatum"));
					k.setStrasse(result.getString("strasse"));
					k.setWohnort(result.getString("wohnort"));
					k.setPlz(result.getString("plz"));

					list.add(k);

				}

			}catch (SQLException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;

	}

	public ArrayList getEntlehnung() {
		ArrayList<Entlehnung> list = new ArrayList();
		conn = getInstance();

		if(conn != null){
			Statement query;
			try{
				query = conn.createStatement();
				String sql = "SELECT * FROM Entlehnung";
				ResultSet result = query.executeQuery(sql);

				while(result.next()){
					Entlehnung e = new Entlehnung();
					e.setId(result.getInt("entlehnung_id"));
					e.setKunde_id(result.getInt("kunde_id"));
					e.setMedium_id(result.getInt("medium_id"));
					e.setVon(result.getDate("von"));
					e.setBis(result.getDate("bis"));
					list.add(e);

				}

			}catch (SQLException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return list;
		
	}

}
