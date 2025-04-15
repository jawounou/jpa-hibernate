package fr.esaip;

import jakarta.persistence.*;

@Entity
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String rue;
    private String codePostal;
    private String ville;

     public void setNumero(String numero) {
        this.numero = numero;
      }
      public void setRue(String rue) {
           this.rue = rue;
     }
     public void setCodePostal(String codePostal) {
          this.codePostal = codePostal;
      }
      public void setVille(String ville) {
          this.ville = ville;
}
}