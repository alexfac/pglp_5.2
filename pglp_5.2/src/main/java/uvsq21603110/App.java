package uvsq21603110;

enum AppSingleton {
  ENVIRONNEMENT;

  public void run(String[] args) {
    Groupe g = new Groupe();
    Personnel p = new Personnel.Builder("Test", "Test", "Testeur").build();
    Personnel p2 = new Personnel.Builder("Test", "Test", "Testeur").build();
    Personnel p3 = new Personnel.Builder("Test", "Test", "Testeur").build();
    g.add2Groupe(p);
    g.add2Groupe(p2);
    g.add2Groupe(p3);

    IteratorAll ia = new IteratorAll(g);
    do {
      System.out.println(ia.next().toStringPersonnel());
    } while (ia.hasNext());
  }

  public static void main(String[] args) {
    ENVIRONNEMENT.run(args);
  }
}
