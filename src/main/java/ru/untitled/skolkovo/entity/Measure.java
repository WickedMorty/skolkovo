package ru.untitled.skolkovo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Measure {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp saveDate;
    private float value;

    @JsonIgnore
    @ManyToOne
    private TemperatureSensor sensor;

    public Measure() {
    }

    public Measure(Timestamp saveDate, float value) {
        this.saveDate = saveDate;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(Timestamp saveDate) {
        this.saveDate = saveDate;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public TemperatureSensor getSensor() {
        return sensor;
    }

    public void setSensor(TemperatureSensor sensor) {
        this.sensor = sensor;
    }
}
