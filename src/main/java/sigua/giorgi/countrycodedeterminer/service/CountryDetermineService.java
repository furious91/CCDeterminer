package sigua.giorgi.countrycodedeterminer.service;

import sigua.giorgi.countrycodedeterminer.model.CountryResponse;

public interface CountryDetermineService {

    CountryResponse determineCountry(String phoneNumber);

}
