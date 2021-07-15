package mainpackage.Controllers;

import mainpackage.entities.Categorie;
import mainpackage.entities.Produit;
import mainpackage.services.CategorieService;
import mainpackage.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    ProduitService serv;
    @Autowired
    CategorieService catServ;

    public ProduitController(ProduitService serv, CategorieService catServ) {
        this.serv = serv;
        this.catServ = catServ;
    }

    @PostMapping("/add/{cat_id}")
    ResponseEntity<Produit> addProduct(@RequestBody Produit p, @PathVariable("cat_id") Long cat_id) {
        Categorie c = catServ.findCategorieById(cat_id);
        p.setCategorie(c);
        return new ResponseEntity<>(serv.add(p), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Produit> getProduitById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(serv.getProduitById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    ResponseEntity<List<Produit>> getAll() {
        List<Produit> produits = this.serv.getAll();
        for (Produit p : produits) {
            p.setCatID(p.getCategorie().getId());
            p.setCatName(p.getCategorie().getNom());
        }
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    ResponseEntity<List<Object>> getAll1() {
        List<Object> produits = this.serv.getAll1();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    @PutMapping("/update/{cat_id}")
    ResponseEntity<Produit> updateProduit(@RequestBody Produit p, @PathVariable("cat_id") Long cat_id) {
        Categorie c = catServ.findCategorieById(cat_id);
        p.setCategorie(c);
        p.setDatemodif(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        Produit updateProduit = serv.add(p);
        return new ResponseEntity<>(updateProduit, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteProduit(@PathVariable("id") Long id) {
        this.serv.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all/categorie/{catId}")
    ResponseEntity<List<Produit>> getAllByCategorieId(@PathVariable("catId") Long id) {
        return new ResponseEntity<>(this.serv.findByCategorieId(id), HttpStatus.OK);
    }
}
