package my.spring.msscbrewery.services.impl;

import lombok.extern.slf4j.Slf4j;
import my.spring.msscbrewery.services.BeerService;
import my.spring.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").beerStyle("Pale ale").build();
    }

    @Override
    public BeerDto save(BeerDto beer) {
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beer) {
        //TO DO
    }

    @Override
    public void deleteBeer(UUID beerId) {
    log.debug("Deeleting a beer...");
    }
}
