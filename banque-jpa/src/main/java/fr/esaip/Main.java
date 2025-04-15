package fr.esaip;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banquePU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Création d'une banque
            Banque banque = new Banque();
            banque.setNom("Ma Banque");
            em.persist(banque);

            // Création d'une adresse
            Adresse adresse = new Adresse();
            adresse.setNumero("12");
            adresse.setRue("Rue de la Paix");
            adresse.setCodePostal("75001");
            adresse.setVille("Paris");
            em.persist(adresse);

            // Création d'un client
            Client client = new Client();
            client.setBanque(banque);
            client.setAdresse(adresse);
            em.persist(client);

            // Création des comptes
            Courant compteCourant = new Courant();
            compteCourant.setNumero("CC123456");
            compteCourant.setSolde(1500.0);
            compteCourant.setDecouvert(500.0);
            em.persist(compteCourant);

            LivretA livretA = new LivretA();
            livretA.setNumero("LA789012");
            livretA.setSolde(3000.0);
            livretA.setTaux(2.5);
            em.persist(livretA);

            // Association client-comptes
            client.getComptes().add(compteCourant);
            client.getComptes().add(livretA);

            // Création d'opérations
            Operation op1 = new Operation();
            op1.setMontant(100.0);
            op1.setMotif("Dépôt");
            op1.setDate(LocalDateTime.now());
            op1.setCompte(compteCourant);
            em.persist(op1);

            Virement virement = new Virement();
            virement.setMontant(200.0);
            virement.setMotif("Virement salaire");
            virement.setDate(LocalDateTime.now());
            virement.setCompte(compteCourant);
            virement.setBeneficiaire("Mr Dupont");
            em.persist(virement);

            em.getTransaction().commit();

            System.out.println("Données insérées avec succès !");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}