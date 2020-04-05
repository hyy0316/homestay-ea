package com.bsuc.homestay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author： yyhuang
 * Date：2020/4/5 0005
 */
@Controller
@RequestMapping(value = "/hello")
public class HomeController {

    @RequestMapping(value = "/index")
    public String hello(Model model){
        model.addAttribute("name","hyy");
        return "hello";
    }
}
