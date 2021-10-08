package sigua.giorgi.countrycodedeterminer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sigua.giorgi.countrycodedeterminer.model.CountryResponse;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CountryDetermineServiceImpl implements CountryDetermineService {

    private final WikipediaParserService wikipediaParserService;

    @Override
    public CountryResponse determineCountry(String phoneNumber) {
        Map<String, String> pairs = wikipediaParserService.getDataFromWiki();
        CountryResponse countryResponse = null;

        for (int i=7; i>0; i--) {
            countryResponse = iterate(phoneNumber.substring(0, i), pairs);
            if (countryResponse != null) {
                break;
            }
        }

        return Objects.requireNonNullElseGet(countryResponse, () -> new CountryResponse(-1, "Country not found"));

    }


    private CountryResponse iterate(String phonePrefix, Map<String, String> pairs) {

        CountryResponse countryResponse = null;

        for (Map.Entry<String, String> entry : pairs.entrySet()) {
            if (entry.getKey().equals(phonePrefix)) {
                countryResponse = new CountryResponse(0, entry.getValue());
                break;
            }
        }

        return countryResponse;

    }

}
