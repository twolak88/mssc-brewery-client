package twolak.springframework.msscbreweryclient.web.client.impl;

import java.net.URI;
import java.util.UUID;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import twolak.springframework.msscbreweryclient.web.client.BreweryClient;
import twolak.springframework.msscbreweryclient.web.model.BeerDto;

/**
 *
 * @author twolak
 */
@Component
public class BreweryClientImpl extends AbstractClient implements BreweryClient {
    
    public static final String BEER_PATH_V1 = "/api/v1/beer/";

    public BreweryClientImpl(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
    }
    
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return this.restTemplate.getForObject(this.apihost + BEER_PATH_V1 + beerId.toString(), BeerDto.class);
    }
    
    @Override
    public URI saveNewBeer(BeerDto beerDto) {
        return this.restTemplate.postForLocation(this.apihost + BEER_PATH_V1, beerDto);
    }
    
    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        this.restTemplate.put(this.apihost + BEER_PATH_V1 + beerId.toString(), beerDto);
    }
    
    @Override
    public void deleteBeer(UUID beerId) {
        this.restTemplate.delete(this.apihost + BEER_PATH_V1 + beerId.toString());
    }
}
