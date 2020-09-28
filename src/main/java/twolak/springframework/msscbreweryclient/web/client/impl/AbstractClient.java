package twolak.springframework.msscbreweryclient.web.client.impl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author twolak
 */
@ConfigurationProperties(value = "tw.brewery", ignoreUnknownFields = false)
public class AbstractClient {
    protected String apihost;
    
    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
    
    protected final RestTemplate restTemplate;

    public AbstractClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
}
