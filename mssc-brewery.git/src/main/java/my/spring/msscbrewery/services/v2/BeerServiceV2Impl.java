package my.spring.msscbrewery.services.v2;

import lombok.extern.slf4j.Slf4j;
import my.spring.msscbrewery.web.model.v2.BeerDtoV2;
import my.spring.msscbrewery.web.model.v2.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").beerStyle(BeerStyleEnum.GOSE).build();
    }

    @Override
    public BeerDtoV2 save(BeerDtoV2 beer) {
        return BeerDtoV2.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beer) {

    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deeleting a beer...");
    }
}
