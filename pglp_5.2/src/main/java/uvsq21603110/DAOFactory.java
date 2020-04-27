package uvsq21603110;

public class DAOFactory {

  public static DAO<Personnel> getDAOPersonnel() {
    return new DAOpersonnel();
  }

  public static DAO<Groupe> getDAOGroupe() {
    return new DAOGroupe();
  }
}
