package cykeldb2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JAVAexamples {

	/**
	 * @param args
	 */
	static Connection minConnection;
	static Statement stmt;
	static BufferedReader inLine;
	static ArrayList<Rytter> ryttere;

	public static void selectudenparm() {
		try {
			// Laver sql-sætning og før den udført
			String sql = "select p.init, p.plac, p.aarstal from placering p";
			System.out.println("SQL-streng er " + sql);
			ResultSet res = stmt.executeQuery(sql);
			// gennemlæber svaret
			while (res.next()) {
				String s;
				s = res.getString("init");
				System.out.println(s + "    " + res.getString(2));
				System.out.println(s + "    " + res.getString(3));
			}
			// pæn lukning
			if (!minConnection.isClosed()) {
				minConnection.close();
			}
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

	public static void selectmedparm() {
		try {
			// Indlæser søgestreng
			System.out.println("Indtast søgestreng");
			String inString = inLine.readLine();
			// Laver sql-sætning og får den udført
			String sql = "select p.aarstal, isnull(p.plac, 0) from placering p where p.init like '" + inString + "%'";
			System.out.println("SQL-streng er " + sql);
			ResultSet res = stmt.executeQuery(sql);
			// gennemløber svaret
			while (res.next()) {
				if (res.getString(2).equals("0")) {
					System.out.println(res.getString(1) + "    " + "UDGÅET");
				} else {
					System.out.println(res.getString(1) + "    " + res.getString(2));
				}
			}
			// pæn lukning
			if (!minConnection.isClosed()) {
				minConnection.close();
			}
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

	public static void insertmedstring() {
		try {
			// indlæsning
			System.out.println("Vi vil nu oprette et nyt ansættelsesfforhold");
			System.out.println("Indtast init (rytteren skal være oprettet på forhånd");
			String init = inLine.readLine();
			System.out.println("Indtast placering (VM skal være oprettet på forhånd");
			String placering = inLine.readLine();

			// sender insert'en til db-serveren
			String sql = "insert into placering values (2016, '" + init + "'," + placering + ")";
			System.out.println("SQL-streng er " + sql);
			stmt.execute(sql);
			// pænt svar til brugeren
			System.out.println("Placeringen er nu registreret");
			if (!minConnection.isClosed()) {
				minConnection.close();
			}
		} catch (SQLException e) {
			switch (e.getErrorCode())
			// fejl-kode 547 svarer til en foreign key fejl
			{
			case 547: {
				if (e.getMessage().contains("initforeign")) {
					System.out.println("init er ikke oprettet");
				}
				if (e.getMessage().contains("aarstalforeign")) {
					System.out.println("VM er ikke oprettet");
				}
				break;
			}
			// fejl-kode 2627 svarer til primary key fejl
			case 2627: {
				System.out.println("den pågældende ansættelse er allerede oprettet");
				break;
			}
			default:
				System.out.println("fejlSQL:  " + e.getMessage());
			}
			;
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	};

	public static void insertprepared() {
		try {
			// indlæsning
//			System.out.println("Vi vil nu oprette et nyt ansættelsesfforhold");
			System.out.println("Indtast init (rytter skal være oprettet på forhænd");
			String init = inLine.readLine();
			System.out.println("Indtast placering");
			String placering = inLine.readLine();
			// Anvendelse af prepared statement
			String sql = "insert into placering values (2016, ?,?)";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();
			prestmt.setString(1, init);
			prestmt.setInt(2, Integer.parseInt(placering));
			// Udfærer sætningen
			prestmt.execute();
			// pænt svar til brugeren
			System.out.println("Placeringen er nu registreret");
			if (!minConnection.isClosed()) {
				minConnection.close();
			}
		} catch (SQLException e) {
			switch (e.getErrorCode())
			// fejl-kode 547 svarer til en foreign key fejl
			{
			case 547: {
				if (e.getMessage().contains("cprforeign")) {
					System.out.println("cpr-nummer er ikke oprettet");
				}
				if (e.getMessage().contains("firmaforeign")) {
					System.out.println("firmaet er ikke oprettet");
				}
				break;
			}
			// fejl-kode 2627 svarer til primary key fejl
			case 2627: {
				System.out.println("den pågældende ansættelse er allerede oprettet");
				break;
			}
			default:
				System.out.println("fejlSQL:  " + e.getMessage());
			}
			;
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	};

	public static void selectUdenParmToArrayList() {
		try {
			// Laver sql-sætning og før den udført
			String sql = "select r.init, r.rytternavn from rytter r";
			System.out.println("SQL-streng er " + sql);
			ResultSet res = stmt.executeQuery(sql);
			// gennemløber svaret
			while (res.next()) {
				String s1 = res.getString(1);
				String s2 = res.getString(2);
				Rytter rytter = new Rytter(s1, s2);
				ryttere.add(rytter);
			}
			// pæn lukning
			if (!minConnection.isClosed()) {
				minConnection.close();
			}
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ryttere = new ArrayList<Rytter>();
		try {
			inLine = new BufferedReader(new InputStreamReader(System.in));
			// generel opsætning
			// via native driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Opgave7_Cykelrytter;user=sa;password=Bambusminister41;");
			stmt = minConnection.createStatement();
			// Indlæsning og kald af den rigtige metode
			System.out.println("Indtast  ");
			System.out.println("s for select uden parameter  ");
			System.out.println("sp for select med parameter  ");
			System.out.println("i for insert med strengmanipulation");
			System.out.println("ps for insert med prepared statement ");
			System.out.println("ta for at lægge db ned i arraylist");
			String in = inLine.readLine();
			switch (in) {
			case "s": {
				selectudenparm();
				break;
			}
			case "sp": {
				selectmedparm();
				break;
			}
			case "i": {
				insertmedstring();
				break;
			}
			case "ps": {
				insertprepared();
				break;
			}
			case "ta": {
				selectUdenParmToArrayList();
			}
			default:
				System.out.println("ukendt indtastning");
			}

			for (Rytter rytter : ryttere) {
				System.out.println(rytter.getInit() + "\t" + rytter.getNavn());
			}
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
