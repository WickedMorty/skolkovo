package ru.untitled.skolkovo.servise;

import ru.untitled.skolkovo.dto.CommonDto;
import ru.untitled.skolkovo.dto.HouseResponse;
import ru.untitled.skolkovo.dto.TemperatureBetweenDto;
import ru.untitled.skolkovo.dto.TemperatureMeasureDto;
import ru.untitled.skolkovo.entity.Measure;
import ru.untitled.skolkovo.entity.TemperatureSensor;

import java.util.List;

public interface MainService {
    TemperatureSensor save(TemperatureMeasureDto measureDto) throws Exception;
    List<Measure> getAllMeasureBySensor(TemperatureBetweenDto measureDto) throws Exception;

    List<Measure> getCurrentValueByPlace(CommonDto request) throws Exception;

    List<HouseResponse> getMiddleValue();
}
