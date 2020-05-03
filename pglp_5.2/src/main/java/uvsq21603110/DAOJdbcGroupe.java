package uvsq21603110;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOJdbcGroupe extends DAO<Groupe>{
    @Override
    public Groupe create(Groupe obj) {
        this.connexion();
        try{
            PreparedStatement InsertPersonnelGroupe = this.connexion.prepareStatement("INSERT INTO Groupe(nom) VALUES(?)");
            InsertPersonnelGroupe.setString(1, obj.getNom());
            InsertPersonnelGroupe.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    @Override
    public Groupe find(String id) {
        return null;
    }

    @Override
    public Groupe update(Groupe obj) {
        return null;
    }

    @Override
    public void delete(String nom) {
        this.connexion();

        try {
            PreparedStatement DeleteGroupe = this.connexion.prepareStatement("DELETE FROM Groupe WHERE nom = ?");
            DeleteGroupe.setString(1,nom);
            DeleteGroupe.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        this.deconnexion();
    }
}
