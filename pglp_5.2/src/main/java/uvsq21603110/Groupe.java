package uvsq21603110;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Groupe extends Equipe implements Serializable {

  private List PersonnelList;

  public Groupe() {

    this.PersonnelList = new ArrayList<Personnel>();
  }

  public void add2Groupe(Personnel p) {

    this.PersonnelList.add(p);
  }

  public List<Personnel> getListPerso() {
    List<Personnel> unmodifiableList = Collections.unmodifiableList(PersonnelList);
    return unmodifiableList;
  }
}
