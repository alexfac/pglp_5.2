package uvsq;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoJdbcPersonnel extends Dao<Personnel> {
  @Override
  public Personnel create(Personnel obj) {
    this.connexion();

    try {
      PreparedStatement insertPersonnel =
          this.connexion.prepareStatement(
              " INSERT INTO Personnel(nom,prenom,fonction,arrivee) VALUES(?,?,?,?)");
      insertPersonnel.setString(1, obj.getNom());
      insertPersonnel.setString(2, obj.getPrenom());
      insertPersonnel.setString(3, obj.getFonction());
      insertPersonnel.setString(4, String.valueOf(obj.getNaissance()));
      insertPersonnel.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    this.deconnexion();
    return obj;
  }

  @Override
  public Personnel find(String nom) {
    this.connexion();
    Personnel personnel = null;
    try {
      PreparedStatement selectPersonnel =
          this.connexion.prepareStatement("SELECT * FROM Personnel WHERE nom = ?");
      selectPersonnel.setString(1, nom);
      selectPersonnel.execute();
      ResultSet res = selectPersonnel.executeQuery();
      if (res.next()) {
        personnel =
            new Personnel.Builder(
                    res.getString("nom"), res.getString("prenom"), res.getString("fonction"))
                .build();
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    this.deconnexion();
    return personnel;
  }

  @Override
  public Personnel update(Personnel obj) {
    return null;
  }

  @Override
  public void delete(String nom) {
    this.connexion();
    try {
      PreparedStatement deletePersonnel =
          this.connexion.prepareStatement("DELETE FROM Personnel WHERE nom = ?");
      deletePersonnel.setString(1, nom);
      deletePersonnel.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    this.deconnexion();
  }
}
