package mainpackage.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.Set;

@Entity
@Getter
@Setter
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int qt;
//    @GeneratedValue(strategy = GenerationType.)
    @Column(updatable = false)
    private java.sql.Date dateCreation = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    private java.sql.Date datemodif = new java.sql.Date(Calendar.getInstance().getTime().getTime());
/*    @OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Produit> produits;*/
}
