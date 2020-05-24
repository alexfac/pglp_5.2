package uvsq;

public class DaoFactory {

  public static Dao<Personnel> getDaoPersonnel() {
    return new Daopersonnel();
  }

  public static Dao<Groupe> getDaoGroupe() {
    return new DaoGroupe();
  }
}
