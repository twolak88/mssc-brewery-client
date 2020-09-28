package twolak.springframework.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import twolak.springframework.msscbreweryclient.web.model.BeerDto;

/**
 *
 * @author twolak
 */
@ConfigurationProperties(value = "tw.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {
    
    public static final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apihost;
    
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    
    public BeerDto getBeerById(UUID beerId) {
        return this.restTemplate.getForObject(this.apihost + BEER_PATH_V1 + beerId.toString(), BeerDto.class);
    }
    
    public URI saveNewBeer(BeerDto beerDto) {
        return this.restTemplate.postForLocation(this.apihost + BEER_PATH_V1, beerDto);
    }
    
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        this.restTemplate.put(this.apihost + BEER_PATH_V1 + beerId.toString(), beerDto);
    }
    
    public void deleteBeer(UUID beerId) {
        this.restTemplate.delete(this.apihost + BEER_PATH_V1 + beerId.toString());
    }
    
    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
