package ru.untitled.skolkovo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "house")
public class House extends BasePlace {

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="house_id")
    private List<TemperatureSensor> sensors = new ArrayList<>();

    public House() {
    }

    public TemperatureSensor getSensorByName(String name) {
        for(TemperatureSensor sensor: sensors) {
            if(sensor.getName().equals(name)) {
                return sensor;
            }
        }

        return null;
    }

    public List<TemperatureSensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<TemperatureSensor> sensors) {
        this.sensors = sensors;
    }
}
