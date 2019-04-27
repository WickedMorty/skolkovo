package ru.untitled.skolkovo.servise.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.untitled.skolkovo.dto.CommonDto;
import ru.untitled.skolkovo.dto.HouseResponse;
import ru.untitled.skolkovo.dto.TemperatureBetweenDto;
import ru.untitled.skolkovo.dto.TemperatureMeasureDto;
import ru.untitled.skolkovo.entity.Measure;
import ru.untitled.skolkovo.entity.House;
import ru.untitled.skolkovo.entity.TemperatureSensor;
import ru.untitled.skolkovo.repository.MeasureRepository;
import ru.untitled.skolkovo.repository.HouseRepository;
import ru.untitled.skolkovo.servise.MainService;
import ru.untitled.skolkovo.servise.TemperatureSensorService;
import sun.management.Sensor;

import java.util.ArrayList;
import java.util.List;

@Service(value = "mainService")
public class MainServiceImpl implements MainService {
    @Autowired
    MeasureRepository measureRepository;

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    TemperatureSensorService temperatureSensorService;

    @Override
    public TemperatureSensor save(TemperatureMeasureDto measureDto) throws Exception {
        if(!measureDto.valid()) {
            throw new Exception("Input data not valid.");
        }

        House house = checkToSensors(measureDto.getPlaceName());

        TemperatureSensor sensor = house.getSensorByName(measureDto.getSensorName());

        if(sensor == null) {
            throw new Exception("Sensor not found.");
        }

        Measure measure = new Measure(measureDto.getDate(), measureDto.getValue());
        measure = measureRepository.save(measure);

        List<Measure> measures = sensor.getMeasures();
        measures.add(measure);

        sensor.setMeasures(measures);

        return temperatureSensorService.save(sensor);
    }

    @Override
    public List<Measure> getAllMeasureBySensor(TemperatureBetweenDto measureDto) throws Exception {
        TemperatureSensor sensor = temperatureSensorService.findByName(measureDto.getSensorName());
        if(sensor == null) {
            throw new Exception("Sensor not found.");
        }

        return measureRepository.findBySensorAndDate(sensor.getId(), measureDto.getDateFrom(), measureDto.getDateTo());
    }

    @Override
    public List<Measure> getCurrentValueByPlace(CommonDto request) throws Exception {

        House house = checkToSensors(request.getName());

        return getCurrentValueByHouse(house);
    }

    private List<Measure> getCurrentValueByHouse(House house) {
        List<Measure> measures = new ArrayList<>();
        for(TemperatureSensor sensor: house.getSensors()) {
            Measure measure = measureRepository.findLastValue(sensor.getId());

            if(measure != null) {
                measures.add(measure);
            }
        }

        return measures;
    }

    private float getMiddleValueByHouse(House house) {
        float sum = 0;

        for(Measure measure: getCurrentValueByHouse(house)) {
            sum += measure.getValue();
        }

        return sum/getCurrentValueByHouse(house).size();
    }

    @Override
    public List<HouseResponse> getMiddleValue() {
        List<HouseResponse> responses = new ArrayList<>();

        for(House house: houseRepository.findAll()) {
            HouseResponse response = new HouseResponse(house);
            response.setMiddleValue(getMiddleValueByHouse(house));
            responses.add(response);
        }

        return responses;
    }

    private House checkToSensors(String placeName) throws Exception {
        House house = houseRepository.findByName(placeName);
        if (house == null) {
            throw new Exception("Place not found");
        }

        if(house.getSensors().isEmpty()) {
            throw new Exception("Sensors list is empty");
        }

        return house;
    }
}
