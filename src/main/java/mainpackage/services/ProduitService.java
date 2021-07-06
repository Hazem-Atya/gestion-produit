package mainpackage.services;

import mainpackage.entities.Produit;
import mainpackage.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    private final ProduitRepository rep;

    public ProduitService(@Autowired ProduitRepository rep) {
        this.rep = rep;
    }
    public Produit add(Produit p){
        return rep.save(p);
    }
    public List<Produit> getAll(){
        return rep.findAll();
    }
    public void delete(Long id){
        this.rep.deleteById(id);
    }

}


