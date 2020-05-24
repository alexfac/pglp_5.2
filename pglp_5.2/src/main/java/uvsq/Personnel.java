package uvsq;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Personnel extends Equipe implements Serializable {

  private final String nom;
  private final String prenom;
  private final String fonction;
  private final LocalDate naissance;
  private final List<String> telephone;

  public static class Builder {
    private final String nom;
    private final String prenom;
    private final String fonction;
    private LocalDate naissance = LocalDate.now();
    private List<String> telephone = null;

    /**
     * Constructeur builder.
     * @param nom nom
     * @param prenom prenom
     * @param fonction fonction
     */
    public Builder(String nom, String prenom, String fonction) {
      this.nom = nom;
      this.prenom = prenom;
      this.fonction = fonction;
      this.telephone = new ArrayList<>();
    }

    public Builder addNaissance(LocalDate d) {
      this.naissance = d;
      return this;
    }

    public Builder addTel(String tel) {
      this.telephone.add(tel);
      return this;
    }

    public Personnel build() {
      return new Personnel(this);
    }
  }

  /**
   * builder personnel.
   * @param builder builder
   */
  public Personnel(Builder builder) {
    this.nom = builder.nom;
    this.prenom = builder.prenom;
    this.fonction = builder.fonction;
    this.naissance = builder.naissance;
    this.telephone = builder.telephone;
  }

  public String getNom() {
    return this.nom;
  }

  public String getPrenom() {
    return this.prenom;
  }

  public String getFonction() {
    return this.fonction;
  }

  public List getTel() {
    return Collections.unmodifiableList(this.telephone);
  }

  public LocalDate getNaissance() {
    return this.naissance;
  }

  public String toStringPersonnel() {
    return this.getNom() + this.getPrenom() + this.getFonction() + this.getNaissance();
  }
}
