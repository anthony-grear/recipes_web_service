package recipes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class RecipeExceptionController {

    @ExceptionHandler(value = IdDoesNotExistException.class)
    public ResponseEntity<Object> exception(IdDoesNotExistException exception) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
