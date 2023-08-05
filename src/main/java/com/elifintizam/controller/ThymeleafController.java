package com.elifintizam.controller;

import com.elifintizam.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    // ResponseBody
    // http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    //@ResponseBody
    public String getThymeleaf1() {
        return "thymeleaf1";
    }

    // Model
    // http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")
    public String getThymeleaf2Model(Model model) {
        model.addAttribute("key_model1", "I came from Model1");
        model.addAttribute("key_model2", "I came from Model2");
        return "thymeleaf1";
    }

    // Multiple Model
    // http://localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3")
    public String getThymeleaf3Model(Model model) {
        model.addAttribute("key_model1", "I came from Model1");
        model.addAttribute("key_model2", "I came from Model2");
        return "thymeleaf_file/thymeleaf3";
    }

    // http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    public String getThymeleaf4Model(Model model) {
        model.addAttribute("key_model1", "I came from Model 4");
        return "thymeleaf4";
    }


    // Send Model Object
    // http://localhost:8080/thymeleaf5
    @GetMapping("/thymeleaf5")
    public String getThymeleaf5ModelObject(Model model) {
        model.addAttribute("key_model1", "I came from Model 5");

        ProductDto productDto = ProductDto.
                builder()
                .productId(1L)
                .productName("Phone")
                .productPrice(2500)
                .build();

        model.addAttribute("key_model2", productDto);

        return "thymeleaf5";
    }

    // Send Model Object List
    // http://localhost:8080/thymeleaf6
    @GetMapping("/thymeleaf6")
    public String getThymeleaf6ModelObjectList(Model model) {
        model.addAttribute("key_model1", "I came from Model 6");
        List<ProductDto> myList = new ArrayList<>();
        myList.add(ProductDto.builder().productId(1L).productName("Phone").productPrice(2500).build());
        myList.add(ProductDto.builder().productId(2L).productName("Cell Phone").productPrice(3500).build());
        myList.add(ProductDto.builder().productId(3L).productName("Home Phone").productPrice(200).build());

        model.addAttribute("product_list", myList);

        return "thymeleaf6";
    }
}
