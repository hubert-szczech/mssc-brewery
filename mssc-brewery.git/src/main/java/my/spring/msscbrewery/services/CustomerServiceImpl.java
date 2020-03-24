package my.spring.msscbrewery.services;

import lombok.extern.slf4j.Slf4j;
import my.spring.msscbrewery.services.CustomerService;
import my.spring.msscbrewery.web.model.BeerDto;
import my.spring.msscbrewery.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder().id(UUID.randomUUID()).name("John").build();
    }

    @Override
    public CustomerDto save(CustomerDto customer) {
        return CustomerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deeleting a customer...");
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customer) {
        //TO DO
    }
}
