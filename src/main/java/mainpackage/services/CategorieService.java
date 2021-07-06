package mainpackage.services;

import mainpackage.repositories.CategorieRepository;
import mainpackage.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategorieService {
    private final CategorieRepository rep;

    public CategorieService(@Autowired CategorieRepository rep) {
        this.rep = rep;
    }
}
