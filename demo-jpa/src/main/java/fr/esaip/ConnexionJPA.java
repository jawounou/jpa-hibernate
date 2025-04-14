package fr.esaip;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJPA {
    public static void main(String[] args) {
        System.out.println("Tentative de connexion à la base de données via JPA...");

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("default");
            em = emf.createEntityManager();
            System.out.println("Connexion réussie !");
        } catch (Exception e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}