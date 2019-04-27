package ru.untitled.skolkovo.dto;

import java.sql.Timestamp;

public class TemperatureBetweenDto {
    private String sensorName;
    private Timestamp dateFrom;
    private Timestamp dateTo;

    public TemperatureBetweenDto() {
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(Timestamp dateTo) {
        this.dateTo = dateTo;
    }
}
