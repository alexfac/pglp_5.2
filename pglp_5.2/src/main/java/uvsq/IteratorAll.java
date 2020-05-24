package uvsq;

import java.util.Iterator;

public class IteratorAll implements Iterator {

  private Groupe gr;
  private int cmp;

  public IteratorAll(Groupe e) {
    this.gr = e;
    this.cmp = 0;
  }

  @Override
  public boolean hasNext() {
    try {
      if (gr.getListGroup().size() > cmp) {
        return true;
      }
      return false;
    } catch (Exception e) {
      e.getMessage();
    }
    return false;
  }

  @Override
  public Personnel next() {
    Personnel p;
    p = gr.getListPerso().get(cmp);
    cmp++;
    return p;
  }
}
