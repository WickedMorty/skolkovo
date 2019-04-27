package ru.untitled.skolkovo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.untitled.skolkovo.entity.Measure;
import ru.untitled.skolkovo.entity.TemperatureSensor;

import java.util.List;

@Repository
public interface TemperatureSensorRepository extends JpaRepository<TemperatureSensor, Integer> {
    @Query("select s from TemperatureSensor s where s.name = :name")
    TemperatureSensor findByName(@Param("name") String name);
}
