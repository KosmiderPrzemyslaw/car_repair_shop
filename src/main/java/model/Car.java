package model;

import java.time.LocalDate;
import java.util.Date;

public class Car {
    private int id;
    private String model;
    private String mark;
    private int yearOfProduction;
    private String registrationNumber;
    private LocalDate nextInspection;
    private int customerId;

    public Car() {
    }

    public Car(String model, String mark, int yearOfProduction, String registrationNumber, LocalDate nextInspection, int customerId) {
        this.model = model;
        this.mark = mark;
        this.yearOfProduction = yearOfProduction;
        this.registrationNumber = registrationNumber;
        this.nextInspection = nextInspection;
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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


    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public LocalDate getNextInspection() {
        return nextInspection;
    }

    public void setNextInspection(LocalDate nextInspection) {
        this.nextInspection = nextInspection;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
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
