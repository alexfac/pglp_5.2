package uvsq21603110;

import java.util.Iterator;

public class IteratorAll implements Iterator {

  private Groupe e;
  private int cmp;

  public IteratorAll(Groupe e) {
    this.e = e;
    this.cmp = 0;
  }

  @Override
  public boolean hasNext() {
    try {
      if (e.getListGroup().size() > cmp) {
        return true;
      }
      return false;
    } catch (Exception E) {
      E.getMessage();
    }
    return false;
  }

  @Override
  public Personnel next() {
    Personnel P;
    P = e.getListPerso().get(cmp);
    cmp++;
    return P;
  }
}
