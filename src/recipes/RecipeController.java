package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService service;
//    public Map<Integer, Recipe> recipeMap = new ConcurrentHashMap<Integer, Recipe>();
//    public static Integer id = 0;

    @GetMapping("/api/recipe/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @PostMapping("/api/recipe/new")
    public ResponseEntity<Map<String,Long>> postRecipe(@RequestBody Recipe recipe) {
        Recipe savedRecipe = service.saveRecipe(recipe);
        return new ResponseEntity<Map<String,Long>>(Map.of("id", savedRecipe.getId()), HttpStatus.OK);
    }

    @DeleteMapping("api/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return service.deleteRecipe(id);
    }

//    public static synchronized void incrementRecipeId() {
//        id++;
//    }
}
