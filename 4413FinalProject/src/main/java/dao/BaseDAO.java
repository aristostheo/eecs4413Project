package dao;

import java.sql.Connection;

public abstract class BaseDAO {
	protected Connection getConnection() {
		return ConnectionManager.getConnection();
	}
}
