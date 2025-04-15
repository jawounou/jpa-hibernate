package fr.esaip;

import jakarta.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        try {
            // 1. Rechercher un emprunt avec ses livres
            System.out.println("=== Recherche d'un emprunt avec ses livres ===");
            rechercherEmpruntAvecLivres(em, 1);

            // 2. Rechercher tous les emprunts d'un client
            System.out.println("\n=== Recherche des emprunts d'un client ===");
            rechercherEmpruntsParClient(em, 1);

        } finally {
            em.close();
            emf.close();
        }
    }

    public static void rechercherEmpruntAvecLivres(EntityManager em, int empruntId) {
        em.getTransaction().begin();

        Emprunt emprunt = em.find(Emprunt.class, empruntId);
        if (emprunt != null) {
            System.out.println("Emprunt trouvé : " + emprunt.getId());

            // Charger les livres associés
            emprunt.getLivres().size(); // Force le chargement de la collection

            System.out.println("Livres associés :");
            for (Livre livre : emprunt.getLivres()) {
                System.out.println("- " + livre.getTitre() + " (" + livre.getAuteur() + ")");
            }
        } else {
            System.out.println("Aucun emprunt trouvé avec l'ID " + empruntId);
        }

        em.getTransaction().commit();
    }

    public static void rechercherEmpruntsParClient(EntityManager em, int clientId) {
        em.getTransaction().begin();

        TypedQuery<Emprunt> query = em.createQuery(
                "SELECT e FROM Emprunt e WHERE e.client.id = :clientId", Emprunt.class);
        query.setParameter("clientId", clientId);

        List<Emprunt> emprunts = query.getResultList();

        System.out.println("Emprunts du client ID " + clientId + ":");
        for (Emprunt e : emprunts) {
            System.out.println("- Emprunt ID: " + e.getId() +
                    ", Date début: " + e.getDateDebut() +
                    ", Date fin: " + e.getDateFin());

            // Pour afficher les livres si nécessaire
            e.getLivres().size();
            System.out.println("  Nombre de livres: " + e.getLivres().size());
        }

        em.getTransaction().commit();
    }
}
