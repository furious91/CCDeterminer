package sigua.giorgi.countrycodedeterminer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryCodePair {

    private String code;
    private String country;

}
