package fr.esaip;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "client")
    public class Client {

        @Id
        @Column(name = "ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "NOM", nullable = false)
        private String nom;

        @Column(name = "PRENOM", nullable = false)
        private String prenom;

        @OneToMany(mappedBy = "client")
        private List<Emprunt> emprunt;

        // Constructeurs
        public Client() {
        }

        public Client(String nom, String prenom) {
            this.nom = nom;
            this.prenom = prenom;
        }

        // Getters et Setters
        public Integer getId() {
            return id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public List<Emprunt> getEmprunt() {
            return emprunt;
        }

        public void setEmprunt(List<Emprunt> emprunt) {
            this.emprunt = emprunt;
        }

        @Override
        public String toString() {
            return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
        }
    }
