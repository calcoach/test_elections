package com.example.backendprueba.models;

public class County {
    private long id;
    private String codeCounty;
    private String county;
    private long population;
    private long area;

    public County() {
    }

    public County(String codeCounty, String county, long population, long area) {
        this.codeCounty = codeCounty;
        this.county = county;
        this.population = population;
        this.area = area;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodeCounty() {
        return codeCounty;
    }

    public void setCodeCounty(String codeCounty) {
        this.codeCounty = codeCounty;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }
}

