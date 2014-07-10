package com.epam.firstSprint.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.*;

import com.epam.firstSprint.pageObject.BeforeLoginPage;
import com.epam.firstSprint.pageObject.DriverCalendarPage;

public class BaseTest {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://evbyminsd7238.minsk.epam.com:5432/pdrzh_for_testers";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "123";

	// SQL countRecordsInFromColumn statement
	protected static int countRecordsInColumnFromDb(String query) throws SQLException {
		Connection dbConnection = null;
		Statement st = null;

		// count statements
		String countTrips = "select count(*)as qty"
				+ " from point"
				+ " where name = '"+query+"'";

		int count = 0;
		try {
			dbConnection = getDBConnection();
			st = dbConnection.createStatement();

			// execute delete SQL stetement
			ResultSet rs = st.executeQuery(countTrips);
			while (rs.next()) {
				count = rs.getInt("qty");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			if (st != null) {
				st.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return count;
	}

	// method that connect to DB
	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	@BeforeSuite
	public void init() {
		Driver.init();
		BeforeLoginPage beforeLoginPage = BeforeLoginPage.open();
		beforeLoginPage.loginIntoSystem();
	}

	@AfterSuite
	public void cleanup() {
		DriverCalendarPage dcal = new DriverCalendarPage();
		dcal.logout();
		Driver.tearDown();
	}
}
