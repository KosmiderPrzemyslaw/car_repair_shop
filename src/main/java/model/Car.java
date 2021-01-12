package model;

import java.time.Year;
import java.util.Date;

public class Car {
    private int id;
    private String model;
    private String mark;
    private Year yearOfProduction;
    private String registrationNumber;
    private Date nextInspection;

    public Car() {
    }

    public Car(String model, String mark, Year yearOfProduction, String registrationNumber, Date nextInspection) {
        this.model = model;
        this.mark = mark;
        this.yearOfProduction = yearOfProduction;
        this.registrationNumber = registrationNumber;
        this.nextInspection = nextInspection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Year getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Year yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getNextInspection() {
        return nextInspection;
    }

    public void setNextInspection(Date nextInspection) {
        this.nextInspection = nextInspection;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", mark='" + mark + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", nextInspection=" + nextInspection +
                '}';
    }
}
