package fr.esaip;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montant;
    private String motif;
    private LocalDateTime date;

    @ManyToOne
    private Compte compte;

    public void setMotif(String dépôt) {
    }

    public void setMontant(double v) {
    }

    public void setDate(LocalDateTime now) {
    }

    public void setCompte(Courant compteCourant) {
    }

    public void setBeneficiaire(String mrDupont) {
    }

    // Getters et setters
}