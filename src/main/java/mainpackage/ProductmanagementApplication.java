package mainpackage;

import mainpackage.entities.Categorie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductmanagementApplication.class, args);
        Categorie p = new Categorie();
        System.out.println(p.getDateCreation());
    }

}
