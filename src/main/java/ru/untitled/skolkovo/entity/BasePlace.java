package ru.untitled.skolkovo.entity;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BasePlace implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    public BasePlace() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
