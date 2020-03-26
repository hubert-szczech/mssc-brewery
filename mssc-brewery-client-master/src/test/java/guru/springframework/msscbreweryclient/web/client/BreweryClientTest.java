package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;


    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }
    @Test
    void saveNewBeer() {
        BeerDto dto = BeerDto.builder().beerName(" new beer").build();
        URI uri = client.saveNewBeer(dto);
        assertNotNull(uri);
    }

    @Test
    void updateBeer() {
        BeerDto dto = BeerDto.builder().beerName(" new beer").build();
        client.updateBeer(UUID.randomUUID(),dto);
    }
    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }
    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }

    @Test
    void putCustomer() {
        client.updateCustomer(UUID.randomUUID(), CustomerDto.builder().name("John").build());
    }

    @Test
    void getCustomer() {
        assertNotNull(client.getCustomer(UUID.randomUUID()));
    }

    @Test
    void saveCustomer() {
        assertNotNull(client.saveCustomer(CustomerDto.builder().name("John").id(UUID.randomUUID()).build()));
    }

}