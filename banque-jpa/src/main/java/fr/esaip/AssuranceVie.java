package fr.esaip;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class AssuranceVie extends Compte {
    private LocalDate dateFin;
    private double taux;

    // Getters et setters
}