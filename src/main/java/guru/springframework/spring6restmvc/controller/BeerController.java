package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author Donald F. Coffin
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
	private final BeerService beerService;

	@PutMapping("{beerId}")
	public ResponseEntity updateById(@PathVariable("beerId")UUID beerId, @RequestBody Beer beer) {

		beerService.updateBeerById(beerId, beer);

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@GetMapping
	public List<Beer> listBeers() {
		return beerService.listBeers();
	}

	@PostMapping
	public ResponseEntity handlePost(@RequestBody Beer beer) {

		Beer savedBeer = beerService.saveNewBeer(beer);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@GetMapping("{beerId}")
	public Beer getBeerById(@PathVariable("beerId")UUID beerId) {

		log.debug("Get Beer by Id - in controller - 1234 asdf");

		return beerService.getBeerById(beerId);
	}
}
