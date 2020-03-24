package my.spring.msscbrewery.web.controller.v2;

import my.spring.msscbrewery.services.BeerService;
import my.spring.msscbrewery.services.v2.BeerServiceV2;
import my.spring.msscbrewery.web.model.BeerDto;
import my.spring.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {
    BeerServiceV2 beerService;

        @Autowired
        public BeerControllerV2(BeerServiceV2 beerService){
            this.beerService = beerService;
        }


        @GetMapping({"/{beerId}"})
        public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){
            return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
        }


        @PostMapping
        public ResponseEntity saveBeer(@RequestBody BeerDtoV2 beer){
            BeerDtoV2 savedDto = beerService.save(beer);
            HttpHeaders headers = new HttpHeaders();
            //TODO ADD HOST NAME
            headers.add("Location", "/api/v2/beer" +  savedDto.getId().toString());
            return new ResponseEntity(headers,HttpStatus.CREATED);
        }

        @PutMapping("/{beerId}")
        public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beer){
            beerService.updateBeer(beerId,beer);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("/{beerId}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteBeer(@PathVariable("beerId")  UUID beerId){
            beerService.deleteBeer(beerId);
        }

    }

