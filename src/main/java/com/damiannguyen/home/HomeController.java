package com.damiannguyen.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
//    @Autowired
    private final HomeService homeService;

    public HomeController(HomeService homeService){
        this.homeService = homeService;
    }

    @RequestMapping("/")
    public String getHome(Model model){
        model.addAttribute("greetings", homeService.getGreetings());
        return "home";
    }

}
