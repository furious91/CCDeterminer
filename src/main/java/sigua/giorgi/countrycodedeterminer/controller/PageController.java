package sigua.giorgi.countrycodedeterminer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping(value = "/")
    public String redirect() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index.html";
    }

}
