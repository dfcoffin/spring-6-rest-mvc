package guru.springframework.spring6restmvc.service;

import guru.springframework.spring6restmvc.model.Beer;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Donald F. Coffin
 */
@Service
public interface BeerService {

	Beer getBeerById(UUID id);
}
