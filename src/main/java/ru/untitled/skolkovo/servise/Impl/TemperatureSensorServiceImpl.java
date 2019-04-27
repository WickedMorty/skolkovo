package ru.untitled.skolkovo.servise.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.untitled.skolkovo.entity.TemperatureSensor;
import ru.untitled.skolkovo.repository.TemperatureSensorRepository;
import ru.untitled.skolkovo.servise.TemperatureSensorService;

@Service(value = "temperatureSensorService")
public class TemperatureSensorServiceImpl implements TemperatureSensorService {

    @Autowired
    TemperatureSensorRepository repository;

    @Override
    public TemperatureSensor findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public TemperatureSensor save(TemperatureSensor sensor) {
        return repository.save(sensor);
    }
}
