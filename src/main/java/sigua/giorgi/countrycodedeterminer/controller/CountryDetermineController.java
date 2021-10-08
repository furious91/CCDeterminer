package sigua.giorgi.countrycodedeterminer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sigua.giorgi.countrycodedeterminer.model.CountryResponse;
import sigua.giorgi.countrycodedeterminer.service.CountryDetermineService;

@RestController
@RequiredArgsConstructor
public class CountryDetermineController {

    private final CountryDetermineService countryDetermineService;

    @RequestMapping(value = "/find-country/{phone-number}")
    public CountryResponse getResponse(@PathVariable(value = "phone-number") String phoneNumber) {
        return countryDetermineService.determineCountry(phoneNumber);
    }

}
