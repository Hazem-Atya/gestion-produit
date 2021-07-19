package mainpackage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mainpackage.entities.Produit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProductmanagementApplication.class)
public class ProduitControllerTest {
    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    public void testProduitController() throws Exception{
        Produit p= new Produit();
        p.setNom("Mon produit");
        p.setDisponible(true);
        p.setQt(5);
        mvc.perform(post("/produit/add/15").contentType(MediaType.APPLICATION_JSON)
                .content(toJson(p))).andExpect(status().isCreated());

        mvc.perform(get("/produit/66")).andExpect(status().isOk()).
                andExpect(jsonPath("$.id").exists());
       // mvc.perform(delete("/produit/delete/68")).andExpect(status().isOk());


    }
    private String toJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
