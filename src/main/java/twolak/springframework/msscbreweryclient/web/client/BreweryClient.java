package twolak.springframework.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;
import twolak.springframework.msscbreweryclient.web.model.BeerDto;

/**
 *
 * @author twolak
 */
public interface BreweryClient {
    BeerDto getBeerById(UUID beerId);
    URI saveNewBeer(BeerDto beerDto);
    void updateBeer(UUID beerId, BeerDto beerDto);
    void deleteBeer(UUID beerId);
}
