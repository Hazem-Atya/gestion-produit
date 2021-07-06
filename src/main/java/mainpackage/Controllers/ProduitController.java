package mainpackage.Controllers;

import mainpackage.entities.Produit;
import mainpackage.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    ProduitService serv;

    @PostMapping("/add")
    ResponseEntity<Produit> addProduct(@RequestBody Produit p) {
        return new ResponseEntity<>(serv.add(p), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    ResponseEntity<List<Produit>> getAll() {
        List<Produit> produits = this.serv.getAll();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }
    @PutMapping("/update")
    ResponseEntity<Produit> updateProduit(@RequestBody Produit p){
        Produit updateProduit = serv.add(p);
        return new ResponseEntity<>(updateProduit, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteProduit(@PathVariable("id") Long id)
    {
        this.serv.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
