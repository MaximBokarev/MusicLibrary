package name.max.musiclibrary.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO<T> implements DAO<T> {
	protected Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:hsqldb:file:F:/Database/musiclibrary", "SA", "");
		} catch (SQLException e) {
			throw new RuntimeException(e); 
		}
		
	}

}
