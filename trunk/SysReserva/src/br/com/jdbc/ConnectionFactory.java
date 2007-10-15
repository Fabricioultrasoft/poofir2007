package src.br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.firebirdsql.jdbc.FBDriver");
			return DriverManager.getConnection("jdbc:firebirdsql:localhost/3050:C:/FIR/3º Período/POO/Projeto/SYSRESERVA.GDB","SYSDBA","masterkey");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}

	}

}
