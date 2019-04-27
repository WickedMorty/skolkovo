package ru.untitled.skolkovo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tSensor")
@AttributeOverride( name="name", column = @Column(name="ts_model") )
public class TemperatureSensor extends BaseSensor{

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="sensor_id")
    private List<Measure> measures = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    private House house;

    public TemperatureSensor() {
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
