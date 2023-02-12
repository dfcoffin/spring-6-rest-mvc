package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Donald F. Coffin
 */

@DataJpaTest
class BeerRepositoryTest {

	@Autowired
	BeerRepository beerRepository;

	@Test
	void testSaveBeer() throws Exception{
		Beer savedBeer = beerRepository.save(Beer.builder()
				.beerName("My Beer")
				.build());

		assertThat(savedBeer).isNotNull();
		assertThat(savedBeer.getId()).isNotNull();
	}
}