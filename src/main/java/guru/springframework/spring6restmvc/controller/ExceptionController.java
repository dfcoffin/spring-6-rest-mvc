package guru.springframework.spring6restmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Donald F. Coffin
 */
@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity handleNotFoundException() {
		return ResponseEntity.notFound().build();
	}
}
