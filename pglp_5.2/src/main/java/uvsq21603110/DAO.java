package uvsq21603110;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO<T> {

  Connection connexion = null;

  public abstract T create(T obj);

  public abstract T find(String id);

  public abstract T update(T obj);

  public abstract void delete(String nom);

  public void connexion() {
    String url = "jdbc:derby:test;create=true";
    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    try {
      connexion = DriverManager.getConnection(url);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
  public void deconnexion(){
    try{
      connexion.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
