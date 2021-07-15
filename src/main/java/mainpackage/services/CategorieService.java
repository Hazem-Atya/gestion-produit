package mainpackage.services;

import mainpackage.entities.Categorie;
import mainpackage.entities.Produit;
import mainpackage.exceptions.NotFoundException;
import mainpackage.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class CategorieService {
    private final CategorieRepository rep;

    public CategorieService(@Autowired CategorieRepository rep) {
        this.rep = rep;
    }

    public Categorie add(Categorie c) {
        return rep.save(c);
    }

    public void delete(Long id) {
        this.rep.deleteById(id);
    }
    public List<Categorie> getAll(){
        return rep.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    public Categorie findCategorieById(Long id){
        return rep.findById(id).orElseThrow(() -> new NotFoundException("Categorie by Id " + id + " was not found"));
    }





}
