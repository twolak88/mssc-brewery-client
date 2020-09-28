package twolak.springframework.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import twolak.springframework.msscbreweryclient.web.model.CustomerDto;

/**
 *
 * @author twolak
 */
@SpringBootTest
public class CustomerClientIT {

    @Autowired
    private CustomerClient customerClient;
    
    @Test
    public void testGetCustomerById() {
        CustomerDto customerDto = this.customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    public void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Customer").build();
        URI uri = this.customerClient.saveNewCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    public void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Customer").build();
        this.customerClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    public void testDeleteCustomer() {
        this.customerClient.deleteCustomer(UUID.randomUUID());
    }
    
}
