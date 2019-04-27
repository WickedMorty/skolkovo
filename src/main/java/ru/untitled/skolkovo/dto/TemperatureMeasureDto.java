package ru.untitled.skolkovo.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

public class TemperatureMeasureDto {
    private String placeName;
    private String sensorName;
    private Timestamp date;
    private float value;

    public TemperatureMeasureDto() {
    }

    public boolean valid() {

        if(placeName.isEmpty() || sensorName.isEmpty()) {
            return false;
        }
        return (!(value > 100)) && (!(value < -60));
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
