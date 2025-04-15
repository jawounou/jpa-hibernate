package fr.esaip;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("VIREMENT")
public class Virement extends Operation {
    private String beneficiaire;

    // Getters et setters
}