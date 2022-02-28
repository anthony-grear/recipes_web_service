package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
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
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id) {
        return service.deleteRecipe(id);
    }

    @PutMapping("/api/recipe/{id}")
    public ResponseEntity<?> putRecipe(@Valid @PathVariable Long id,@Valid @RequestBody Recipe recipe) {
        return service.updateRecipe(id, recipe);
    }

    @GetMapping(value = "/api/recipe/search/", params = "category")
    public List<Recipe> getRecipeByCategory(@RequestParam (name = "category") String category) {
        return service.getByCategory(category);
    }

    @GetMapping(value = "/api/recipe/search/", params = "name")
    public List<Recipe> getRecipeByName(@RequestParam (name = "name") String name) {
        return service.getByName(name);
    }
}
