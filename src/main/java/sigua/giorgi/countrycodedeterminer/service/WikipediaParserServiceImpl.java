package sigua.giorgi.countrycodedeterminer.service;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sigua.giorgi.countrycodedeterminer.model.CountryCodePair;
import sigua.giorgi.countrycodedeterminer.model.wiki.WikiRoot;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WikipediaParserServiceImpl implements WikipediaParserService {

    private static final String WIKI_ENDPOINT = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&explaintext&redirects=1&titles=List of country calling codes";

    private final RestTemplate restTemplate;


    @Override
    public Map<String, String> getDataFromWiki() {

        String response = restTemplate.getForObject(WIKI_ENDPOINT, String.class);
        WikiRoot wikiRoot = new Gson().fromJson(response, WikiRoot.class);
        String[] lines = wikiRoot.getQuery().getPages().getRequiredData().getExtract().split("\\n");
        Map<String, String > pairs = new HashMap<>();

        for (int i=0; i<lines.length; i++) {
            if (lines[i].startsWith("+") && lines[i].contains("–")) {
                CountryCodePair pair = processLine(lines[i].substring(1, lines[i].indexOf("–")), lines[i].substring(lines[i].indexOf("–") + 3));
                pairs.put(pair.getCode(), pair.getCountry());
            }
        }

        return pairs;
    }

    private CountryCodePair processLine(String code, String country) {
        code = code.replace(" ", "");
        return new CountryCodePair(code, country);
    }

}
