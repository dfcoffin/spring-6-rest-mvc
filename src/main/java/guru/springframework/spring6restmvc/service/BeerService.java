package guru.springframework.spring6restmvc.service;

import guru.springframework.spring6restmvc.model.Beer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Donald F. Coffin
 */
@Service
public interface BeerService {

	List<Beer> listBeers();

	Beer getBeerById(UUID id);
}
