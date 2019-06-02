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

        measurements.add(new Measurement("01-06-2019", 21.6));
        measurements.add(new Measurement("01-06-2019", 22.6));
        measurements.add(new Measurement("01-06-2019", 23.6));
        measurements.add(new Measurement("01-06-2019", 2.6));
        measurements.add(new Measurement("01-06-2019", 2.6));
        measurements.add(new Measurement("01-06-2019", 3.6));
        measurements.add(new Measurement("01-06-2019", 1.6));
        measurements.add(new Measurement("01-06-2019", 2.6));
        measurements.add(new Measurement("01-06-2019", 23.6));
        measurements.add(new Measurement("01-06-2019", 21.6));

        measurements.add(new Measurement("02-06-2019", 22.6));
        measurements.add(new Measurement("02-06-2019", 23.6));
        measurements.add(new Measurement("02-06-2019", 21.6));
        measurements.add(new Measurement("02-06-2019", 22.6));
        measurements.add(new Measurement("02-06-2019", 23.6));
        measurements.add(new Measurement("02-06-2019", 21.6));
        measurements.add(new Measurement("02-06-2019", 22.6));
        measurements.add(new Measurement("02-06-2019", 23.6));


        this.measurementRepository.saveAll(measurements);
    }
}
