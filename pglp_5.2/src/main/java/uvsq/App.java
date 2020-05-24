package uvsq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

enum App {
  ENVIRONNEMENT;

  public static Connection connexion = null;
  public static Statement statement = null;

  public static void initDAOJdbc() {

    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      connexion = DriverManager.getConnection("jdbc:derby:test;create=true");
      statement = connexion.createStatement();

      String delete = "DROP TABLE Personnel";
      statement.execute(delete);
      delete = "DROP TABLE Groupe";
      statement.execute(delete);
      delete = "DROP TABLE Appartient";
      statement.execute(delete);

      String Table =
              "CREATE TABLE Personnel(nom varchar(30), prenom varchar(30), fonction varchar (30), arrivee DATE)";
      statement.execute(Table);
      Table = "CREATE TABLE Groupe(nom varchar(50))";
      statement.execute(Table);
      Table = "CREATE TABLE Appartient(nomg varchar(50), nomperso varchar(30))";
      statement.execute(Table);
      connexion.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      try {
        connexion.close();
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
  }

  public void run(String[] args) {
    Dao daopersonnel = new DaoJdbcPersonnel();
    Personnel p = new Personnel.Builder("Test", "Test", "Testeur").build();
    daopersonnel.create(p);
    Personnel p1 = (Personnel) daopersonnel.find("Test");
    System.out.println(p1.getNom());
    System.out.println(p1.getPrenom());
    System.out.println(p1.getFonction());
  }

  public static void main(String[] args) {
    ENVIRONNEMENT.run(args);
  }
}
