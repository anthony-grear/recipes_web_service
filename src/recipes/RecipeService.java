package recipes;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository repository;

    public Recipe saveRecipe(Recipe recipe) {
        return repository.save(recipe);
    }

    public Recipe getProductById(long id) {
        return repository.findById(id).orElse(null);
    }

    public ResponseEntity<?> deleteRecipe(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

//        return "product removed !! " + id;
    }

//    public Iterable<Recipe> saveProducts(List<Recipe> recipes) {
//        return repository.saveAll(recipes);
//    }

//    public List<Product> getProducts() {
//        return repository.findAll();
//    }

//    public Product getProductByName(String name) {
//        return repository.findByName(name);
//    }



}
