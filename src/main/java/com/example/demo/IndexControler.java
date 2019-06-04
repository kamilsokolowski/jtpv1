package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class IndexControler {
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        return "index";
    }
}
