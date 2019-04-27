package ru.untitled.skolkovo.dto;

import ru.untitled.skolkovo.entity.House;

public class HouseResponse extends House {
    private Float MiddleValue;

    public HouseResponse() {
    }

    public HouseResponse(House house) {
        this.setId(house.getId());
        this.setName(house.getName());
    }

    public Float getMiddleValue() {
        return MiddleValue;
    }

    public void setMiddleValue(Float middleValue) {
        MiddleValue = middleValue;
    }
}
