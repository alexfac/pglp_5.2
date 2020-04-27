package uvsq21603110;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOJdbcFactory {

    public Connection connexion = null;

    public void connexion() throws SQLException, ClassNotFoundException {
        String url = "jdbc:derby:personnel;create=true";
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        connexion = DriverManager.getConnection(url);
    }

    public void deconnexion() throws SQLException {
        connexion.close();
    }
}
