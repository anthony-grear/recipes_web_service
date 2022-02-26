package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;


@RestController
public class RecipeController {

    @Autowired
    private RecipeService service;


    @GetMapping("/api/recipe/{id}")
    public ResponseEntity<Optional<Recipe>> getRecipeById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @PostMapping("/api/recipe/new")
    public ResponseEntity<Map<String,Long>> postRecipe(@Valid @RequestBody Recipe recipe) {
        Recipe savedRecipe = service.saveRecipe(recipe);
        return new ResponseEntity<Map<String,Long>>(Map.of("id", savedRecipe.getId()), HttpStatus.OK);
    }

    @DeleteMapping("api/recipe/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return service.deleteRecipe(id);
    }


}
