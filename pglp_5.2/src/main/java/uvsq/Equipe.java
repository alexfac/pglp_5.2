package uvsq;

import java.util.ArrayList;

public abstract class Equipe {

  private ArrayList<Groupe> listgroupe;

  public Equipe() {
    this.listgroupe = new ArrayList<Groupe>();
  }

  public void add2Equipe(Groupe g) {
    this.listgroupe.add(g);
  }

  /**
   * Groupe liste.
   * @return liste
   */
  public ArrayList<Groupe> getListGroup() {
    // ArrayList<Groupe> unmodifiableList = (ArrayList<Groupe>)
    // Collections.unmodifiableList(listgroupe);
    ArrayList<Groupe> unmodifiableList = listgroupe;
    return unmodifiableList;
  }
}
