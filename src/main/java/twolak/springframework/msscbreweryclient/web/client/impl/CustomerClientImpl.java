package twolak.springframework.msscbreweryclient.web.client.impl;

import java.net.URI;
import java.util.UUID;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import twolak.springframework.msscbreweryclient.web.client.CustomerClient;
import twolak.springframework.msscbreweryclient.web.model.CustomerDto;

/**
 *
 * @author twolak
 */
@Component
public class CustomerClientImpl extends AbstractClient implements CustomerClient {

    public static final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    
    public CustomerClientImpl(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return this.restTemplate.getForObject(this.apihost + CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
    }

    @Override
    public URI saveNewCustomer(CustomerDto customerDto) {
        return this.restTemplate.postForLocation(this.apihost + CUSTOMER_PATH_V1, customerDto);
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        this.restTemplate.put(this.apihost + CUSTOMER_PATH_V1 + customerId.toString(), customerDto);
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        this.restTemplate.delete(this.apihost + CUSTOMER_PATH_V1 + customerId.toString());
    }
    
}
