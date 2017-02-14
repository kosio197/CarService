package bg.garage.controler;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectIndexControler {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test(Locale locale, Model model) {

        return "redirect:/page/login.xhtml";
    }

    @RequestMapping(value = "/page/login", method = RequestMethod.GET)
    public String userLogin(Locale locale, Model model) {

        return "redirect:/page/login.xhtml";
    }

    @RequestMapping(value = "/page/index", method = RequestMethod.GET)
    public String userAutorized(Locale locale, Model model) {

        return "redirect:/page/index.xhtml";
    }
}
