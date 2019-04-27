package ru.untitled.skolkovo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.untitled.skolkovo.entity.Measure;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Integer> {

    @Query("select m from Measure m where m.sensor.id = :sensorId and m.saveDate between :dateFrom and :dateTo")
    List<Measure> findBySensorAndDate(@Param("sensorId") Integer sensorId,
                                      @Param("dateFrom") Timestamp dateFrom,
                                      @Param("dateTo") Timestamp dateTo);

    @Query(value = "select * from Measure where sensor_id = :sensorId order by saveDate desc limit 1", nativeQuery = true)
    Measure findLastValue(@Param("sensorId") Integer sensorId);
}
