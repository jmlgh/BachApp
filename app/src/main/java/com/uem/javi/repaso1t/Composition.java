package com.uem.javi.repaso1t;

public class Composition {
    private String name, BMVRange;
    private String year;

    public Composition(String name, String range, String year){
        this.name = name;
        this.BMVRange = range;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBMVRange() {
        return BMVRange;
    }

    public void setBMVRange(String BMVRange) {
        this.BMVRange = BMVRange;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
