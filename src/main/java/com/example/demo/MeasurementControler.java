package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/apiv1")
public class MeasurementControler {
    MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementControler(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<Measurement> getAll(){
        return measurementRepository.findAll();
    }

    @RequestMapping(value = "/get-in-range/{start}/{end}", method = RequestMethod.GET)
    public List<Measurement> getTopTen(@PathVariable Long start, @PathVariable Long end){
        return measurementRepository.findByIdBetween(start, end);
    }

    @RequestMapping(value = "/add/{date}/{value}", method = RequestMethod.POST)
    public List<Measurement> addMeasurement(@PathVariable String date, @PathVariable double value){
        measurementRepository.save(new Measurement(date, value));

        return measurementRepository.findAll();
    }
}
