package sigua.giorgi.countrycodedeterminer;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sigua.giorgi.countrycodedeterminer.controller.CountryDetermineController;
import sigua.giorgi.countrycodedeterminer.service.CountryDetermineService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
public class CountryDetermineControllerTest {

    private static final String ENDPOINT = "http://localhost:8080/find-country/";
    private static final String PHONE_NUMBER = "995591122282";

    private MockMvc mvc;

    @InjectMocks
    private CountryDetermineController countryDetermineController;

    @Mock
    CountryDetermineService countryDetermineService;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(countryDetermineController).build();
    }

    @Test
    public void testEndpopint() throws Exception {
        mvc.perform(get(ENDPOINT + PHONE_NUMBER)).andExpect(status().isOk());
    }



}
