package app.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping
    public String mainPage() {
        return "index";
    }
}
