package uvsq21603110;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Personnel extends Equipe implements Serializable {

  private final String Nom;
  private final String Prenom;
  private final String Fonction;
  private final LocalDate Naissance;
  private final List<String> Telephone;

  public static class Builder {
    private final String Nom;
    private final String Prenom;
    private final String Fonction;
    private LocalDate Naissance = LocalDate.now();
    private List<String> Telephone = null;

    public Builder(String nom, String prenom, String fonction) {
      this.Nom = nom;
      this.Prenom = prenom;
      this.Fonction = fonction;
      this.Telephone = new ArrayList<>();
    }

    public Builder addNaissance(LocalDate d) {
      this.Naissance = d;
      return this;
    }

    public Builder addTel(String tel) {
      this.Telephone.add(tel);
      return this;
    }

    public Personnel build() {
      return new Personnel(this);
    }
  }

  public Personnel(Builder builder) {
    this.Nom = builder.Nom;
    this.Prenom = builder.Prenom;
    this.Fonction = builder.Fonction;
    this.Naissance = builder.Naissance;
    this.Telephone = builder.Telephone;
  }

  public String getNom() {
    return this.Nom;
  }

  public String getPrenom() {
    return this.Prenom;
  }

  public String getFonction() {
    return this.Fonction;
  }

  public List getTel() {
    return Collections.unmodifiableList(this.Telephone);
  }

  public LocalDate getNaissance() {
    return this.Naissance;
  }

  public String toStringPersonnel() {
    return this.getNom() + this.getPrenom() + this.getFonction() + this.getNaissance();
  }
}
