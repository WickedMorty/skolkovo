package ru.untitled.skolkovo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.untitled.skolkovo.entity.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

    @Query("select h from House h where h.name = :name")
    House findByName(@Param("name") String name);
}
