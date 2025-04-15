package fr.esaip;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private double solde;

    @ManyToMany(mappedBy = "comptes")
    private List<Client> clients = new ArrayList<>();

    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
    private List<Operation> operations = new ArrayList<>();
    private ArrayList<Object> comptes;


    



    // Méthode pratique pour ajouter un compte
    public void addCompte(Compte compte) {
        if (this.comptes == null) {
            this.comptes = new ArrayList<>();
        }
        this.comptes.add(compte);
    }

    public void setDecouvert(double v) {
    }

    public void setSolde(double v) {
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}

