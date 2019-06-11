package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private MeasurementRepository measurementRepository;

    @Autowired
    public DatabaseSeeder(MeasurementRepository measurementRepository){
        this.measurementRepository = measurementRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Measurement> measurements = new ArrayList<>();

        measurements.add(new Measurement("01-06-2019", 21, 21, 21));
        measurements.add(new Measurement("01-06-2019", 22, 21, 21));
        measurements.add(new Measurement("01-06-2019", 23, 23, 23));
        measurements.add(new Measurement("01-06-2019", 2, 2, 2));
        measurements.add(new Measurement("01-06-2019", 2, 2, 2 ));
        measurements.add(new Measurement("01-06-2019", 3, 3, 3));
        measurements.add(new Measurement("01-06-2019", 1, 1, 1));
        measurements.add(new Measurement("01-06-2019", 2, 2, 2));
        measurements.add(new Measurement("01-06-2019", 23, 23, 23));
        measurements.add(new Measurement("01-06-2019", 21, 21, 23));

        measurements.add(new Measurement("02-06-2019", 22, 22, 22));
        measurements.add(new Measurement("02-06-2019", 23, 23, 23));
        measurements.add(new Measurement("02-06-2019", 21 , 21, 23));
        measurements.add(new Measurement("02-06-2019", 22, 22, 23));
        measurements.add(new Measurement("02-06-2019", 23, 23, 23));
        measurements.add(new Measurement("02-06-2019", 21, 21, 21));
        measurements.add(new Measurement("02-06-2019", 22, 22, 23));
        measurements.add(new Measurement("02-06-2019", 23, 21, 24));


        measurementRepository.saveAll(measurements);
    }
}
