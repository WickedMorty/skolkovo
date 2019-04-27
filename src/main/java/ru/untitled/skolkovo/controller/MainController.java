package ru.untitled.skolkovo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.untitled.skolkovo.dto.ApiResponse;
import ru.untitled.skolkovo.dto.CommonDto;
import ru.untitled.skolkovo.dto.TemperatureBetweenDto;
import ru.untitled.skolkovo.dto.TemperatureMeasureDto;
import ru.untitled.skolkovo.servise.MainService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sensorApi")
public class MainController {
    @Autowired
    private MainService mainService;

    @PutMapping("/measure/temperature")
    public ApiResponse saveTemperatureMeasure(@RequestBody TemperatureMeasureDto request) {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(),
                    "Measure insert successfully.",
                    mainService.save(request));
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(),
                    e.getMessage(),
                    null);
        }
    }

    //выдать все измерения заданного датчика за заданный интервал времени;
    @PostMapping("/getByDate")
    public ApiResponse getByDate(@RequestBody TemperatureBetweenDto request) {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(),
                    "Measure select successfully.",
                    mainService.getAllMeasureBySensor(request));
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(),
                    e.getMessage(),
                    null);
        }

    }

    //выдать текущие значения всех датчиков для заданного объекта,
    @PostMapping("/getCurrentValueByPlace")
    public ApiResponse getCurrentValueByPlace(@RequestBody CommonDto request) {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(),
                    "Measure select successfully.",
                    mainService.getCurrentValueByPlace(request));
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(),
                    e.getMessage(),
                    null);
        }
    }

    //выдать среднее из текущих значений датчиков для каждого объекта.
    @PostMapping("/getMiddleValue")
    public ApiResponse getMiddleValue() {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(),
                    "Measure select successfully.",
                    mainService.getMiddleValue());
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(),
                    e.getMessage(),
                    null);
        }
    }

}



