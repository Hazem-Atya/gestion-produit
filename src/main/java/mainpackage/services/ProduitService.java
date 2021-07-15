package mainpackage.services;

import mainpackage.entities.Produit;
import mainpackage.exceptions.NotFoundException;
import mainpackage.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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
        return rep.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    public List<Object> getAll1(){
        /*        return rep.findAll();*/
        return rep.getProduitsWihCategorieName();
    }
    public void delete(Long id){
        this.rep.deleteById(id);
    }
    public List<Produit> findByCategorieId(Long id)
    {
        return rep.findByCategorieId(id);
    }
    public void deleteByCategorieId(Long id){
        rep.removeByCategorieId(id);
    }
    public Produit getProduitById(Long id){
        return rep.findById(id).orElseThrow(() -> new NotFoundException("Product by Id " + id + " was not found"));
    }
}


