package uvsq21603110;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOJdbcPersonnel extends DAO<Personnel>{
    @Override
    public Personnel create(Personnel obj) {
        this.connexion();

        try {
            PreparedStatement InsertPersonnel = this.connexion.prepareStatement(" INSERT INTO Personnel(nom,prenom,fonction,arrivee) VALUES(?,?,?,?)");
            InsertPersonnel.setString(1, obj.getNom());
            InsertPersonnel.setString(2, obj.getPrenom());
            InsertPersonnel.setString(3, obj.getFonction());
            InsertPersonnel.setString(4, String.valueOf(obj.getNaissance()));
            InsertPersonnel.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        this.deconnexion();
        return obj;
    }

    @Override
    public Personnel find(String id) {
        return null;
    }

    @Override
    public Personnel update(Personnel obj) {
        return null;
    }

    @Override
    public void delete(String nom) {
        this.connexion();
        try {
            PreparedStatement DeletePersonnel = this.connexion.prepareStatement("DELETE FROM Personnel WHERE nom = ?");
            DeletePersonnel.setString(1,nom);
            DeletePersonnel.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        this.deconnexion();
    }
}
