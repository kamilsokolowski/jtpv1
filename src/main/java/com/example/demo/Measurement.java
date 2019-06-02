package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String date;
    private double temperature;

    public Measurement() {}

    public Measurement(String date, double temperature) {
        this.date = date;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
