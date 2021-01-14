package model;

import java.math.BigDecimal;

public class Employee {
    private int id;
    private String name;
    private String secondName;
    private String phone;
    private String note;
    private BigDecimal manHour;


    public Employee() {
    }

    public Employee(String name, String secondName, String phone, String note, BigDecimal manHour) {
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
        this.note = note;
        this.manHour = manHour;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigDecimal getManHour() {
        return manHour;
    }

    public void setManHour(BigDecimal manHour) {
        this.manHour = manHour;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phone='" + phone + '\'' +
                ", note='" + note + '\'' +
                ", manHour=" + manHour +
                '}';
    }
}
