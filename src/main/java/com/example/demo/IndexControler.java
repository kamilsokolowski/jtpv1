package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class IndexControler {

    @Autowired
    private MeasurementRepository measurementRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("mes", measurementRepository.findAll());
        List<Measurement> lista =  measurementRepository.findAll();
        Measurement last = lista.get(lista.size()-1);
        Measurement second = lista.get(lista.size()-2);
        Measurement conditional = new Measurement(last.getDate(),last.getTemperature()-second.getTemperature(),last.getHumidity()-second.getHumidity(),last.getLight()-second.getLight());
        model.addAttribute("delta",last);
        model.addAttribute("conditional",conditional);
        model.addAttribute("datetime", new Date());
        return "index";
    }
}
