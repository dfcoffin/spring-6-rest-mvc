package guru.springframework.spring6restmvc.mappers;

import guru.springframework.spring6restmvc.entities.Beer;
import guru.springframework.spring6restmvc.model.BeerDTO;
import org.mapstruct.Mapper;

/**
 * @author Donald F. Coffin
 */

@Mapper
public interface BeerMapper {

	Beer beerDtoToBeer(BeerDTO dto);

	BeerDTO beerToBeerDto (Beer beer);
}
