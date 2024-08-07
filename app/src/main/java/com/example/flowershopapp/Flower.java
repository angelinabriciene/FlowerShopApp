package com.example.flowershopapp;

public class Flower {
    private long id;
    private String name;
    private String plant;

    public Flower(long id, String name, String plant) {
        this.id = id;
        this.name = name;
        this.plant = plant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }
}
