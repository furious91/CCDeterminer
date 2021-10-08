package sigua.giorgi.countrycodedeterminer;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sigua.giorgi.countrycodedeterminer.service.CountryDetermineServiceImpl;
import sigua.giorgi.countrycodedeterminer.service.WikipediaParserService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
public class CountryDetermineServiceTest {

    private static final String PHONE_NUMBER = "995591122282";

    @InjectMocks
    CountryDetermineServiceImpl countryDetermineService;

    @Mock
    WikipediaParserService wikipediaParserService;

    @Before
    public void setup() {
        Map<String, String> pairs = new HashMap<>();
        pairs.put("995", "Georgia");
        when(wikipediaParserService.getDataFromWiki()).thenReturn(pairs);
    }

    @Test
    public void testDetermineServiceNotNullCheck() {
        assertNotNull(countryDetermineService.determineCountry(PHONE_NUMBER));
    }

    @Test
    public void testDetermineServiceResponse() {
        assertEquals(countryDetermineService.determineCountry(PHONE_NUMBER).getCountryName(), "Georgia");
    }



}
