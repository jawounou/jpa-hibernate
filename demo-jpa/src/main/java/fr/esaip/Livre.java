package fr.esaip;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "livre")
public class Livre{


    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TITRE", nullable = false)
    private String titre;

    @Column(name = "AUTEUR", nullable = false)
    private String auteur;

    @ManyToMany(mappedBy = "livres")
    private List<Emprunt> emprunt;

    // ... (le reste reste inchangé)

    public List<Emprunt> getEmprunts() {
        return emprunt;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunt = emprunts;
    }

    public String getTitre() {
        return titre;
    }
    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
}
}