package uvsq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao<T> {

  Connection connexion = null;

  public abstract T create(T obj);

  public abstract T find(String id);

  public abstract T update(T obj);

  public abstract void delete(String nom);

  /**
   * Connexion bd.
   */
  public void connexion() {
    String url = "jdbc:derby:test;create=true";
    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    try {
      this.connexion = DriverManager.getConnection(url);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  /**
   * Deconnexion bd.
   */
  public void deconnexion() {
    try {
      this.connexion.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
