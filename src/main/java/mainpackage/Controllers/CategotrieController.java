package mainpackage.Controllers;

import mainpackage.entities.Categorie;
import mainpackage.services.CategorieService;
import mainpackage.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategotrieController {
    @Autowired
    CategorieService serv;
    @Autowired
    ProduitService prodServ;

    @PostMapping("/add")
    ResponseEntity<Categorie> addCategorie(@RequestBody Categorie c) {
        return new ResponseEntity<>(serv.add(c), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    ResponseEntity<Categorie> getById(@PathVariable("id") Long id) {
       Categorie categories = this.serv.findCategorieById(id);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/all")
    ResponseEntity<List<Categorie>> getAll() {
        List<Categorie> categories = this.serv.getAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<Categorie> updateCategorie(@RequestBody Categorie c) {
        c.setDatemodif(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        Categorie updateCategorie = serv.add(c);
        return new ResponseEntity<>(updateCategorie, HttpStatus.OK);
    }

/*
    @Transactional
*/
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteCategotrie(@PathVariable("id") Long id) {
        prodServ.deleteByCategorieId(id);
        this.serv.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
