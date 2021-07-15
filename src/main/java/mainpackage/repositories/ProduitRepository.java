package mainpackage.repositories;

import mainpackage.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByCategorieId(Long id);

    @Transactional
    void removeByCategorieId(Long id);
    @Query(value = "select p.datemodif,p.categorie.nom from Produit p, Categorie c where p.categorie.id=c.id")
    List<Object> getProduitsWihCategorieName();
}
