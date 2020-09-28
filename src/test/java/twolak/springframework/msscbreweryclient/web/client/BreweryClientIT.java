package twolak.springframework.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import twolak.springframework.msscbreweryclient.web.model.BeerDto;

/**
 *
 * @author twolak
 */
@SpringBootTest
public class BreweryClientIT {
    
    @Autowired
    private BreweryClient breweryClient;
    
    @Test
    public void testGetBeerById() {
        BeerDto beerDto = this.breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    public void testSaveNewBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        URI uri = this.breweryClient.saveNewBeer(beerDto);
        assertNotNull(uri);
    }

    @Test
    public void testUpdateBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        this.breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    public void testDeleteBeer() {
        this.breweryClient.deleteBeer(UUID.randomUUID());
    }
}
