package uvsq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoJdbcFactory {

  public Connection connexion = null;

  /**
   * COnnexion.
   * @throws SQLException excpetion bd
   * @throws ClassNotFoundException exception class
   */
  public void connexion() throws SQLException, ClassNotFoundException {
    String url = "jdbc:derby:test;create=true";
    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    connexion = DriverManager.getConnection(url);
  }

  public void deconnexion() throws SQLException {
    connexion.close();
  }
}
