package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/")
public class WelcomeController {

    @GetMapping(value = "/")
    public String welcome(){
        return "redirect:/contacts/";
    }

}
