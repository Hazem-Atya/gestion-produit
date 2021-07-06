package mainpackage.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Getter
@Setter

public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    Long id;
    String nom;
    int qt;
    boolean disponible;
    @Column(updatable = false)
    java.sql.Date dateCreation = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    java.sql.Date datemodif=new java.sql.Date(Calendar.getInstance().getTime().getTime());
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categorie categorie;
}
