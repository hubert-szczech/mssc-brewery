package my.spring.msscbrewery.services;

import my.spring.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto save(BeerDto beer);

    void updateBeer(UUID beerId, BeerDto beer);

    void deleteBeer(UUID beerId);
}
