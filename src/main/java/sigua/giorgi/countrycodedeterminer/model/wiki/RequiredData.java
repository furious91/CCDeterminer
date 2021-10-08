package sigua.giorgi.countrycodedeterminer.model.wiki;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequiredData {

    private int pageid;
    private int ns;
    private String title;
    private String extract;

}
