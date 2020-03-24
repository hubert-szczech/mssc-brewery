package my.spring.msscbrewery.services;

import my.spring.msscbrewery.web.model.BeerDto;
import my.spring.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface CustomerService {

    CustomerDto getCustomerById(UUID id);

    CustomerDto save(CustomerDto customer);

    void deleteCustomer(UUID customerId);

    void updateCustomer(UUID customerId, CustomerDto customer);
}
