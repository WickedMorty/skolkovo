package ru.untitled.skolkovo.servise;

import ru.untitled.skolkovo.entity.TemperatureSensor;

public interface TemperatureSensorService {
    TemperatureSensor findByName(String name);
    TemperatureSensor save(TemperatureSensor sensor);
}
