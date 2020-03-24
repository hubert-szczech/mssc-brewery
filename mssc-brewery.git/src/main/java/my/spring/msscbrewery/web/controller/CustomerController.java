package my.spring.msscbrewery.web.controller;

import my.spring.msscbrewery.services.CustomerService;
import my.spring.msscbrewery.web.model.BeerDto;
import my.spring.msscbrewery.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    CustomerService customerService;
    @Autowired
    CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity saveBeer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customer){
        CustomerDto savedDto = customerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        //TODO ADD HOST NAME
        headers.add("Location", "/api/v1/customer" +  savedDto.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customer){
        customerService.updateCustomer(customerId, customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomer(customerId);
    }

}
