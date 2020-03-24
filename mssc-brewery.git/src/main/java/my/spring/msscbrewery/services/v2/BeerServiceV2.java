package my.spring.msscbrewery.services.v2;

import my.spring.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {

    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 save(BeerDtoV2 beer);

    void updateBeer(UUID beerId, BeerDtoV2 beer);

    void deleteBeer(UUID beerId);
}
