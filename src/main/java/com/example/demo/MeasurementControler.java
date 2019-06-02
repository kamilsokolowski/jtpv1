package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/apiv1")
public class MeasurementControler {
    /*
    * Api controler class.
    * Mapped to '/apiv1' endpoint.
    * Example localhost:8080/apiv1.
    */
    private MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementControler(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String apiIndex(){
        /*
        * Api main site endpoint.
        * */
        return "<h1>This is an API</h1>";
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<Measurement> getAll(){
        /*
        * This endpoint returns all measurements stored in database.(GET request)
        * Example: localhost:8080/get-all
        * */
        return measurementRepository.findAll();
    }

    @RequestMapping(value = "/get-in-range/{start}/{end}", method = RequestMethod.GET)
    public List<Measurement> getInRange(@PathVariable Long start, @PathVariable Long end){
        /*
        * This endpoint returns measurements with given Id range.(GET request)
        * Example: localhost:8080/get-in-range/1/3
        * */
        return measurementRepository.findByIdBetween(start, end);
    }

    @RequestMapping(value = "/add/{date}/{value}", method = RequestMethod.POST)
    public List<Measurement> addMeasurement(@PathVariable String date, @PathVariable double value){
        /*
        * This endpoint adds measurement to database.(POST request)
        * Example: localhost:8080/add/01-01-1970/15.05
        * */
        measurementRepository.save(new Measurement(date, value));

        return measurementRepository.findAll();
    }
}
