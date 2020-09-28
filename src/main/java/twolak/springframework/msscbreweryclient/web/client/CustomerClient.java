package twolak.springframework.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;
import twolak.springframework.msscbreweryclient.web.model.CustomerDto;

/**
 *
 * @author twolak
 */
public interface CustomerClient {
    CustomerDto getCustomerById(UUID customerId);
    URI saveNewCustomer(CustomerDto customerDto);
    void updateCustomer(UUID customerId, CustomerDto customerDto);
    void deleteCustomer(UUID customerId);
}
