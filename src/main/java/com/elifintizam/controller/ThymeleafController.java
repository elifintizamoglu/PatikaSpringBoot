package com.elifintizam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    // http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    //@ResponseBody
    public String getThymeleaf1(){
        return "thymeleaf1";
    }

    // http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")
    //@ResponseBody
    public String getThymeleaf2Model(Model model){
        model.addAttribute("key_model1","I came from Model1");
        model.addAttribute("key_model2","I came from Model2");
        return "thymeleaf1";
    }

    // http://localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3")
    //@ResponseBody
    public String getThymeleaf3Model(Model model){
        model.addAttribute("key_model1","I came from Model1");
        model.addAttribute("key_model2","I came from Model2");
        return "thymeleaf_file/thymeleaf3";
    }
}
