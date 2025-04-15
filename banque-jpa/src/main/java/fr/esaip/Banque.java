package fr.esaip;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "banque")
    private List<Client> clients = new ArrayList<>();

    public void setNom(String maBanque) {
    }

    // Getters et setters
}