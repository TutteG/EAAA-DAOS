package example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JAVAexamples {

	/**
	 * @param args
	 */
	static Connection minConnection;
	static Statement stmt;
	static BufferedReader inLine;

	public static void insertmedstring() {
		try {
			// indlæsning
			System.out.println("Vi vil nu oprette et nyt karakter");
			System.out.println("Indtast cpr (personen skal være oprettet pæ forhænd");
			String cprstr = inLine.readLine();
			System.out.println("Indtast eksamensID for at finde eksamen");
			String eksamenstr = inLine.readLine();
			System.out.println("Indtast ønsket karakter");
			String karakterstr = inLine.readLine();

			// sender insert'en til db-serveren
			String sql = "insert into eksamenStuderende (karakter, eksamenid, cpr) values (" + karakterstr + ", '"
					+ eksamenstr + "', '" + cprstr + "')";
			System.out.println("SQL-streng er " + sql);
			stmt.execute(sql);
			// pænt svar til brugeren
			System.out.println("Karakteren er nu registreret");

			// en form for teststreng..
			sql = "select * from eksamenStuderende";
			System.out.println("SQL-streng er " + sql);
			ResultSet res = stmt.executeQuery(sql);
			// gennemløber svaret
			while (res.next()) {
				System.out.println(
						res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3) + "\t" + res.getString(4));
			}

			if (!minConnection.isClosed()) {
				minConnection.close();
			}
		} catch (SQLException e) {
			switch (e.getErrorCode())
			// fejl-kode 547 svarer til en foreign key fejl
			{
			case 547: {
				if (e.getMessage().contains("studerendecpr")) {
					System.out.println("cpr-nummer er ikke oprettet");
				}
				if (e.getMessage().contains("eksamenid")) {
					System.out.println("eksamen er ikke oprettet");
				}
				break;
			}
			// fejl-kode 2627 svarer til primary key fejl
			case 2627: {
				System.out.println("den pågældende karakter til den pågældende eksamen er allerede oprettet");
				System.out.println("Lav en update!");
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			inLine = new BufferedReader(new InputStreamReader(System.in));
			// generel opsætning
			// via native driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Ændre password og muligvis localhost
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=miniProjektDAOS;user=sa;password=Bambusminister41;");
			stmt = minConnection.createStatement();
			// Indlæsning og kald af den rigtige metode
			insertmedstring();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
