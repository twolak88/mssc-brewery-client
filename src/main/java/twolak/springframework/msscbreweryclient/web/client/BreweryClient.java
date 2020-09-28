package twolak.springframework.msscbreweryclient.web.client;

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
@Component
@ConfigurationProperties(value = "tw.brewery", ignoreUnknownFields = false)
public class BreweryClient {
    
    public static final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apiHost;
    
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    
    public BeerDto getBeerById(UUID beerId) {
        return this.restTemplate.getForObject(this.apiHost + BEER_PATH_V1 + beerId, BeerDto.class);
    }
    
    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
