package uvsq21603110;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOJdbcGroupe extends DAO<Groupe>{
    @Override
    public Groupe create(Groupe obj) {
        this.connexion();
        try{
            PreparedStatement InsertGroupe = this.connexion.prepareStatement("INSERT INTO Groupe(nom) VALUES(?)");
            InsertGroupe.setString(1, obj.getNom());
            InsertGroupe.execute();

            for(Personnel p : obj.getListPerso()){
                PreparedStatement InsertPersonnelGroupe = this.connexion.prepareStatement("INSERT INTO Appartient(nomg, nomperso) VALUES(?, ?)");
                InsertPersonnelGroupe.setString(1, obj.getNom());
                InsertPersonnelGroupe.setString(2, p.getNom());
                InsertPersonnelGroupe.execute();
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
        Groupe Groupe = null;
        try {
            PreparedStatement SelectGroupe = this.connexion.prepareStatement("SELECT * FROM Groupe WHERE nom = ?");
            SelectGroupe.setString(1,nom);
            SelectGroupe.execute();
            ResultSet Res = SelectGroupe.executeQuery();
            if (Res.next()){
                Groupe = new Groupe(Res.getString("nom"));
                PreparedStatement SelectPersoGroupe = this.connexion.prepareStatement("SELECT * FROM Appartient WHERE nomg = ?");
                SelectPersoGroupe.setString(1,nom);
                SelectPersoGroupe.execute();
                ResultSet Res1 = SelectPersoGroupe.executeQuery();
                if (Res1.next()){
                    DAOJdbcPersonnel perso= new DAOJdbcPersonnel();
                    //System.out.println(Res1.getString(2));
                    Groupe.add2Groupe(perso.find(Res1.getString(2)));
                }else{
                    System.out.println("pas de personnel");
                }
            }else{
                System.out.println("pas de groupe");
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.deconnexion();
        return Groupe;
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
