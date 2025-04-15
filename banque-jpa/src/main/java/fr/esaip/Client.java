package fr.esaip;

import jakarta.persistence.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Banque banque;

    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;

    @ManyToMany
    @JoinTable(name = "client_compte",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "compte_id"))
    private List<Compte> comptes = new ArrayList<>();

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
    // Méthode pratique pour ajouter un compte
    public void addCompte(Compte compte) {
        if (this.comptes == null) {
            this.comptes = new ArrayList<>();
        }
        this.comptes.add(compte);
    }

    public List<Compte> getComptes() {
        if (this.comptes == null) {
            this.comptes = new ArrayList<>();
        }
        return this.comptes;
    }
}
