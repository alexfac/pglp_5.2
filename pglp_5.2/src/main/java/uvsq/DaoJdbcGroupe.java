package uvsq;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoJdbcGroupe extends Dao<Groupe> {
  @Override
  public Groupe create(Groupe obj) {
    this.connexion();
    try {
      PreparedStatement insertGroupe =
          this.connexion.prepareStatement("INSERT INTO Groupe(nom) VALUES(?)");
      insertGroupe.setString(1, obj.getNom());
      insertGroupe.execute();

      for (Personnel p : obj.getListPerso()) {
        PreparedStatement insertPersonnelGroupe =
            this.connexion.prepareStatement("INSERT INTO Appartient(nomg, nomperso) VALUES(?, ?)");
        insertPersonnelGroupe.setString(1, obj.getNom());
        insertPersonnelGroupe.setString(2, p.getNom());
        insertPersonnelGroupe.execute();
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    this.deconnexion();
    return obj;
  }

  @Override
  public Groupe find(String nom) {
    this.connexion();
    Groupe groupe = null;
    try {
      PreparedStatement selectGroupe =
          this.connexion.prepareStatement("SELECT * FROM Groupe WHERE nom = ?");
      selectGroupe.setString(1, nom);
      selectGroupe.execute();
      ResultSet res = selectGroupe.executeQuery();
      if (res.next()) {
        groupe = new Groupe(res.getString("nom"));
        PreparedStatement selectPersoGroupe =
            this.connexion.prepareStatement("SELECT * FROM Appartient WHERE nomg = ?");
        selectPersoGroupe.setString(1, nom);
        selectPersoGroupe.execute();
        ResultSet res1 = selectPersoGroupe.executeQuery();
        if (res1.next()) {
          DaoJdbcPersonnel perso = new DaoJdbcPersonnel();
          // System.out.println(Res1.getString(2));
          groupe.add2Groupe(perso.find(res1.getString(2)));
        } else {
          System.out.println("pas de personnel");
        }
      } else {
        System.out.println("pas de groupe");
        return null;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    this.deconnexion();
    return groupe;
  }

  @Override
  public Groupe update(Groupe obj) {
    return null;
  }

  @Override
  public void delete(String nom) {
    this.connexion();

    try {
      PreparedStatement deleteGroupe =
          this.connexion.prepareStatement("DELETE FROM Groupe WHERE nom = ?");
      deleteGroupe.setString(1, nom);
      deleteGroupe.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    this.deconnexion();
  }
}
