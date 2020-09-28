package twolak.springframework.msscbreweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author twolak
 */
@Component
@ConfigurationProperties(value = "tw.brewery", ignoreUnknownFields = false)
public class BreweryClient {
    
    public static final String BEER_PATH_V1 = "/api/v1/beer";
    private String apiHost;
    
    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
